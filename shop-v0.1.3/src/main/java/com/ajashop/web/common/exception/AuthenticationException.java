package com.ajashop.web.common.exception;

public class AuthenticationException extends Exception {
	private static final long serialVersionUID = -9831939593561526L;
	
	String redirectUrl;
	int code;
	
	public AuthenticationException() {
		super();
	}
	
    public AuthenticationException(String redirectUrl, int code) {
    	super();
    	this.redirectUrl = redirectUrl;
    	this.code = code;
    }

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	
    
}
