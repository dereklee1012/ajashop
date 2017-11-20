package com.ajashop.web.common.config;

import org.springframework.stereotype.Component;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

@Component
public class CouponConfig {
	String isMms;
	String isInterMms;
	String sendCtn;
	String receiveCtn;
	String url;
	String cpId;
	String channel;
	
	public String getCpId() {
		return cpId;
	}
	public void setCpId(String cpId) {
		this.cpId = cpId;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIsMms() {
		return isMms;
	}
	public void setIsMms(String isMms) {
		this.isMms = isMms;
	}
	public String getIsInterMms() {
		return isInterMms;
	}
	public void setIsInterMms(String isInterMms) {
		this.isInterMms = isInterMms;
	}
	public String getSendCtn() {
		return sendCtn;
	}
	public void setSendCtn(String sendCtn) {
		this.sendCtn = sendCtn;
	}
	public String getReceiveCtn() {
		return receiveCtn;
	}
	public void setReceiveCtn(String receiveCtn) {
		this.receiveCtn = receiveCtn;
	}
	
}


