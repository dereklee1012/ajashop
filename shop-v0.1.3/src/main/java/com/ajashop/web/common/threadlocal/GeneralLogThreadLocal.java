package com.ajashop.web.common.threadlocal;

public class GeneralLogThreadLocal extends ThreadLocal<GeneralLogInfo> {

	private final static ThreadLocal<GeneralLogInfo> threadLocal = new ThreadLocal<GeneralLogInfo>() {
		protected GeneralLogInfo initialValue() {
			return new GeneralLogInfo();
		};
	};

	public static GeneralLogInfo newGeneralLogInfo() {
//		threadLocal.remove();
		return threadLocal.get();
	}
	
	public static GeneralLogInfo currentGeneralLogInfo() {
		return threadLocal.get();
	}
	
	public static void destroy() {
		threadLocal.remove();
	}
}
