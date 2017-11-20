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
public class O2oConfig {
	String o2oUrl;

	public String getO2oUrl() {
		return o2oUrl;
	}

	public void setO2oUrl(String o2oUrl) {
		this.o2oUrl = o2oUrl;
	}

}
