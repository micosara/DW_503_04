package com.bookmarket.dao;

import com.bookmarket.dto.User;

public interface UserDAO {

	
	User selectUserById(String id);
}
