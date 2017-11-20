package com.ajashop.web.common.threadlocal;

public class GeneralLogInfo {
	String sessionKey;
	String runningTime;
	long logStartNanoTime;
	Object response;
	
	public String getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}

	
	public long getLogStartNanoTime() {
		return logStartNanoTime;
	}

	public void setLogStartNanoTime(long logStartNanoTime) {
		this.logStartNanoTime = logStartNanoTime;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
	
	
	
}
