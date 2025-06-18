package com.bookmarket.dao;

import com.bookmarket.dto.Book;

public abstract class AbstractBookDAO {

	public abstract Book[] selectBookList();
	public abstract Book selectBookByBookId(String bookId);
	public abstract void insertBook(Book book);
	public abstract void updateBook(Book book);
	public abstract void deleteBook(String bookId);
}
