package com.application.service;

import java.sql.SQLException;
import java.util.List;

import com.application.command.PageMaker;
import com.application.dao.NoticeDAO;
import com.application.dto.NoticeVO;

public class NoticeServiceImpl implements NoticeService{
	
private NoticeDAO noticeDAO;
	
	public NoticeServiceImpl(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	@Override
	public List<NoticeVO> list(PageMaker pageMaker) throws SQLException {
		List<NoticeVO> noticeList = noticeDAO.selectSearchNoticeList(pageMaker);
		
		// 전체 board 개수
		int totalCount = noticeDAO.selectSearchNoticeListCount(pageMaker);

		// PageMaker 완성.
		pageMaker.setTotalCount(totalCount);
		
		return noticeList;
	}

	@Override
	public NoticeVO detail(int nno) throws SQLException {
		NoticeVO notice = noticeDAO.selectNoticeByNno(nno);
		noticeDAO.increaseViewCount(nno);
		return notice;
	}

	@Override
	public NoticeVO getNotice(int nno) throws SQLException {
		NoticeVO notice = noticeDAO.selectNoticeByNno(nno);
		return notice;
	}

	@Override
	public void modify(NoticeVO notice) throws SQLException {
		noticeDAO.updateNotice(notice);
		
	}

	@Override
	public void regist(NoticeVO notice) throws SQLException {
		int nno = noticeDAO.selectNoticeSequenceNextValue();
		notice.setNno(nno);
		noticeDAO.insertNotice(notice);		
	}

	@Override
	public void remove(int nno) throws SQLException {
		noticeDAO.deleteNotice(nno);		
	}
}
