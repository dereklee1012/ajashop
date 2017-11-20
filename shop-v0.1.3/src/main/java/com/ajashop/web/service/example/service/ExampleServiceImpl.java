package com.ajashop.web.service.example.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajashop.web.common.exception.BizException;
import com.ajashop.web.common.vo.MemberVO;
import com.ajashop.web.service.example.dao.ExampleDao;

@Service
public class ExampleServiceImpl implements ExampleService {

	private final static Logger logger = LogManager.getLogger(ExampleServiceImpl.class);
	
	@Autowired ExampleDao exampleDao;

	@Override
	public List<MemberVO> getMemberList() throws BizException {
		return exampleDao.getMemberList();
	}
}
