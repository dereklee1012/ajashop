package com.ajashop.web.common.constants;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

public class MsgConstants {

	public final static String SUCCESS 					= "0000";
	public final static String SUCCESS_MSG 				= "Success";
	
	public final static String ERR_SYSTEM 				= "FFFF";
	public final static String ERR_SYSTEM_MSG 			= "System error";
	
	
	public final static String ERR_PARAMETER_VELIDATION 		= "CB01";		// URL Parameter Validation Error
	public final static String ERR_PARAMETER_VELIDATION_MSG		= "Request map generation error.";
	/*
	 * Common + System error + Sequence
	 */
	public final static String ERR_UNSUPPORTED_MEDIA_TYPE			= "CS01";		// Unsupported Media Type
	public final static String ERR_METHOD_NOT_ALLOWED				= "CS01";		// Method Not Allowed
	
	/*
	 * Common + Database Error + Select + Sequence
	 * ex> CDS0, CDS1
	 */
	public final static String ERR_DB_SELECT						= "CDS0";
	public final static String ERR_DB_SELECT_MSG					= "DB Select error";
	
	/*
	 * Common + Database Error + Update + Sequence
	 * ex> CDU0, CDU1
	 */
	public final static String ERR_DB_UPDATE						= "CDU0";
	public final static String ERR_DB_UPDATE_MSG					= "DB Update error";
	
	/*
	 * Common + Database Error + Insert + Sequence
	 * ex> CDI0, CDI1
	 */
	public final static String ERR_DB_INSERT						= "CDI0";
	public final static String ERR_DB_INSERT_MSG					= "DB Insert error";
	
	/*
	 * Common + Database Error + Delete + Sequence
	 * ex> CDD0, CDD1
	 */
	public final static String ERR_DB_DELETE						= "CDD0";
	public final static String ERR_DB_DELETE_MSG					= "DB Delete error";
}
