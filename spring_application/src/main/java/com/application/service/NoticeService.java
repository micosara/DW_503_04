package com.application.service;

import java.sql.SQLException;
import java.util.List;

import com.application.command.PageMaker;
import com.application.dto.NoticeVO;

public interface NoticeService {
	// 목록
	public List<NoticeVO> list(PageMaker pageMaker) throws SQLException;

	// 상세 + 조회수증가
	public NoticeVO detail(int nno) throws SQLException;

	// 수정
	public NoticeVO getNotice(int nno) throws SQLException;

	public void modify(NoticeVO notice) throws SQLException;

	// 등록
	public void regist(NoticeVO notice) throws SQLException;

	// 삭제
	public void remove(int nno) throws SQLException;
}
