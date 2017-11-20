package com.ajashop.web.common.util;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

import java.util.concurrent.atomic.AtomicLong;

public class SequenceUtil {

	private final static SequenceUtil instance 	= new SequenceUtil();
	private final String dateFormat 			= "yyyyMMddHHmmss";
	private final AtomicLong sequence 			= new AtomicLong();
	private int sessionKeyLength 				= 30;


	public static SequenceUtil getInstance() {
		return instance;
	}
	
	public synchronized String getSessionKey() {
		
		return StringUtil.getCurrentTime(dateFormat) + StringUtil.long2ZeroFillString(nextVal(), sessionKeyLength - dateFormat.length() );
	}
	
	public synchronized long nextVal() {		
		return sequence.incrementAndGet();
	}
	
	public static void main(String[] args) {
		
		for(int i = 0;i<10;i++) {
			SimpleStopWatch ssw = new SimpleStopWatch();
			System.out.println(SequenceUtil.getInstance().getSessionKey());
			System.out.println(ssw.getRunningTime());
		}
	}
}
