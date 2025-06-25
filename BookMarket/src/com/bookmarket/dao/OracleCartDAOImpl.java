package com.bookmarket.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookmarket.datasource.OracleDataSource;
import com.bookmarket.dto.Cart;

public class OracleCartDAOImpl implements OracleCartDAO {

	private OracleDataSource dataSource = OracleDataSource.getInstance();

	@Override
	public List<Cart> selectCartList(String id) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from cart";
			rs = stmt.executeQuery(sql);

			List<Cart> cartList = new ArrayList<Cart>();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setBook_id(rs.getString("book_id"));
				cart.setCno(rs.getInt("cno"));
				cart.setCount(rs.getInt("count"));
				cart.setId(rs.getString("user_id"));
				cart.setTotal_price(rs.getInt("total_price"));

				cartList.add(cart);
			}
			return cartList;
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public Cart selectCartBy(int cno) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCart(Cart cart) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCart(Cart cart) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCart(int cno) throws SQLException {
		// TODO Auto-generated method stub

	}

}
