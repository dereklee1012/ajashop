package com.ajashop.web.common.secure;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

public class SHA256 {
	private final static Logger logger = LogManager.getLogger(SHA256.class);

    public String encrypt(String strData) { // 암호화 시킬 데이터
        String strENCData   = "";

        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256"); // "MD5 형식으로 암호화"

            byte[] bytData = strData.getBytes();
            sha256.update(bytData);
            byte[] digest = sha256.digest(); // 배열로 저장을 한다.

            for (int i = 0; i < digest.length; i++) {
                strENCData = strENCData + Integer.toHexString(digest[i] & 0xFF).toUpperCase();
            }

            logger.debug("SHA-256 Encrypt : " + strENCData);
        }
        catch (NoSuchAlgorithmException e) {
            logger.error("암호화 에러 : " + e.toString());
        }
        return strENCData; // 암호화된 데이터를 리턴...
    }

    public boolean check(String encryptData, String checkString) {
        String strEncrypt =  encrypt(checkString);

        boolean bRet = true;
        bRet = strEncrypt.equals(encryptData);

        return bRet;
    }
}
