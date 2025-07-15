package com.application.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.application.command.PageMaker;
import com.application.dto.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO {
	private SqlSession session;

	public NoticeDAOImpl(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<NoticeVO> selectSearchNoticeList(PageMaker pageMaker) throws SQLException {
		int startRow = pageMaker.getStartRow();
		int endRow = startRow + pageMaker.getPerPageNum() - 1;

		Map<String, Object> dataParam = new HashMap<String, Object>();
		dataParam.put("startRow", startRow);
		dataParam.put("endRow", endRow);
		dataParam.put("searchType", pageMaker.getSearchType());
		dataParam.put("keyword", pageMaker.getKeyword());

		List<NoticeVO> noticeList = session.selectList("Notice-Mapper.selectSearchNoticeList", dataParam);
		return noticeList;
	}

	@Override
	public int selectSearchNoticeListCount(PageMaker pageMaker) throws SQLException {
		return session.selectOne("Notice-Mapper.selectSearchNoticeListCount", pageMaker);
	}

	@Override
	public NoticeVO selectNoticeByNno(int nno) throws SQLException {
		return session.selectOne("Notice-Mapper.selectNoticeByNno", nno);
	}

	@Override
	public void increaseViewCount(int nno) throws SQLException {
		session.update("Notice-Mapper.increaseViewCount", nno);
	}

	@Override
	public int selectNoticeSequenceNextValue() throws SQLException {
		return session.selectOne("Notice-Mapper.selectNoticeSequenceNextValue");
	}

	@Override
	public void insertNotice(NoticeVO notice) throws SQLException {
		session.insert("Notice-Mapper.insertNotice", notice);
	}

	@Override
	public void updateNotice(NoticeVO notice) throws SQLException {
		session.update("Notice-Mapper.updateNotice", notice);
	}

	@Override
	public void deleteNotice(int nno) throws SQLException {
		session.delete("Notice-Mapper.deleteNotice", nno);
	}

}
