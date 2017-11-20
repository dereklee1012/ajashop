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
public class PayMentConfig {
	String currency;
	String inputCharset;
	String partnerId;
	String md5Key;
	String signType;
	String notifyUrl;
	String httpsVerifyUrl;
	String alipayGatewayUrl;
	String supplier;
	String timeoutRule;
	String returnUrlPrefix;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAlipayGatewayUrl() {
		return alipayGatewayUrl;
	}
	public void setAlipayGatewayUrl(String alipayGatewayUrl) {
		this.alipayGatewayUrl = alipayGatewayUrl;
	}
	public String getInputCharset() {
		return inputCharset;
	}
	public void setInputCharset(String inputCharset) {
		this.inputCharset = inputCharset;
	}
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public String getMd5Key() {
		return md5Key;
	}
	public void setMd5Key(String md5Key) {
		this.md5Key = md5Key;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	public String getHttpsVerifyUrl() {
		return httpsVerifyUrl;
	}
	public void setHttpsVerifyUrl(String httpsVerifyUrl) {
		this.httpsVerifyUrl = httpsVerifyUrl;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getTimeoutRule() {
		return timeoutRule;
	}
	public void setTimeoutRule(String timeoutRule) {
		this.timeoutRule = timeoutRule;
	}
	public String getReturnUrlPrefix() {
		return returnUrlPrefix;
	}
	public void setReturnUrlPrefix(String returnUrlPrefix) {
		this.returnUrlPrefix = returnUrlPrefix;
	}
	
	
}
