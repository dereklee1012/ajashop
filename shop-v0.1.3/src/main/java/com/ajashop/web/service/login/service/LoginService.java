package com.ajashop.web.service.login.service;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

@Service("loginService")
public class LoginService implements UserDetailsService{

	@Resource(name="passwordEncoder")
	private Md5PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@"+email);
		return null;
	}

	public String encoding(String str){
		System.out.println("$$$$$$$$$$$" + str);
		return encoder.encodePassword(str,null);
	}
}
