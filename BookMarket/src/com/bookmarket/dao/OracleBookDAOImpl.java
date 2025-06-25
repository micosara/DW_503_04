package com.bookmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookmarket.datasource.OracleDataSource;
import com.bookmarket.dto.Book;

public class OracleBookDAOImpl implements OracleBookDAO {

	private OracleDataSource dataSource = OracleDataSource.getInstance();

	@Override
	public List<Book> selectBookList() throws SQLException {
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			List<Book> bookList = new ArrayList<Book>();
			
			Statement stmt = conn.createStatement();
			String sql = "select * from book";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Book book = new Book();
				book.setBookID(rs.getString("bookId"));
				book.setDescript(rs.getString("descript"));
				book.setKind(rs.getString("kind"));
				book.setpDate(rs.getString("pDate"));
				book.setPrice(rs.getInt("price"));
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				
				bookList.add(book);
			}
			
			return bookList;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public Book selectBookByID(String bookId) throws SQLException {
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from book where bookid='"+bookId+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			Book book=null;
			if(rs.next()) {
				book = new Book();
				book.setBookID(rs.getString("bookId"));
				book.setDescript(rs.getString("descript"));
				book.setKind(rs.getString("kind"));
				book.setpDate(rs.getString("pDate"));
				book.setPrice(rs.getInt("price"));
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
			}
			
			return book;
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public void insertBook(Book book) throws SQLException {
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			String sql="insert into"
					+ " book(bookId,title,price,writer,descript,kind,pDate)"
					+ " values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookID());
			pstmt.setString(2, book.getTitle());
			pstmt.setInt(3,book.getPrice());
			pstmt.setString(4, book.getWriter());
			pstmt.setString(5, book.getDescript());
			pstmt.setString(6, book.getKind());
			pstmt.setString(7, book.getpDate());
			
			pstmt.executeUpdate();
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public void updateBook(Book book) throws SQLException {
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			String sql = "update book"
					+ " set"
					+ " title=?,price=?,writer=?,descript=?,kind=?,pDate=?"
					+ " where bookId=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setInt(2,book.getPrice());
			pstmt.setString(3, book.getWriter());
			pstmt.setString(4, book.getDescript());
			pstmt.setString(5, book.getKind());
			pstmt.setString(6, book.getpDate());
			pstmt.setString(7, book.getBookID());
			
			pstmt.executeUpdate();
			
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public void deleteBook(String bookId) throws SQLException {
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from book where bookId='"+bookId+"'";
			stmt.executeUpdate(sql);
			
		} finally {
			if (conn != null)
				conn.close();
		}
	}

}
