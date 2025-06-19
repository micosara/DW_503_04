package com.bookmarket.dao;

import com.bookmarket.datasource.DataSource;
import com.bookmarket.dto.User;

public class UserDAO {

	private DataSource dataSource = DataSource.getInstance();
	
	
	public User selectUserById(String id) {
		User user=null;
		
		User[] users = dataSource.getUsers();
		for(int i=0;i<users.length;i++) {
			if(users[i]!=null && users[i].getId().equals(id)) {
				user = users[i];
				break;
			}
		}
		
		return user;
	}
}
