package com.bookmarket.service;

import com.bookmarket.exception.InvalidPasswordException;
import com.bookmarket.exception.NotFoundUserIDException;

public interface UserService {

	
	void login(String id, String pwd)
			throws NotFoundUserIDException,InvalidPasswordException;
}
