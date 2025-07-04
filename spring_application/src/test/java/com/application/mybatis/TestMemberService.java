package com.application.mybatis;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.application.dto.MemberVO;
import com.application.service.MemberService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/root-context.xml")
@Transactional
public class TestMemberService {

	@Autowired
	private MemberService service;
	
	@Test
	public void testList()throws Exception{
		List<MemberVO> memberList = service.list();
		Assert.assertEquals(memberList.size(), 7);
	}
	
}








