package com.bookmarket.service;

import java.sql.SQLException;
import java.util.List;

import com.bookmarket.dao.OracleBookDAO;
import com.bookmarket.dao.OracleBookDAOImpl;
import com.bookmarket.dao.OracleCartDAO;
import com.bookmarket.dao.OracleCartDAOImpl;
import com.bookmarket.dao.OracleUserDAO;
import com.bookmarket.dao.OracleUserDAOImpl;
import com.bookmarket.dto.Book;
import com.bookmarket.dto.Cart;
import com.bookmarket.dto.User;

public class CartServiceImpl implements CartService{
	private OracleUserDAO userDao = new OracleUserDAOImpl();
	private OracleBookDAO bookDao = new OracleBookDAOImpl();
	private OracleCartDAO cartDao = new OracleCartDAOImpl();
	
	@Override
	public List<Cart> menuCartItemList(String user_id) throws SQLException {
		List<Cart> cartList = cartDao.selectCartList(user_id);
		
		if(cartList!=null) for(Cart cart : cartList) {
			User user = userDao.selectUserByID(cart.getId());
			Book book = bookDao.selectBookByID(cart.getBook_id());
			
			cart.setBook(book);
			cart.setUser(user);
		}
		
		return cartList;
	}
	@Override
	public void menuCartClear(String user_id) throws SQLException {
		List<Cart> cartList = cartDao.selectCartList(user_id);
		if(cartList!=null) for(Cart cart : cartList) {
			cartDao.deleteCart(cart.getCno());
		}
		
	}
	@Override
	public void menuCartAddItem(Cart cart) throws SQLException {
		cartDao.insertCart(cart);
	}
	@Override
	public void menuCartRemoveItemCount(Cart cart) throws SQLException {
		cartDao.updateCart(cart);
	}
	@Override
	public void menuCartRemoveItem(int cno) throws SQLException {
		cartDao.deleteCart(cno);
	}
	@Override
	public List<Cart> menuCartBill(String user_id) throws SQLException {
		return this.menuCartItemList(user_id);
	}
	

}
