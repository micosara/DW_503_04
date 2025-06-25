package com.bookmarket.dao;

import java.sql.SQLException;
import java.util.List;

import com.bookmarket.dto.Book;

public interface OracleBookDAO {
	
	List<Book> selectBookList()throws SQLException;
	Book selectBookByID(String bookId) throws SQLException;
	void insertBook(Book book)throws SQLException;
	void updateBook(Book book)throws SQLException;
	void deleteBook(String bookId)throws SQLException;
	
}
