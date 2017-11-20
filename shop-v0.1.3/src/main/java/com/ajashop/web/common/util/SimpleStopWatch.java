package com.ajashop.web.common.util;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

public final class SimpleStopWatch {

	  private long start = System.nanoTime();

	  /**
	   * Resets and returns elapsed time in milliseconds.
	   */
	  public long reset() {
	    long now = System.nanoTime();
	    try {
	      return now - start;
	    } finally {
	      start = now;
	    }
	  }

	 public String getRunningTime() {
		 return String.format("%1.9f", (double)reset() / 1000000000.0);
	  }
	  
	 public static String getRunningTime(long start) {
		long now = System.nanoTime();
		
		return String.format("%1.9f", (double)(now - start) / 1000000000.0);
	}
	 
	  public static void main(String[] args) throws InterruptedException {
		 SimpleStopWatch stopwatch = new SimpleStopWatch();
		 
		 Thread.sleep(5);
		 System.out.println(stopwatch.getRunningTime());
		 
		 System.out.println(String.format("%1.9f", (10000000000000.0/3.0) / 1000000000.0));
	  }
}
