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
public class ServiceConfig {
	String defaultApiKey;
	String defaultLati;
	String defaultLogi;
	String urlImg;
	long userLimit;
	String androidDownloadURL;
	String iosDownloadURL;
	
	public long getUserLimit() {
		return userLimit;
	}
	public void setUserLimit(long userLimit) {
		this.userLimit = userLimit;
	}
	public String getDefaultLati() {
		return defaultLati;
	}
	public void setDefaultLati(String defaultLati) {
		this.defaultLati = defaultLati;
	}
	public String getDefaultLogi() {
		return defaultLogi;
	}
	public void setDefaultLogi(String defaultLogi) {
		this.defaultLogi = defaultLogi;
	}
	public String getAndroidDownloadURL() {
		return androidDownloadURL;
	}
	public void setAndroidDownloadURL(String androidDownloadURL) {
		this.androidDownloadURL = androidDownloadURL;
	}
	public String getIosDownloadURL() {
		return iosDownloadURL;
	}
	public void setIosDownloadURL(String iosDownloadURL) {
		this.iosDownloadURL = iosDownloadURL;
	}
	public String getDefaultApiKey() {
		return defaultApiKey;
	}
	public void setDefaultApiKey(String defaultApiKey) {
		this.defaultApiKey = defaultApiKey;
	}
	public String getUrlImg() {
		return urlImg;
	}
	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}
	
}
