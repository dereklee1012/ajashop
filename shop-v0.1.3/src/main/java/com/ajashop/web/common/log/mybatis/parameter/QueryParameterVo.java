package com.ajashop.web.common.log.mybatis.parameter;

import java.util.List;

import org.apache.ibatis.mapping.ParameterMapping;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-08-01
 * Description  :
 * Copyright ⓒ 2013-2015 Jisung Jeon All rights reserved.
 * version      : v0.1.0
 */

public class QueryParameterVo {
	Object parameter;
	List<ParameterMapping> parameterMappings;
	
	public Object getParameter() {
		return parameter;
	}
	public void setParameter(Object parameter) {
		this.parameter = parameter;
	}
	public List<ParameterMapping> getParameterMappings() {
		return parameterMappings;
	}
	public void setParameterMappings(List<ParameterMapping> parameterMappings) {
		this.parameterMappings = parameterMappings;
	}
	
}
