package com.bookmarket.service;

import com.bookmarket.dao.BookDAO;
import com.bookmarket.dto.Book;
import com.bookmarket.exception.NotFoundBookIDException;

public abstract class AbstractBookService {

	protected BookDAO dao = new BookDAO();
	
	public Book[] findAll() {
		return dao.selectBookList();
	}
	public Book findOne(String bookID) throws NotFoundBookIDException{
		return dao.selectBookByBookId(bookID);
	}
	public abstract void regist(Book book);
	public abstract void update(Book book) throws NotFoundBookIDException;
	public abstract void delete(String bookID) throws NotFoundBookIDException;
}
