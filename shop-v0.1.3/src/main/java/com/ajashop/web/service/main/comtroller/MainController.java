package com.ajashop.web.service.main.comtroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ajashop.web.common.log.BusinessLogUtils;
import com.ajashop.web.common.vo.MemberVO;
import com.ajashop.web.service.login.service.LoginService;
import com.ajashop.web.service.main.service.MainService;
import com.ajashop.web.service.main.service.MainServiceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-10
 * Description  :
 * Copyright ⓒ 2013-2015 Jisung Jeon All rights reserved.
 * version      : v0.0.6
 */

@Controller
@RequestMapping(value="/main")
public class MainController {

	private final static Logger logger = LogManager.getLogger(MainController.class);
	
	@Autowired MainService mainService;
	
	@RequestMapping(value="/main.do")
	public ModelAndView showMain(Authentication auth) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		if(auth != null){
			UserDetails vo = (UserDetails) auth.getPrincipal();
			modelAndView.addObject("vo", vo);
		}

		logger.info(BusinessLogUtils.getPrettyLog("main/main.do"));
		modelAndView.setViewName("main/main");
		return modelAndView;
	}
	
	@RequestMapping("/login.do")
	public String login(@RequestParam(value = "error", required = false) String error,
			HttpServletRequest request,Model model,Authentication auth) throws Exception{
		
		if (error != null) {
			//login form for update page
            //if login error, get the targetUrl from session again.
			String targetUrl = getRememberMeTargetUrlFromSession(request);
			System.out.println(targetUrl);
			
			if(StringUtils.hasText(targetUrl)){
				model.addAttribute("targetUrl", targetUrl);
				model.addAttribute("loginUpdate", true);
				return "/user/userEdit";
			}		
			
			model.addAttribute("say", "Check your Email and Password again");
			model.addAttribute("url", request.getContextPath()+"/main/login.do");
			return "/error/alert";
		}
		return "main/login";
	}
	
	private String getRememberMeTargetUrlFromSession(HttpServletRequest request){
		String targetUrl = "";
		HttpSession session = request.getSession(false);
		if(session!=null){
			targetUrl = session.getAttribute("targetUrl")==null?"":session.getAttribute("targetUrl").toString();
		}
		return targetUrl;
	}
}
