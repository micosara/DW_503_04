package com.application.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.application.dto.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/dataSource-context.xml")
@Transactional
public class TestSqlSession {

	@Autowired
	private SqlSession session;
	
	@Test
	public void testSelectMemberList() {
		List<MemberVO> memberList
		= session.selectList("Member-Mapper.selectMemberList");
		
		Assert.assertEquals(memberList.size(),7);
	}
	

	@Test
	public void testSelectMemberByID() {
		String targetID = "mimi";
		
		MemberVO member 
		= session.selectOne("Member-Mapper.selectMemberByID",targetID);
		
		Assert.assertEquals(targetID, member.getId());
	}
	
	@Test
	@Rollback
	public void testInsertMember() {
		MemberVO mockMember = new MemberVO();
		mockMember.setId("kaka");
		mockMember.setPwd("kaka");
		mockMember.setEmail("kaka@naver.com");
		mockMember.setPhone("010-1234-134");
		mockMember.setPicture("noImage.jpg");
		mockMember.setName("kim");
		
		session.insert("Member-Mapper.insertMember",mockMember);
		
		MemberVO getMember 
		= session.selectOne("Member-Mapper.selectMemberByID",mockMember.getId());
		
		Assert.assertEquals(mockMember.getId(), getMember.getId());
	}
	
	@Test
	@Rollback
	public void testUpdateMember() {
		
		String id = "mimi";
		String chName = "nana";
		
		MemberVO getMember 
		= session.selectOne("Member-Mapper.selectMemberByID",id);
		getMember.setName(chName);
		session.update("Member-Mapper.updateMember",getMember);
		
		getMember = session.selectOne("Member-Mapper.selectMemberByID",id);
		
		Assert.assertEquals(chName, getMember.getName());
	}
	
	@Test
	@Rollback
	public void testDeleteMember() {
		String id = "toto";
		
		MemberVO member 
		= session.selectOne("Member-Mapper.selectMemberByID",id);
		
		Assert.assertNotNull(member);
		
		session.delete("Member-Mapper.deleteMember",id);
		
		member = session.selectOne("Member-Mapper.selectMemberByID",id);
		
		Assert.assertNull(member);
		
	}
}




