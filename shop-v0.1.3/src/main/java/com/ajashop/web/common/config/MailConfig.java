package com.ajashop.web.common.config;

import org.springframework.stereotype.Component;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

@Component
public class MailConfig {
	String email;
	String mailSmtpPort;
	String mailSmtpHost;
	String mailSmtpUserName;
	String mailSmtpUserPwd;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMailSmtpPort() {
		return mailSmtpPort;
	}
	public void setMailSmtpPort(String mailSmtpPort) {
		this.mailSmtpPort = mailSmtpPort;
	}
	public String getMailSmtpHost() {
		return mailSmtpHost;
	}
	public void setMailSmtpHost(String mailSmtpHost) {
		this.mailSmtpHost = mailSmtpHost;
	}
	public String getMailSmtpUserName() {
		return mailSmtpUserName;
	}
	public void setMailSmtpUserName(String mailSmtpUserName) {
		this.mailSmtpUserName = mailSmtpUserName;
	}
	public String getMailSmtpUserPwd() {
		return mailSmtpUserPwd;
	}
	public void setMailSmtpUserPwd(String mailSmtpUserPwd) {
		this.mailSmtpUserPwd = mailSmtpUserPwd;
	}

	
	
}

