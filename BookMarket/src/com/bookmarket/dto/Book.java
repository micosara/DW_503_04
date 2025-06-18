package com.bookmarket.dto;

public class Book {
	
	private String bookID;
	private String title;
	private int price;
	private String writer;
	private String decript;
	private String kind;
	private String pDate;
	
	public Book(String bookID, String title, int price, String writer, String decript, String kind, String pDate) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.price = price;
		this.writer = writer;
		this.decript = decript;
		this.kind = kind;
		this.pDate = pDate;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDecript() {
		return decript;
	}

	public void setDecript(String decript) {
		this.decript = decript;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}
	
	
}
