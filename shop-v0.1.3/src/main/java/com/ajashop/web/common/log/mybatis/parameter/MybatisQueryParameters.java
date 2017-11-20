package com.ajashop.web.common.log.mybatis.parameter;

import java.util.ArrayList;
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

public class MybatisQueryParameters {
	private Object parameter;
	private List<String> propertys;
	
	public static List<Object> getParameterList(QueryParameterVo queryParameterVo) {
		return new MybatisQueryParameters(queryParameterVo.getParameter(), queryParameterVo.getParameterMappings()).getParameterList();
	}
	
	private MybatisQueryParameters(Object parameter, List<ParameterMapping> parameterMappings) {
		this.parameter = parameter;
		this.setPropertys(parameterMappings);
	}
	
	private void setPropertys(List<ParameterMapping> parameterMappings) {
		propertys = new ArrayList<String>();
		for(int i = 0;i<parameterMappings.size();i++) {
			String property = parameterMappings.get(i).getProperty();
			propertys.add(property);
		}
	}
	
	private List<Object> getParameterList() {
		List<Object> parameterList = new ArrayList<Object>();
		for(int i = 0;i<propertys.size();i++) {
			Object parameter = getParameter(propertys.get(i));
			parameterList.add(parameter);
		}
		return parameterList;
	}
	
	private Object getParameter(String property) {
		GeneralQueryParameter queryParameter = QueryParameterFactory.getQueryParameter(parameter, property);
		return queryParameter.getParameter();
	}
}
