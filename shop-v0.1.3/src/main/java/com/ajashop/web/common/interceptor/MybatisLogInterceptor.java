package com.ajashop.web.common.interceptor;


import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ajashop.web.common.log.BusinessLogUtils;
import com.ajashop.web.common.log.mybatis.MybatisQueryLog;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

@Intercepts({
	@Signature(type=StatementHandler.class, method="update", args={Statement.class}),
	@Signature(type=StatementHandler.class, method="query", args={Statement.class, ResultHandler.class})
})
public class MybatisLogInterceptor implements Interceptor {
	private final static Logger logger = LogManager.getLogger("mybatis.log");

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// String sql = MybatisQueryLog.getSql(invocation);
		// 최초실행
		String sql = MybatisQueryLog.getSql(invocation);
        logger.debug("sql : {}\n", BusinessLogUtils.getPrettyLog(sql));
		return invocation.proceed(); 
	}
	
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}
	
	@Override
	public void setProperties(Properties properties) {
	}
}
