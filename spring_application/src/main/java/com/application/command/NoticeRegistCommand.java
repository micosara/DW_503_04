package com.application.command;

import java.util.Date;

import com.application.dto.NoticeVO;

public class NoticeRegistCommand {

	private String title;
	private String writer;
	private String content;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public NoticeVO toNoticeVO() {
		NoticeVO notice = new NoticeVO();
		
		notice.setWriter(writer);
		notice.setContent(content);
		notice.setTitle(title);
		notice.setRegDate(new Date());
		
		return notice;
	}
}
