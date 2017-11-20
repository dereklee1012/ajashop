package com.ajashop.web.service.example.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ajashop.web.common.constants.MsgConstants;
import com.ajashop.web.common.exception.BizException;
import com.ajashop.web.common.vo.MemberVO;

@Repository
public class ExampleDaoImpl implements ExampleDao {

	@Autowired private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<MemberVO> getMemberList() throws BizException {
		try {
			return sqlSessionTemplate.selectList("member.selectList");
		} catch(Exception e) {
			e.printStackTrace();
			throw new BizException(MsgConstants.ERR_DB_SELECT, MsgConstants.ERR_DB_SELECT_MSG + " / " + e.getMessage());
		}
	}

}
