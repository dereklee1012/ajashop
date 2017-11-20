package com.ajashop.web.service.example.dao;

import java.util.List;

import com.ajashop.web.common.exception.BizException;
import com.ajashop.web.common.vo.MemberVO;

public interface ExampleDao {

	List<MemberVO> getMemberList() throws BizException;

}
