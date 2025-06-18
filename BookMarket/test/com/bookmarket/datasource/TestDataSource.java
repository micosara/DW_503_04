package com.bookmarket.datasource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bookmarket.dto.Book;



public class TestDataSource {

	private DataSource ds;
	private Book[] book;
	
	@Before
	public void init() {
		ds = DataSource.getInstance();
		book = ds.getBook();
	} 
	
	@After
	public void complete() {}
	
	@Test
	public void testUserList() {
		Book target = book[2];
		
		String bookID = target.getBookID();
		
		Assert.assertEquals(bookID, "ISBN1236");
		
	}
}





