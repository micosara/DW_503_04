package com.bookmarket.dao;

import com.bookmarket.datasource.DataSource;
import com.bookmarket.dto.Book;
import com.bookmarket.exception.NotFoundBookIDException;

public class BookDAO extends AbstractBookDAO {

	private Book[] bookArray = DataSource.getInstance().getBook();

	@Override
	public Book[] selectBookList() {
		return this.bookArray;
	}

	@Override
	public Book selectBookByBookId(String bookId) throws NotFoundBookIDException {
		Book book = null;

		book = bookArray[findIndex(bookId)];

		return book;
	}

	@Override
	public void insertBook(Book book) {
		int count = 0;
		for (int i = 0; i < bookArray.length; i++) {
			if (bookArray[i] == null) {
				bookArray[i] = book;
				break;
			}
			count++;
		}

		if (bookArray.length == count) {
			Book[] temp = new Book[bookArray.length + 10];
			System.arraycopy(bookArray, 0, temp, 0, bookArray.length);
			temp[bookArray.length] = book;

			bookArray = temp;
		}

	}

	@Override
	public void updateBook(Book book) throws NotFoundBookIDException {

		bookArray[findIndex(book.getBookID())] = book;

	}

	@Override
	public void deleteBook(String bookId) throws NotFoundBookIDException {
		int i = findIndex(bookId);
		Book[] temp = new Book[bookArray.length];

		System.arraycopy(bookArray, 0, temp, 0, i);
		System.arraycopy(bookArray, i + 1, temp, i, bookArray.length - i - 1);
		bookArray = temp;

	}

	private int findIndex(String bookId) throws NotFoundBookIDException {
		for (int i = 0; i < bookArray.length; i++) {
			if (bookArray[i]!=null && bookArray[i].getBookID().equals(bookId)) {
				return i;
			}
		}
		throw new NotFoundBookIDException();
	}
}
