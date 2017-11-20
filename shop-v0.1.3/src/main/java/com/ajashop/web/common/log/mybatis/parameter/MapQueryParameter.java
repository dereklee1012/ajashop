package com.ajashop.web.common.log.mybatis.parameter;

import java.util.Map;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-08-01
 * Description  :
 * Copyright ⓒ 2013-2015 Jisung Jeon All rights reserved.
 * version      : v0.1.0
 */

public class MapQueryParameter extends GeneralQueryParameter {

	public MapQueryParameter(Object parameter, String property) {
		super(parameter, property);
	}
	
	@Override
	public Object getParameter() {
		return ((Map<?, ?>) parameter ).get(property);
	}
}
