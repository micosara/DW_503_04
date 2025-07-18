package com.application.service;

import java.sql.SQLException;
import java.util.List;

import com.application.command.PageMaker;
import com.application.dto.ReplyVO;

public interface ReplyService {
	
	//목록
	List<ReplyVO> list(int bno, PageMaker pageMaker)throws SQLException;
	
	//등록
	void regist(ReplyVO reply) throws SQLException;
	
	//수정
	void modify(ReplyVO reply)throws SQLException;
	
	//삭제
	void remove(int rno)throws SQLException;
	
}

