package com.application.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.application.dto.AttachVO;

public class AttachDAOImpl implements AttachDAO{
	
	private SqlSession session;
	public AttachDAOImpl(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<AttachVO> selectAttachByPno(int pno) throws SQLException {
		return session.selectList("Attach-Mapper.selectAttachByPno",pno);
	}

	@Override
	public AttachVO selectAttachByAno(int ano) throws SQLException {
		return session.selectOne("Attach-Mapper.selectAttachByAno",ano);
	}

	@Override
	public void insertAttach(AttachVO attach) throws SQLException {
		session.insert("Attach-Mapper.insertAttach",attach);
		
	}

	@Override
	public void deletAttach(int ano) throws SQLException {
		session.delete("Attach-Mapper.deleteAttach",ano);
		
	}

	@Override
	public void deletAllAttach(int pno) throws SQLException {
		session.delete("Attach-Mapper.deleteAllAttach",pno);
		
	}
}
