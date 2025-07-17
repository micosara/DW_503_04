package com.application.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.application.command.PageMaker;
import com.application.dto.BoardVO;

public class BoardDAOImpl implements BoardDAO{
	
private SqlSession session;
	
	public BoardDAOImpl(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<BoardVO> selectSearchBoardList(PageMaker pageMaker) throws SQLException {
		int offset = pageMaker.getStartRow()-1;
		int limit = pageMaker.getPerPageNum();
		RowBounds bounds = new RowBounds(offset,limit);
		
		List<BoardVO> boardList = session.selectList("Board-Mapper.selectSearchBoardList",pageMaker,bounds);
		
		return boardList;
	}

	@Override
	public int selectSearchBoardListCount(PageMaker pageMaker) throws SQLException {
		int count = session.selectOne("Board-Mapper.selectSearchBoardListCount",pageMaker);
		return count;
	}

	@Override
	public BoardVO selectBoardByBno(int bno) throws SQLException {
		BoardVO board = session.selectOne("Board-Mapper.selectBoardByBno",bno);
		return board;
	}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		session.insert("Board-Mapper.insertBoard",board);
	}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		session.update("Board-Mapper.updateBoard",board);		
	}

	@Override
	public void deleteBoard(int bno) throws SQLException {
		session.delete("Board-Mapper.deleteBoard",bno);		
	}

	@Override
	public void increaseViewCnt(int bno) throws SQLException {
		session.update("Board-Mapper.increaseViewCnt",bno);		
	}

	@Override
	public int selectBoardSeqNext() throws SQLException {
		int bno = session.selectOne("Board-Mapper.selectBoardSeqNext");
		return bno;
	}
}
