package com.bookmarket.service;

import com.bookmarket.dto.Book;
import com.bookmarket.exception.NotFoundBookIDException;

public class BookService extends AbstractBookService{


	@Override
	public void regist(Book book) {
		super.dao.insertBook(book);
		
	}

	@Override
	public void update(Book book) throws NotFoundBookIDException {
		super.dao.updateBook(book);
		
	}

	@Override
	public void delete(String bookID) throws NotFoundBookIDException {
		super.dao.deleteBook(bookID);
	}

}
