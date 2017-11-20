package com.ajashop.web.common.log;

import com.ajashop.web.common.threadlocal.GeneralLogInfo;
import com.ajashop.web.common.threadlocal.GeneralLogThreadLocal;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-08-01
 * Description  :
 * Copyright ⓒ 2013-2015 Jisung Jeon All rights reserved.
 * version      : v0.1.0
 */

public class BusinessLogUtils {

	public static String getPrettyLog(String message) {
		final StringBuilder logBuilder = new StringBuilder();
		final GeneralLogInfo generalLogInfo = GeneralLogThreadLocal.currentGeneralLogInfo();
		
		logBuilder.append(String.format("[sessionKey : %1$s] %2$s", generalLogInfo.getSessionKey(), message));
		
		return logBuilder.toString();
	}
}
