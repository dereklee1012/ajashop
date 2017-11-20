package com.ajashop.web.common.secure;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.ajashop.web.common.util.StringUtil;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

public class HashUtils {

	public static byte[] encodingMD5(byte[] in) throws NoSuchAlgorithmException {
		return HashUtils.generate(in, "MD5");
	}
	
	public static byte[] encodingSHA1(byte[] in) throws NoSuchAlgorithmException {
		return HashUtils.generate(in, "SHA-1");
	}
	
	public static byte[] encodingSHA256(byte[] in) throws NoSuchAlgorithmException {
		return HashUtils.generate(in, "SHA-256");
	}
	
	private static byte[] generate(byte[] in, String algorithm) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance(algorithm);
		return md5.digest(in);
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		byte[] src = "partner_id=dingdong&partner_key=3ca699c76c315020b22a87685eaf4e58&service_type=waitBuyerConfirm&service_data={\"tradeNo\":\"1606244EE9JRIP\"}&msg_id=msg0000001".getBytes();
		System.out.println(StringUtil.ascii2hexstr(HashUtils.encodingMD5(src)));
	}
	
}
