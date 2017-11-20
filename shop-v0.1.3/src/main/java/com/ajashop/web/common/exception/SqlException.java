package com.ajashop.web.common.exception;

public class SqlException extends Exception{
	private static final long serialVersionUID = -6048580843364126395L;

	private String errCode;	
	private String sessionKey;	
	private String runningTime;
	
	private Object data;
	
	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public SqlException() {
		super();
	}

	public SqlException(String message, Throwable cause) {
		super(message, cause);
	}

	public SqlException(String errCode, String message, Throwable cause) {
		super(message, cause);
		this.errCode = errCode;
	}
	
	public SqlException(String errCode, String message, String sessionkey) {
		super(message);
		this.errCode = errCode;
		this.sessionKey = sessionkey;
	}
	
	public SqlException(String message) {
		super(message);
	}
	
	public SqlException(String errCode, String message) {
		super(message);
		this.errCode = errCode;
	}

	public SqlException(Throwable cause) {
		super(cause);
	}

	/**
	 * @return  Returns the data.
	 * @uml.property  name="data"
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data  The data to set.
	 * @uml.property  name="data"
	 */
	public void setData(Object data) {
		this.data = data;
	}
	
	public SqlException(String errCode, String message, Object data, Throwable cause) {
		super(message, cause);
		this.errCode = errCode;
		this.data = data;
	}
	
	public SqlException(String errCode, String message, Object data){
		super(message);
		this.errCode = errCode;
		this.data = data;
	}

}
