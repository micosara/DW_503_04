package com.application.command;

public class PageMaker {

	private int page = 1; // 페이지 번호
	private int perPageNum = 10; // 리스트 개수
	private String searchType = "";
	private String keyword = "";
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public int getStartRow() {
		return (this.page - 1) * this.perPageNum+1;
	}
	
}





