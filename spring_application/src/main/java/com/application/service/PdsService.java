package com.application.service;

import java.sql.SQLException;
import java.util.List;

import com.application.command.PageMaker;
import com.application.dto.PdsVO;

public interface PdsService {

	//목록
	List<PdsVO> searchList(PageMaker pageMaker) throws SQLException;
	
	//등록
	void regist(PdsVO pds)throws SQLException;
	
	//읽기
	PdsVO detail(int pno) throws SQLException;
	
	//수정
	void modify(PdsVO pds) throws SQLException;
	PdsVO getPds(int pno) throws SQLException;
	
	//삭제
	void remove(int pno) throws SQLException;	
}
