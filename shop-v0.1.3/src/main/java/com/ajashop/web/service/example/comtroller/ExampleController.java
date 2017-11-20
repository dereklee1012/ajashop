package com.ajashop.web.service.example.comtroller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ajashop.web.common.log.BusinessLogUtils;
import com.ajashop.web.common.vo.MemberVO;
import com.ajashop.web.service.example.service.ExampleService;
import com.ajashop.web.service.main.comtroller.MainController;
import com.ajashop.web.service.main.service.MainService;

/**
 * First Editor : dereklee
 * Last Editor  : dereklee
 * Date         : 2017-07-30
 * Description  :
 * Copyright ⓒ 2013-2015 dereklee All rights reserved.
 * version      : v0.1
 */

@Controller
@RequestMapping(value="/example")
public class ExampleController {

	private final static Logger logger = LogManager.getLogger(ExampleController.class);
	
	@Autowired ExampleService exampleService;

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String printWelcome(ModelMap model) {
//		model.addAttribute("message", "Spring 3 MVC Hello World");
//		return "hello";
//
//	}
	
	@RequestMapping(value="/main.do")
	public ModelAndView showMain(Authentication auth) throws Exception{
		logger.info(BusinessLogUtils.getPrettyLog("example/main.do"));
		ModelAndView modelAndView = new ModelAndView();
		if(auth != null){
			UserDetails vo = (UserDetails) auth.getPrincipal();
			modelAndView.addObject("vo", vo);
		}

		modelAndView.setViewName("example/main");
		return modelAndView;
	}

	@RequestMapping(value="/list.do")
	public ModelAndView showList(Authentication auth) throws Exception{
		logger.info(BusinessLogUtils.getPrettyLog("example/list.do"));
		List<MemberVO> data = exampleService.getMemberList();
		return  new ModelAndView("example/list","data",data);
	}
}