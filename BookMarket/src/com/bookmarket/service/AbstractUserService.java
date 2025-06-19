package com.bookmarket.service;

import com.bookmarket.dao.UserDAO;
import com.bookmarket.exception.InvalidPasswordException;
import com.bookmarket.exception.NotFoundUserIDException;

public abstract class AbstractUserService {

	private UserDAO dao = new UserDAO();
	
	protected UserDAO getUserDAO() {
		
		return this.dao;
	}
	
	public abstract void login(String id, String pwd)
			throws NotFoundUserIDException,InvalidPasswordException;
	
}
