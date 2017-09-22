package com.nms.core.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nms.core.dao.AccountMapper;
import com.nms.core.dao.UserMapper;
import com.nms.core.entity.Account;
import com.nms.core.entity.User;
import com.nms.core.enums.ErrorCodeEnum;
import com.nms.core.exception.CoreException;
import com.nms.core.service.UserService;
import com.nms.core.util.DateUtil;
import com.nms.core.util.Des3Util;
import com.nms.core.util.SequenceUtil;
import com.nms.core.util.helper.SettingHelper;
import com.nms.core.util.kit.HashKit;

/**
 * @author cja
 * @date 2017年9月13日
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private SequenceUtil sequenceUtil;
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Transactional
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
        //生成3个账户：诺宝账户、诺券账户、诺积分账户
        //账户生成规则：5位机构号+2位账户类型+5位科目+8位顺序号，如：一个诺宝账户70001012010100000001
        //账户类型：01=诺宝账户；02=诺卷账户；03=诺积分账户；04=内部账户
        //科目：诺宝账户20101 诺券账户20202 诺积分账户20301
        String organ_id = jsonObj.getString("organ_id");//机构号：法人代码（机构代码）
        Account acct = new Account();
        String cust_no = String.valueOf(user.getId());
        String cust_name = user.getName()==null?"":user.getName();
        acct.setCust_no(cust_no);
        acct.setCust_name(cust_name);
        acct.setOpen_date(new Date());
        acct.setStop_payment_type(0);//止付标志：0=正常；1=止付
        acct.setAcct_status(0);//帐户状态：0=正常；1=销户
        String des3Key = SettingHelper.getSetting("des3Key");
        //生成诺宝账户
        String acctNo1 = organ_id + "0120101" + sequenceUtil.getNextAcctSeqNo("01");
        String subAcctSeqNo1 = sequenceUtil.getNextSubAcctSeqNo(acctNo1);
        acct.setAcct_no(acctNo1);
        acct.setAcct_seqno(subAcctSeqNo1);
        acct.setAcct_type("01");
        acct.setSub_code("20101");
        /*DAC安全码:
		帐号（acct_no）|帐户序号（acct_seqno）|币种（cur_code）|客户姓名(cust_name)|客户编号(cust_no) 
        |最后交易日期(last_trans_date)|最后账务日期(last_acct_date)|余额（acct_bal）|昨日余额(acct_pre_bal) 
		|利息积数（acct_accum）|止付标志（stop_payment_type）|帐户状态（acct_status）*/
        String dac1 = acctNo1+"|"+subAcctSeqNo1+"||"+cust_name+"|"+cust_no+"|||0.00||0.00|0|0";
//        System.out.println("dac1:"+dac1);
//        System.out.println("dac1Hash:"+HashKit.sha256(dac1));
        acct.setDac(Des3Util.encString(des3Key, HashKit.sha256(dac1)));
        accountMapper.insertSelective(acct);
        //生成诺券账户
        String acctNo2 = organ_id + "0220202" + sequenceUtil.getNextAcctSeqNo("02");
        String subAcctSeqNo2 = sequenceUtil.getNextSubAcctSeqNo(acctNo2);
        acct.setAcct_no(acctNo2);
        acct.setAcct_seqno(subAcctSeqNo2);
        acct.setAcct_type("02");
        acct.setSub_code("20202");
        String dac2 = acctNo2+"|"+subAcctSeqNo2+"||"+cust_name+"|"+cust_no+"|||0.00||0.00|0|0";
//        System.out.println("dac2:"+dac2);
//        System.out.println("dac2Hash:"+HashKit.sha256(dac2));
        acct.setDac(Des3Util.encString(des3Key, HashKit.sha256(dac2)));
        accountMapper.insertSelective(acct);
        //生成诺积分账户
        String acctNo3 = organ_id + "0320301" + sequenceUtil.getNextAcctSeqNo("03");
        String subAcctSeqNo3 = sequenceUtil.getNextSubAcctSeqNo(acctNo3);
        acct.setAcct_no(acctNo3);
        acct.setAcct_seqno(subAcctSeqNo3);
        acct.setAcct_type("03");
        acct.setSub_code("20301");
        String dac3 = acctNo3+"|"+subAcctSeqNo3+"||"+cust_name+"|"+cust_no+"|||0.00||0.00|0|0";
//        System.out.println("dac3:"+dac3);
//        System.out.println("dac3Hash:"+HashKit.sha256(dac3));
        acct.setDac(Des3Util.encString(des3Key, HashKit.sha256(dac3)));
        accountMapper.insertSelective(acct);
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
