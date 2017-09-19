package com.nms.core.exception;

import com.nms.core.enums.ErrorCodeEnum;

/**
 * 异常处理类
 * @author cja
 * @date 2017年9月17日
 */
public class CoreException extends RuntimeException {
	
	private ErrorCodeEnum ece;

	private static final long serialVersionUID = 1L;

	public CoreException() {
		super();
	}
	public CoreException(ErrorCodeEnum ece) {
		super(ece.getText());
		this.ece = ece;
	}
	public ErrorCodeEnum getEce() {
		return ece;
	}
}
