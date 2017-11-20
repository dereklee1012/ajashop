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
public class ErpConfig {
	String erpUrl;

	public String getErpUrl() {
		return erpUrl;
	}

	public void setErpUrl(String erpUrl) {
		this.erpUrl = erpUrl;
	}

	
}
