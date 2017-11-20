package com.ajashop.web.common.log.mybatis.parameter;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-08-01
 * Description  :
 * Copyright ⓒ 2013-2015 Jisung Jeon All rights reserved.
 * version      : v0.1.0
 */

public abstract class GeneralQueryParameter {
	public Object parameter;
	public String property;
	
	public GeneralQueryParameter(Object parameter, String property) {
		this.parameter = parameter;
		this.property = property;
	}
	
	public abstract Object getParameter();
}
