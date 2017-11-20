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
public class SnsConfig {
	String korUrl;
	String intlUrl;
	String usercode;
	String deptcode;
	String fromNum1;
	String fromNum2;
	String fromNum3;
	String rurl;
	public String getKorUrl() {
		return korUrl;
	}
	public void setKorUrl(String korUrl) {
		this.korUrl = korUrl;
	}
	public String getIntlUrl() {
		return intlUrl;
	}
	public void setIntlUrl(String intlUrl) {
		this.intlUrl = intlUrl;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getDeptcode() {
		return deptcode;
	}
	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}
	public String getFromNum1() {
		return fromNum1;
	}
	public void setFromNum1(String fromNum1) {
		this.fromNum1 = fromNum1;
	}
	public String getFromNum2() {
		return fromNum2;
	}
	public void setFromNum2(String fromNum2) {
		this.fromNum2 = fromNum2;
	}
	public String getFromNum3() {
		return fromNum3;
	}
	public void setFromNum3(String fromNum3) {
		this.fromNum3 = fromNum3;
	}
	public String getRurl() {
		return rurl;
	}
	public void setRurl(String rurl) {
		this.rurl = rurl;
	}
	
	
}
