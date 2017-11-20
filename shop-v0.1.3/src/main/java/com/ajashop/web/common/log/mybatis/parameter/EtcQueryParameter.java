package com.ajashop.web.common.log.mybatis.parameter;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-08-01
 * Description  :
 * Copyright ⓒ 2013-2015 Jisung Jeon All rights reserved.
 * version      : v0.1.0
 */

public class EtcQueryParameter extends GeneralQueryParameter {

	public EtcQueryParameter(Object parameter, String property) {
		super(parameter, property);
	}
	
	@Override
	public Object getParameter() {
		return parameter;
	}

}
