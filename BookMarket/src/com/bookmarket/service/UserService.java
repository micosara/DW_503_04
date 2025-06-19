package com.bookmarket.service;

import com.bookmarket.dao.UserDAO;
import com.bookmarket.dto.User;
import com.bookmarket.exception.InvalidPasswordException;
import com.bookmarket.exception.NotFoundUserIDException;

public class UserService extends AbstractUserService{

	private UserDAO dao = getUserDAO();

	@Override
	public void login(String id, String pwd) 
			throws NotFoundUserIDException, InvalidPasswordException {
		
		User user = dao.selectUserById(id);
		if(user == null) throw new NotFoundUserIDException();
		if(!user.getPwd().equals(pwd))throw new InvalidPasswordException();
	}


}
