package com.ajashop.web.common.exception;

public class AjaxException extends Exception{
	private static final long serialVersionUID = -6048580843364126395L;

	private int httpStatus;
	private String errCode;	
	
	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public AjaxException() {
		super();
	}

	public AjaxException(String message, Throwable cause) {
		super(message, cause);
	}

	public AjaxException(String errCode, String message, Throwable cause) {
		super(message, cause);
		this.errCode = errCode;
	}
	
	public AjaxException(String message) {
		super(message);
	}
	
	public AjaxException(String errCode, String message) {
		super(message);
		this.errCode = errCode;
	}
	
	public AjaxException(int httpStatus, String errCode, String message) {
		super(message);
		this.errCode = errCode;
		this.httpStatus = httpStatus;
	}

	public AjaxException(Throwable cause) {
		super(cause);
	}

}
