package com.bookmarket.service;

import java.sql.SQLException;

import com.bookmarket.dao.OracleUserDAO;
import com.bookmarket.dao.OracleUserDAOImpl;
import com.bookmarket.dto.User;
import com.bookmarket.exception.InvalidPasswordException;
import com.bookmarket.exception.NotFoundUserIDException;

public class OracleUserServiceImpl implements UserService{
	
	private OracleUserDAO dao = new OracleUserDAOImpl();

	@Override
	public void login(String id, String pwd) 
									throws NotFoundUserIDException, 
										   InvalidPasswordException,
										   SQLException{
		User user = dao.selectUserByID(id);
		if(user==null) throw new NotFoundUserIDException();
		if(!pwd.equals(user.getPwd()))throw new InvalidPasswordException();
		
	}

	@Override
	public User menuGuestInfo(String id) throws SQLException {
		return dao.selectUserByID(id);
	}

}
