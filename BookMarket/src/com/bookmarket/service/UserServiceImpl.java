package com.bookmarket.service;

import com.bookmarket.dao.UserDAO;
import com.bookmarket.dao.UserDAOImpl;
import com.bookmarket.dto.User;
import com.bookmarket.exception.InvalidPasswordException;
import com.bookmarket.exception.NotFoundUserIDException;

public class UserServiceImpl implements UserService{

	private UserDAO dao = new UserDAOImpl();

	@Override
	public void login(String id, String pwd) 
			throws NotFoundUserIDException, InvalidPasswordException {
		
		User user = dao.selectUserById(id);
		if(user == null) throw new NotFoundUserIDException();
		if(!user.getPwd().equals(pwd))throw new InvalidPasswordException();
	}


}
