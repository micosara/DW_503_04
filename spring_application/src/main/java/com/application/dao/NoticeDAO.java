package com.application.dao;

import java.sql.SQLException;
import java.util.List;

import com.application.command.PageMaker;
import com.application.dto.NoticeVO;

public interface NoticeDAO {
	List<NoticeVO> selectSearchNoticeList(PageMaker pageMaker) throws SQLException;

	int selectSearchNoticeListCount(PageMaker pageMaker) throws SQLException;

	NoticeVO selectNoticeByNno(int nno) throws SQLException;

	// viewcnt 증가
	void increaseViewCount( int nno) throws SQLException;

	// Notice_seq.nextval 가져오기
	int selectNoticeSequenceNextValue() throws SQLException;

	void insertNotice(NoticeVO notice) throws SQLException;

	void updateNotice(NoticeVO notice) throws SQLException;

	void deleteNotice(int nno) throws SQLException;
}
