package com.ajashop.web.common.constants;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

public class WebErrors {

	public static final class Authentication {
		public static final int LOGIN = 100;  
		public static final int MENU = 101;
	}
	
	public static final class Message {
		public static final String unauthorized = "인증실패";  	// 인증 실패
		public static final String forbidden = "페이지 접근 권한이 없습니다.";	// 권한 없음
	}
}
