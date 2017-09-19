package com.nms.core.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nms.core.enums.ErrorCodeEnum;
import com.nms.core.exception.CoreException;
import com.nms.core.service.UserService;
import com.nms.core.util.ParamCheckUtil;
import com.nms.core.util.ResponseFormatUtil;
import com.nms.core.util.SignUtil;

/**
 * 
 * @author cja
 * @date 2017年9月13日
 */
@RestController
@RequestMapping("/qz")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/mem/register")
    public void register(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	logger.info(request.getRequestURI()+" ==> "+JSON.toJSONString(jsonObj));
    	Map<String,Object> responseMap = new HashMap<String,Object>();
        try {
	    	if(ParamCheckUtil.isEmpty(jsonObj,"mobile_no","recmd_mobile_no","logon_pwd","tran_pwd","organ_id","channel","nonce_str","sign")){
	    		throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
	    	}
	    	SignUtil.checkSign(jsonObj);//验签
	    	Integer cust_no = userService.register(jsonObj);
            responseMap.put("cust_no", String.valueOf(cust_no));
            responseMap = ResponseFormatUtil.formatResponse(responseMap);
        } catch (CoreException e) {
            responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
        } catch (Exception e) {
        	e.printStackTrace();
            logger.debug(e.getMessage());
            responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
        }
        String toJSONString = JSON.toJSONString(responseMap);
        toJSONString = SignUtil.sign(toJSONString);//签名
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(toJSONString);
        response.getWriter().flush();
        logger.info(request.getRequestURI()+" <== "+toJSONString);
    }
    
    @RequestMapping("/sys/login")
    public void logon(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	logger.info(request.getRequestURI()+" ==> "+JSON.toJSONString(jsonObj));
    	Map<String,Object> responseMap = new HashMap<String,Object>();
    	try {
    		if(ParamCheckUtil.isEmpty(jsonObj,"mobile_no","logon_pwd","organ_id","channel","nonce_str","sign")){
    			throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
    		}
    		SignUtil.checkSign(jsonObj);//验签
    		userService.logon(jsonObj,responseMap);
    		responseMap = ResponseFormatUtil.formatResponse(responseMap);
    	} catch (CoreException e) {
    		responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
    	} catch (Exception e) {
    		e.printStackTrace();
    		logger.debug(e.getMessage());
    		responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
    	}
    	String toJSONString = JSON.toJSONString(responseMap);
    	toJSONString = SignUtil.sign(toJSONString);//签名
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write(toJSONString);
    	response.getWriter().flush();
    	logger.info(request.getRequestURI()+" <== "+toJSONString);
    }
    
    @RequestMapping("/sys/login_pwd_reset")
    public void logonPwdReset(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	logger.info(request.getRequestURI()+" ==> "+JSON.toJSONString(jsonObj));
    	Map<String,Object> responseMap = new HashMap<String,Object>();
    	try {
    		if(ParamCheckUtil.isEmpty(jsonObj,"cust_no","logon_pwd","organ_id","channel","nonce_str","sign")){
    			throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
    		}
    		SignUtil.checkSign(jsonObj);//验签
    		userService.logonPwdReset(jsonObj);
    		responseMap = ResponseFormatUtil.formatResponse(responseMap);
    	} catch (CoreException e) {
    		responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
    	} catch (Exception e) {
    		e.printStackTrace();
    		logger.debug(e.getMessage());
    		responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
    	}
    	String toJSONString = JSON.toJSONString(responseMap);
    	toJSONString = SignUtil.sign(toJSONString);//签名
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write(toJSONString);
    	response.getWriter().flush();
    	logger.info(request.getRequestURI()+" <== "+toJSONString);
    }
    
    @RequestMapping("/sys/login_pwd_modify")
    public void logonPwdModify(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	logger.info(request.getRequestURI()+" ==> "+JSON.toJSONString(jsonObj));
    	Map<String,Object> responseMap = new HashMap<String,Object>();
    	try {
    		if(ParamCheckUtil.isEmpty(jsonObj,"cust_no","logon_pwd_old","logon_pwd_new","organ_id","channel","nonce_str","sign")){
    			throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
    		}
    		SignUtil.checkSign(jsonObj);//验签
    		userService.logonPwdModify(jsonObj);
    		responseMap = ResponseFormatUtil.formatResponse(responseMap);
    	} catch (CoreException e) {
    		responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
    	} catch (Exception e) {
    		e.printStackTrace();
    		logger.debug(e.getMessage());
    		responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
    	}
    	String toJSONString = JSON.toJSONString(responseMap);
    	toJSONString = SignUtil.sign(toJSONString);//签名
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write(toJSONString);
    	response.getWriter().flush();
    	logger.info(request.getRequestURI()+" <== "+toJSONString);
    }
    
    @RequestMapping("/sys/tran_pwd_modify")
    public void tranPwdModify(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	logger.info(request.getRequestURI()+" ==> "+JSON.toJSONString(jsonObj));
    	Map<String,Object> responseMap = new HashMap<String,Object>();
    	try {
    		if(ParamCheckUtil.isEmpty(jsonObj,"cust_no","tran_pwd_old","tran_pwd_new","organ_id","channel","nonce_str","sign")){
    			throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
    		}
    		SignUtil.checkSign(jsonObj);//验签
    		userService.tranPwdModify(jsonObj);
    		responseMap = ResponseFormatUtil.formatResponse(responseMap);
    	} catch (CoreException e) {
    		responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
    	} catch (Exception e) {
    		e.printStackTrace();
    		logger.debug(e.getMessage());
    		responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
    	}
    	String toJSONString = JSON.toJSONString(responseMap);
    	toJSONString = SignUtil.sign(toJSONString);//签名
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write(toJSONString);
    	response.getWriter().flush();
    	logger.info(request.getRequestURI()+" <== "+toJSONString);
    }
    
    @RequestMapping("/sys/tran_pwd_reset")
    public void tranPwdReset(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	logger.info(request.getRequestURI()+" ==> "+JSON.toJSONString(jsonObj));
    	Map<String,Object> responseMap = new HashMap<String,Object>();
    	try {
    		if(ParamCheckUtil.isEmpty(jsonObj,"cust_no","tran_pwd","organ_id","channel","nonce_str","sign")){
    			throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
    		}
    		SignUtil.checkSign(jsonObj);//验签
    		userService.tranPwdReset(jsonObj);
    		responseMap = ResponseFormatUtil.formatResponse(responseMap);
    	} catch (CoreException e) {
    		responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
    	} catch (Exception e) {
    		e.printStackTrace();
    		logger.debug(e.getMessage());
    		responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
    	}
    	String toJSONString = JSON.toJSONString(responseMap);
    	toJSONString = SignUtil.sign(toJSONString);//签名
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write(toJSONString);
    	response.getWriter().flush();
    	logger.info(request.getRequestURI()+" <== "+toJSONString);
    }
    
    @RequestMapping("/sys/reg_mobile_change")
    public void regMobileChange(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	logger.info(request.getRequestURI()+" ==> "+JSON.toJSONString(jsonObj));
    	Map<String,Object> responseMap = new HashMap<String,Object>();
    	try {
    		if(ParamCheckUtil.isEmpty(jsonObj,"cust_no","mobile_no_new","logon_pwd","organ_id","channel","nonce_str","sign")){
    			throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
    		}
    		SignUtil.checkSign(jsonObj);//验签
    		userService.regMobileChange(jsonObj);
    		responseMap = ResponseFormatUtil.formatResponse(responseMap);
    	} catch (CoreException e) {
    		responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
    	} catch (Exception e) {
    		e.printStackTrace();
    		logger.debug(e.getMessage());
    		responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
    	}
    	String toJSONString = JSON.toJSONString(responseMap);
    	toJSONString = SignUtil.sign(toJSONString);//签名
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write(toJSONString);
    	response.getWriter().flush();
    	logger.info(request.getRequestURI()+" <== "+toJSONString);
    }
    
    @RequestMapping("/mem/reg_info_update")
    public void regInfoUpdate(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	logger.info(request.getRequestURI()+" ==> "+JSON.toJSONString(jsonObj));
    	Map<String,Object> responseMap = new HashMap<String,Object>();
    	try {
    		if(ParamCheckUtil.isEmpty(jsonObj,"cust_no","organ_id","channel","nonce_str","sign")){
    			throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
    		}
    		SignUtil.checkSign(jsonObj);//验签
    		userService.regInfoUpdate(jsonObj);
    		responseMap = ResponseFormatUtil.formatResponse(responseMap);
    	} catch (CoreException e) {
    		responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
    	} catch (Exception e) {
    		e.printStackTrace();
    		logger.debug(e.getMessage());
    		responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
    	}
    	String toJSONString = JSON.toJSONString(responseMap);
    	toJSONString = SignUtil.sign(toJSONString);//签名
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write(toJSONString);
    	response.getWriter().flush();
    	logger.info(request.getRequestURI()+" <== "+toJSONString);
    }

    @RequestMapping("/mem/ns_identify")
    public void nsIdentify(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	logger.info(request.getRequestURI()+" ==> "+JSON.toJSONString(jsonObj));
    	Map<String,Object> responseMap = new HashMap<String,Object>();
    	try {
    		if(ParamCheckUtil.isEmpty(jsonObj,"cust_no","corpor_name","cert_no","legal_person","regist_addr",
    				"auth_state","img_busi_lic_url","busi_lic_due","organ_id","channel","nonce_str","sign")){
    			throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
    		}
    		SignUtil.checkSign(jsonObj);//验签
    		userService.nsIdentify(jsonObj);
    		responseMap = ResponseFormatUtil.formatResponse(responseMap);
    	} catch (CoreException e) {
    		responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
    	} catch (Exception e) {
    		e.printStackTrace();
    		logger.debug(e.getMessage());
    		responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
    	}
    	String toJSONString = JSON.toJSONString(responseMap);
    	toJSONString = SignUtil.sign(toJSONString);//签名
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write(toJSONString);
    	response.getWriter().flush();
    	logger.info(request.getRequestURI()+" <== "+toJSONString);
    }
    
    @RequestMapping("/mem/ns_identified_info_qry")
    public void nsIdentifiedInfoQry(@RequestBody JSONObject jsonObj, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	logger.info(request.getRequestURI()+" ==> "+JSON.toJSONString(jsonObj));
    	Map<String,Object> responseMap = new HashMap<String,Object>();
    	try {
    		if(ParamCheckUtil.isEmpty(jsonObj,"cust_no","organ_id","channel","nonce_str","sign")){
    			throw new CoreException(ErrorCodeEnum.PARAMEMPTY);
    		}
    		SignUtil.checkSign(jsonObj);//验签
    		userService.nsIdentifiedInfoQry(jsonObj,responseMap);
    		responseMap = ResponseFormatUtil.formatResponse(responseMap);
    	} catch (CoreException e) {
    		responseMap = ResponseFormatUtil.formatResponseError(e.getEce());
    	} catch (Exception e) {
    		e.printStackTrace();
    		logger.debug(e.getMessage());
    		responseMap = ResponseFormatUtil.formatResponseError(ErrorCodeEnum.INTERERROR);
    	}
    	String toJSONString = JSON.toJSONString(responseMap);
    	toJSONString = SignUtil.sign(toJSONString);//签名
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write(toJSONString);
    	response.getWriter().flush();
    	logger.info(request.getRequestURI()+" <== "+toJSONString);
    }

}