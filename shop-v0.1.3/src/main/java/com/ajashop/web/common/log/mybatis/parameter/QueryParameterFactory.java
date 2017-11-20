package com.ajashop.web.common.log.mybatis.parameter;

import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-08-01
 * Description  :
 * Copyright ⓒ 2013-2015 Jisung Jeon All rights reserved.
 * version      : v0.1.0
 */

public class QueryParameterFactory {
	private Object parameter;
	private String property;
	
	public static GeneralQueryParameter getQueryParameter(Object parameter, String property) {
		return new QueryParameterFactory(parameter, property).getQueryParameter();
	}
	
	private QueryParameterFactory(Object parameter, String property) {
		this.parameter = parameter;
		this.property = property;
	}
	
	private GeneralQueryParameter getQueryParameter() {
		if(PropertyUtils.isReadable(parameter, property)) {
			return new PropertiyQueryParameter(parameter, property);
		} 
		if(parameter instanceof Map) {
			return new MapQueryParameter(parameter, property);
		} 
		return new EtcQueryParameter(parameter, property);
	}
}
