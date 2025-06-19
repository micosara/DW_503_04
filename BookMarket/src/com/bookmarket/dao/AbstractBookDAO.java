package com.bookmarket.dao;

import com.bookmarket.datasource.DataSource;
import com.bookmarket.dto.Book;
import com.bookmarket.exception.NotFoundBookIDException;

public abstract class AbstractBookDAO {

	protected DataSource dataSource = DataSource.getInstance();
	
	public abstract Book[] selectBookList();
	public abstract Book selectBookByBookId(String bookId)throws NotFoundBookIDException;
	public abstract void insertBook(Book book);
	public abstract void updateBook(Book book)throws NotFoundBookIDException;
	public abstract void deleteBook(String bookId) throws NotFoundBookIDException;
}
