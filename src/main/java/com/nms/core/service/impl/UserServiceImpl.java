package com.nms.core.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nms.core.dao.UserMapper;
import com.nms.core.entity.User;
import com.nms.core.enums.ErrorCodeEnum;
import com.nms.core.exception.CoreException;
import com.nms.core.service.UserService;
import com.nms.core.util.DateUtil;
import com.nms.core.util.kit.HashKit;

/**
 * @author cja
 * @date 2017年9月13日
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Integer register(JSONObject jsonObj) {
		User user = JSON.toJavaObject(jsonObj, User.class);
		User user1 = userMapper.selectByMobile(user.getMobile_no());
		if(user1 != null){
			throw new CoreException(ErrorCodeEnum.USEREXITS);
		}
        String recmd_mobile_no = jsonObj.getString("recmd_mobile_no");//推荐人手机号
        User recUser = userMapper.selectByMobile(recmd_mobile_no);
        user.setRec_id(recUser!=null?recUser.getId():null);
        user.setLogon_pwd(HashKit.md5(jsonObj.getString("logon_pwd")));
        user.setTran_pwd(HashKit.md5(jsonObj.getString("tran_pwd")));
        user.setStar_lvl(1);
        user.setState(0);
        user.setType(1);
        user.setReg_date(new Date());
        userMapper.insertSelective(user);
		return user.getId();
	}

	@Override
	public void logon(JSONObject jsonObj, Map<String, Object> responseMap) {
		String mobile_no = jsonObj.getString("mobile_no");
		User user = userMapper.selectByMobile(mobile_no);
		if(user == null){
			throw new CoreException(ErrorCodeEnum.USERNOTEXITS);
		}
		String logon_pwd = jsonObj.getString("logon_pwd");
		user = userMapper.selectByMobileAndLogonPwd(mobile_no,HashKit.md5(logon_pwd));
		if(user == null){
			throw new CoreException(ErrorCodeEnum.LOGONPWDERROR);
		}
		User upUser = userMapper.selectByPrimaryKey(user.getUp_id());
		User recUser = userMapper.selectByPrimaryKey(user.getRec_id());
		responseMap.put("cust_no", String.valueOf(user.getId()));
		responseMap.put("alias", user.getAlias());
		responseMap.put("name", user.getName());
		responseMap.put("cert_no", user.getCert_no());
		responseMap.put("star_lvl", String.valueOf(user.getStar_lvl()));
		responseMap.put("area_belong", user.getArea_belong());
		responseMap.put("state", String.valueOf(user.getState()));
		responseMap.put("up_cust_no", user.getUp_id()!=null?String.valueOf(user.getUp_id()):null);
		responseMap.put("up_cust_name", upUser!=null?upUser.getName():null);
		responseMap.put("up_cust_mobile", upUser!=null?upUser.getMobile_no():null);
		responseMap.put("rec_cust_no", user.getRec_id()!=null?String.valueOf(user.getRec_id()):null);
		responseMap.put("rec_cust_name", recUser!=null?recUser.getName():null);
		responseMap.put("rec_cust_mobile", recUser!=null?recUser.getMobile_no():null);
		responseMap.put("head_quarter", user.getHead_quarter());
	}

	@Override
	public int logonPwdReset(JSONObject jsonObj) {
		Integer cust_no = Integer.parseInt(jsonObj.getString("cust_no"));
		User user = userMapper.selectByPrimaryKey(cust_no);
		if(user == null){
			throw new CoreException(ErrorCodeEnum.USERNOTEXITS);
		}
		String logon_pwd = jsonObj.getString("logon_pwd");
		return userMapper.updateLogonPwdById(cust_no,HashKit.md5(logon_pwd));
	}

	@Override
	public int logonPwdModify(JSONObject jsonObj) {
		Integer cust_no = Integer.parseInt(jsonObj.getString("cust_no"));
		User user = userMapper.selectByPrimaryKey(cust_no);
		if(user == null){
			throw new CoreException(ErrorCodeEnum.USERNOTEXITS);
		}
		String logon_pwd_old = jsonObj.getString("logon_pwd_old");
		user = userMapper.selectByIdAndLogonPwd(cust_no,HashKit.md5(logon_pwd_old));
		if(user == null){
			throw new CoreException(ErrorCodeEnum.OLDLOGONPWDERROR);
		}
		String logon_pwd_new = jsonObj.getString("logon_pwd_new");
		return userMapper.updateLogonPwdById(cust_no,HashKit.md5(logon_pwd_new));
	}

	@Override
	public int tranPwdModify(JSONObject jsonObj) {
		Integer cust_no = Integer.parseInt(jsonObj.getString("cust_no"));
		User user = userMapper.selectByPrimaryKey(cust_no);
		if(user == null){
			throw new CoreException(ErrorCodeEnum.USERNOTEXITS);
		}
		String tran_pwd_old = jsonObj.getString("tran_pwd_old");
		user = userMapper.selectByIdAndTranPwd(cust_no,HashKit.md5(tran_pwd_old));
		if(user == null){
			throw new CoreException(ErrorCodeEnum.OLDTRANPWDERROR);
		}
		String tran_pwd_new = jsonObj.getString("tran_pwd_new");
		return userMapper.updateTranPwdById(cust_no,HashKit.md5(tran_pwd_new));
	}

	@Override
	public int tranPwdReset(JSONObject jsonObj) {
		Integer cust_no = Integer.parseInt(jsonObj.getString("cust_no"));
		User user = userMapper.selectByPrimaryKey(cust_no);
		if(user == null){
			throw new CoreException(ErrorCodeEnum.USERNOTEXITS);
		}
		String tran_pwd = jsonObj.getString("tran_pwd");
		return userMapper.updateTranPwdById(cust_no,HashKit.md5(tran_pwd));
	}

	@Override
	public int regMobileChange(JSONObject jsonObj) {
		Integer cust_no = Integer.parseInt(jsonObj.getString("cust_no"));
		User user = userMapper.selectByPrimaryKey(cust_no);
		if(user == null){
			throw new CoreException(ErrorCodeEnum.USERNOTEXITS);
		}
		String logon_pwd = jsonObj.getString("logon_pwd");
		user = userMapper.selectByIdAndLogonPwd(cust_no,HashKit.md5(logon_pwd));
		if(user == null){
			throw new CoreException(ErrorCodeEnum.LOGONPWDERROR);
		}
		String mobile_no_new = jsonObj.getString("mobile_no_new");
		if(mobile_no_new.equals(user.getMobile_no())){
			throw new CoreException(ErrorCodeEnum.MOBILENOCHANGE);
		}
		User user1 = userMapper.selectByMobile(mobile_no_new);
		if(user1 != null){
			throw new CoreException(ErrorCodeEnum.NEWMOBILEEXITS);
		}
		return userMapper.updateMobileById(cust_no,mobile_no_new);
	}

	@Override
	public int regInfoUpdate(JSONObject jsonObj) {
		Integer cust_no = Integer.parseInt(jsonObj.getString("cust_no"));
		User user1 = userMapper.selectByPrimaryKey(cust_no);
		if(user1 == null){
			throw new CoreException(ErrorCodeEnum.USERNOTEXITS);
		}
		User user = JSON.toJavaObject(jsonObj, User.class);
		user.setId(cust_no);
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public int nsIdentify(JSONObject jsonObj) {
		Integer cust_no = Integer.parseInt(jsonObj.getString("cust_no"));
		User user1 = userMapper.selectByPrimaryKey(cust_no);
		if(user1 == null){
			throw new CoreException(ErrorCodeEnum.USERNOTEXITS);
		}
		User user = JSON.toJavaObject(jsonObj, User.class);
		user.setId(cust_no);
		String regist_no = jsonObj.getString("cert_no");//注册号
		user.setCert_no(null);
		user.setRegist_no(regist_no);
		String busi_lic_due = jsonObj.getString("busi_lic_due");//营业执照有效期（YYYYMMDD长期：99991231）
		user.setBusi_lic_due(DateUtil.string2Date(busi_lic_due));
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void nsIdentifiedInfoQry(JSONObject jsonObj, Map<String, Object> responseMap) {
		Integer cust_no = Integer.parseInt(jsonObj.getString("cust_no"));
		User user = userMapper.selectByPrimaryKey(cust_no);
		if(user == null){
			throw new CoreException(ErrorCodeEnum.USERNOTEXITS);
		}
		responseMap.put("corpor_name", user.getCorpor_name());
		responseMap.put("cert_no", user.getRegist_no());
		responseMap.put("legal_person", user.getLegal_person());
		responseMap.put("regist_addr", user.getRegist_addr());
		responseMap.put("auth_state", user.getAuth_state()!=null?String.valueOf(user.getAuth_state()):null);
		responseMap.put("img_busi_lic_url", user.getImg_busi_lic_url());
		responseMap.put("busi_lic_due", user.getBusi_lic_due()!=null?DateUtil.Date2String(user.getBusi_lic_due()):null);
	}

}
