package com.bookmarket.service;

import com.bookmarket.dao.BookDAO;
import com.bookmarket.dao.BookDAOImpl;
import com.bookmarket.dto.Book;
import com.bookmarket.exception.NotFoundBookIDException;

public class BookServiceImpl implements BookService{

	private BookDAO dao = new BookDAOImpl();
	
	public Book[] findAll() {
		return dao.selectBookList();
	}
	@Override
	public Book findOne(String bookID) throws NotFoundBookIDException{
		return dao.selectBookByBookId(bookID);
	}

	@Override
	public void regist(Book book) {
		dao.insertBook(book);
		
	}

	@Override
	public void update(Book book) throws NotFoundBookIDException {
		dao.updateBook(book);
		
	}

	@Override
	public void delete(String bookID) throws NotFoundBookIDException {
		dao.deleteBook(bookID);
	}

}
