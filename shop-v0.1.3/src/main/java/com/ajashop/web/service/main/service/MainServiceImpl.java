package com.ajashop.web.service.main.service;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajashop.web.service.example.dao.ExampleDao;

@Service
public class MainServiceImpl implements MainService {

	private final static Logger logger = LogManager.getLogger(MainServiceImpl.class);

	@Autowired ExampleDao exampleDao;
	
}
