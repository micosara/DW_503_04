package com.spring.dataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/dataSource-context.xml")
public class TestBasicDataSource {

	//@Autowired
	@Resource(name="dataSource")
	private DataSource dataSource;
	
	private Connection conn;
	
	@Before
	public void initConnection()throws Exception {
		conn= dataSource.getConnection();
	}
	
	@After
	public void closeConnection()throws Exception{
		if(conn!=null) conn.close();
	}
	
	@Test
	public void testConnection() {
		Assert.assertNotNull(conn);
	}
	
	@Test
	public void testGetMember() throws Exception{
		String target = "mimi";
		Statement stmt = conn.createStatement();
		String sql = "select * from member where id='"+target+"'";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		Assert.assertNotEquals(rs.next(), false);
		Assert.assertEquals(rs.getString("id"), target);
	}
	
}








