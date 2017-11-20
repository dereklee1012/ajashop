package com.ajashop.web.common.util;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

public class FileUtils {
	public static String getExtention(String uri) {
		if(uri == null) return "";
		
		int pos = uri.lastIndexOf(".");
		if(pos == -1) return "";
		
		String extention = uri.substring( pos + 1 );
		return extention;
	}
	
	public static String removeExtention(String uri) {
		if(uri == null) return "";
		
		int pos = uri.lastIndexOf(".");
		if(pos == -1) return uri;
		
		return uri.substring(0, pos);
	}
}
