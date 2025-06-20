package com.bookmarket.dao;

import com.bookmarket.dto.Book;
import com.bookmarket.exception.NotFoundBookIDException;

public interface BookDAO {

	Book[] selectBookList();
	Book selectBookByBookId(String bookId)throws NotFoundBookIDException;
	void insertBook(Book book);
	void updateBook(Book book)throws NotFoundBookIDException;
	void deleteBook(String bookId) throws NotFoundBookIDException;
}
