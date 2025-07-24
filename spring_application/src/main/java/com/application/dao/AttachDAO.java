package com.application.dao;

import java.sql.SQLException;
import java.util.List;

import com.application.dto.AttachVO;

public interface AttachDAO {

	List<AttachVO> selectAttachByPno(int pno) throws SQLException;
	AttachVO selectAttachByAno(int ano)throws SQLException;
	
	void insertAttach(AttachVO attach)throws SQLException;
	void deletAttach(int ano)throws SQLException;
	void deletAllAttach(int pno)throws SQLException;
}
