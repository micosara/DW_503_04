package com.bookmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			String sql = "select *"
					+ " from cart"
					+ " where user_id='"+id+"'";
			
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
		Connection conn = null;
		Statement stmt =null;
		ResultSet rs = null;
		
		try {
			conn=dataSource.getConnection();
			stmt=conn.createStatement();
			String sql = "select *"
					+ " from cart"
					+ " where cno="+cno;
			
			rs=stmt.executeQuery(sql);
			Cart cart = null;
			if(rs.next()) {
				cart = new Cart();
				cart.setBook_id(rs.getString("book_id"));
				cart.setCno(rs.getInt("cno"));
				cart.setCount(rs.getInt("count"));
				cart.setId(rs.getString("user_id"));
				cart.setTotal_price(rs.getInt("total_price"));
			}
			
			return cart;
		}finally {
			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}
	}

	@Override
	public void insertCart(Cart cart) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt =null;
		
		try {
			conn=dataSource.getConnection();
			String sql = "insert into "
					+ " cart(cno,count,total_price,user_id,book_id)"
					+ " values(?,?,?,?,?) ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cart.getCno());
			pstmt.setInt(2, cart.getCount());
			pstmt.setInt(3, cart.getTotal_price());
			pstmt.setString(4,cart.getId());
			pstmt.setString(5, cart.getBook_id());
			
			pstmt.executeUpdate();
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}

	}

	@Override
	public void updateCart(Cart cart) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt =null;
		
		try {
			conn=dataSource.getConnection();
			String sql = "update cart"
					+ " set"
					+ " count=?,total_price=?,user_id=?,book_id=?"
					+ " where cno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cart.getCount());
			pstmt.setInt(2, cart.getTotal_price());
			pstmt.setString(3,cart.getId());
			pstmt.setString(4, cart.getBook_id());
			pstmt.setInt(5, cart.getCno());
			
			pstmt.executeUpdate();
			
		}finally {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
	}

	@Override
	public void deleteCart(int cno) throws SQLException {
		Connection conn = null;
		Statement stmt =null;
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			String sql = "delete"
					+ " from cart"
					+ " where cno="+cno;
			
			stmt.executeUpdate(sql);
			
		}finally {
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
	}

	@Override
	public int selectCartSeqNextValue() throws SQLException {
		Connection con = null;
		Statement stmt =null;
		ResultSet rs = null;
		try {
			con=dataSource.getConnection();
			stmt = con.createStatement();
			String sql = "select cart_seq.nextval as cno from dual";
			rs = stmt.executeQuery(sql);
			int cno = -1;
			if(rs.next()) {
				cno = rs.getInt("cno");
			}
			return cno;
		}finally {
			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();
		}
	}

}
