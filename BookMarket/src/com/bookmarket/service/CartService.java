package com.bookmarket.service;

import java.sql.SQLException;
import java.util.List;

import com.bookmarket.dto.Cart;

public interface CartService {

	List<Cart> menuCartItemList(String user_id)throws SQLException;
	void menuCartClear(String user_id)throws SQLException;
	void menuCartAddItem(Cart cart)throws SQLException; 
	void menuCartRemoveItemCount(Cart cart)throws SQLException;
	void menuCartRemoveItem(int cno)throws SQLException; 
	List<Cart> menuCartBill(String user_id)throws SQLException;
}
