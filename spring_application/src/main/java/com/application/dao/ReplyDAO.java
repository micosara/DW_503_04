package com.application.dao;

import java.sql.SQLException;
import java.util.List;

import com.application.command.PageMaker;
import com.application.dto.ReplyVO;

public interface ReplyDAO {
	List<ReplyVO> selectReplyList(int bno,PageMaker pageMaker) throws SQLException;
	int countReply(int bno)throws SQLException;
	
	int selectReplySeqNextValue()throws SQLException;
	
	void insertReply(ReplyVO reply)throws SQLException;
	void updateReply(ReplyVO reply)throws SQLException;
	void deleteReply(int rno)throws SQLException;
}
