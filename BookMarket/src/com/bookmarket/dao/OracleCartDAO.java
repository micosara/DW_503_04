package com.bookmarket.dao;

import java.sql.SQLException;
import java.util.List;

import com.bookmarket.dto.Cart;

public interface OracleCartDAO {

	List<Cart> selectCartList(String id)throws SQLException;
	Cart selectCartBy(int cno)throws SQLException;
	void insertCart(Cart cart)throws SQLException;
	void updateCart(Cart cart)throws SQLException;
	void deleteCart(int cno)throws SQLException;
	
}
