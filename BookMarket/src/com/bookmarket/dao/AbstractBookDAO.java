package com.bookmarket.dao;

import com.bookmarket.datasource.DataSource;
import com.bookmarket.dto.Book;

public abstract class AbstractBookDAO {

	protected DataSource dataSource = DataSource.getInstance();
	
	public abstract Book[] selectBookList();
	public abstract Book selectBookByBookId(String bookId);
	public abstract void insertBook(Book book);
	public abstract void updateBook(Book book);
	public abstract void deleteBook(String bookId);
}
