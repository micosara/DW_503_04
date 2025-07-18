package com.application.dao;

import java.sql.SQLException;
import java.util.List;

import com.application.command.PageMaker;
import com.application.dto.PdsVO;

public interface PdsDAO {

	
	List<PdsVO> selectSearchPdsList(PageMaker pageMaker)throws SQLException;
	int selectSearchPdsListCount(PageMaker pageMaker)throws SQLException;
	PdsVO selectPdsByPno(int pno)throws SQLException;
	int selectPdsSeqNext()throws SQLException;
	
	void insertPds(PdsVO pds)throws SQLException;
	void updatePds(PdsVO pds)throws SQLException;
	void increaseViewCnt(int pno)throws SQLException;
	void deletePds(int pno)throws SQLException;
}
