package com.application.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.application.command.PageMaker;
import com.application.dto.ReplyVO;

public class ReplyDAOImpl implements ReplyDAO{

	private SqlSession session;
	public ReplyDAOImpl(SqlSession session) {
		this.session = session;
	}
	@Override
	public List<ReplyVO> selectReplyList(int bno,PageMaker pageMaker) throws SQLException {		
		int offset = pageMaker.getStartRow()-1;
		int limit = pageMaker.getPerPageNum();
		
		RowBounds bounds = new RowBounds(offset,limit);
		
		return session.selectList("Reply-Mapper.selectReplyList",bno,bounds);
	}
	@Override
	public int countReply(int bno) throws SQLException {		
		return session.selectOne("Reply-Mapper.countReply",bno);
	}
	@Override
	public int selectReplySeqNextValue() throws SQLException {		
		return session.selectOne("Reply-Mapper.selectReplySeqNextValue");
	}
	@Override
	public void insertReply(ReplyVO reply) throws SQLException {
		session.insert("Reply-Mapper.insertReply",reply);		
	}
	@Override
	public void updateReply(ReplyVO reply) throws SQLException {
		session.update("Reply-Mapper.updateReply",reply);
	}
	@Override
	public void deleteReply(int rno) throws SQLException {
		session.delete("Reply-Mapper.deleteReply",rno);		
	}
	
}
