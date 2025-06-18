package com.bookmarket.datasource;

import com.bookmarket.dto.Book;
import com.bookmarket.dto.User;

public class DataSource {
	
	private static DataSource instance = new DataSource();
	private DataSource() {
		bookList();
		
	}
	public static DataSource getInstance() {
		return instance;
	}
	
	static final int NUM_BOOK = 3;
	
	private Book[] book = new Book[NUM_BOOK];
	public Book[] getBook() {
		return book;
	}

	private void bookList() {
		book[0] =new Book("ISBN1234",
							 "쉽게 배우는 JSP 웹 프로그래밍",
							 27000,
							 "송미영",
							 "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍 ",
							 "IT전문서",
							 "2018/10/08");

		book[1] =new Book("ISBN1235",
					      "안드로이드 프로그래밍",
					      33000,
					      "우재남",
					      "실습 단계별 명쾌한 멘토링!",
					      "IT전문서",
					      "2022/01/22");

		book[2] =new Book("ISBN1236",
				          "스크래치",
				          22000,
				          "고광일",
				          "컴퓨팅 사고력을 키우는 블록 코딩",
				          "컴퓨터입문",
				          "2019/06/10");
		
		User user1 = new User("mimi","mimi","ROLE_ADMIN");
		User user2 = new User("mama","mama","ROLE_USER");
		User user3 = new User("mumu","mumu","ROLE_USER");
		
		users[0] = user1;
		users[1] = user2;
		users[2] = user3;
	}
	
	private User[] users = new User[50];
	
	public User[] getUsers() {
		return users;
	}
	public void setUsers(User[] users) {
		this.users = users;
	}
	
	
}








