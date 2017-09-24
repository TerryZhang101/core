package com.nms.core.enums;

/**
 * 错误码枚举类
 * @author cja
 * @date 2017年9月17日
 */
public enum ErrorCodeEnum {
	INTERERROR("10000", "内部服务器错误"),
	
	CHECKSIGNERROR("20000", "验证签名失败"),
	PARAMEMPTY("20001", "必输字段为空"),
	DATEFORMATERROR("20002", "日期格式错误"),
	USEREXITS("21000", "用户已存在"),
	USERNOTEXITS("21001", "用户不存在"),
	LOGONPWDERROR("21002", "登录密码不正确"),
	OLDLOGONPWDERROR("21003", "原登录密码不正确"),
	OLDTRANPWDERROR("21004", "原交易密码不正确"),
	MOBILENOCHANGE("21005", "新手机号与原手机号一样"),
	NEWMOBILEEXITS("21006", "新手机号已被占用"),
	PAY_ACCT_NOT_EXITS("21007", "付款人账号信息不存在"),
	REC_ACCT_NOT_EXITS("21008", "收款人账号信息不存在");

	
	private String value;
	private String text;
	
	private ErrorCodeEnum(String value, String text) {
		this.value = value;
		this.text = text;
	}
	
	public String getValue() {
		return value;
	}

	public String getText() {
		return text;
	}
	
	public static String getText(String value) {
		for (ErrorCodeEnum typeEnum : ErrorCodeEnum.values()) {
			if (value.equals(typeEnum.getValue())) {
				return typeEnum.getText();
			}
		}
		return null;
	}
	
	public static ErrorCodeEnum get(String value) {
		for (ErrorCodeEnum typeEnum : ErrorCodeEnum.values()) {
			if (value.equals(typeEnum.getValue())) {
				return typeEnum;
			}
		}
		return null;
	}
}
