package com.bookmarket.exception;

public class NotFoundBookIDException extends Exception {

	public NotFoundBookIDException() {
		super("해당 책은 존재하지 않습니다.");
	}
}
