package com.ajashop.web.common.secure;


import org.apache.commons.codec.binary.Base64;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

public class PasswordUtils {

	public static String makePassword(String planText) throws Exception {
		byte[] hashedBytes = HashUtils.encodingSHA1(planText.getBytes());
		String password = Base64.encodeBase64String(hashedBytes);
		return password;
	}
}
