package com.bookmarket.dao;

import java.sql.SQLException;
import java.util.List;

import com.bookmarket.dto.User;

public interface OracleUserDAO {

	List<User> selectUserList()throws SQLException;
	User selectUserByID(String id)throws SQLException;
	void insertUser(User user)throws SQLException;
	void updateUser(User user)throws SQLException;
	void delete(String id)throws SQLException;
}
