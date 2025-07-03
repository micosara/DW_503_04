package com.spring.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dto.MemberVO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/dataSource-context.xml")
public class TestSqlSesion {

	@Autowired
	private SqlSession session;
	
	
	
	@Test
	public void testSelectMemberList()throws SQLException{
		List<MemberVO> memberList 
			= session.selectList("Member-Mapper.selectMemberList");
		
		Assert.assertEquals(memberList.size(), 3);
	}
}





