package com.ajashop.web.common.error;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-17
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */
public class MemberIdNotFoundException extends NotEqualsException {
    public MemberIdNotFoundException(String msg){
        super(msg);
    }
}
