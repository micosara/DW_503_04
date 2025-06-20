package com.bookmarket.service;

import com.bookmarket.dto.Book;
import com.bookmarket.exception.NotFoundBookIDException;

public interface BookService {

	Book[] findAll();
	Book findOne(String bookID) throws NotFoundBookIDException;
	void regist(Book book);
	void update(Book book) throws NotFoundBookIDException;
	void delete(String bookID) throws NotFoundBookIDException;
}
