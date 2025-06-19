package com.bookmarket.exception;

public class NotFoundUserIDException extends Exception{

	public NotFoundUserIDException() {
		super("존재하지 않는 아이디 입니다.");
	}
}
