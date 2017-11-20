package com.ajashop.web.common.log.mybatis.parameter;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-08-01
 * Description  :
 * Copyright ⓒ 2013-2015 Jisung Jeon All rights reserved.
 * version      : v0.1.0
 */

public class PropertiyQueryParameter extends GeneralQueryParameter {

	public PropertiyQueryParameter(Object parameter, String property) {
		super(parameter, property);
	}
	
	@Override
	public Object getParameter() {
		try {
			return PropertyUtils.getProperty(parameter, property);
		} catch (Exception e) {
			return "?";
		}
	}

}
