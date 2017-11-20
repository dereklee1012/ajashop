package com.ajashop.web.service.example.service;

import java.util.List;

import com.ajashop.web.common.exception.BizException;
import com.ajashop.web.common.vo.MemberVO;

public interface ExampleService {

	List<MemberVO> getMemberList() throws BizException;

}
