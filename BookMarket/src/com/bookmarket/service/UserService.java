package com.bookmarket.service;

import java.sql.SQLException;

import com.bookmarket.dto.User;
import com.bookmarket.exception.InvalidPasswordException;
import com.bookmarket.exception.NotFoundUserIDException;

public interface UserService {

	
	void login(String id, String pwd)
								throws NotFoundUserIDException,
									   InvalidPasswordException,
									   SQLException;
	
	User menuGuestInfo(String id) throws SQLException; 
}









