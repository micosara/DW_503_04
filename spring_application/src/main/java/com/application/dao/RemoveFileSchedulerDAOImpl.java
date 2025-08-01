package com.application.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

public class RemoveFileSchedulerDAOImpl implements RemoveFileSchedulerDAO{

	private SqlSession session;
	public RemoveFileSchedulerDAOImpl(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public int selectCountUsedByImageFromNotice(String fileName) throws SQLException {
		return session.selectOne("Notice-Mapper.selectCountUsedByImage",fileName);
	}

	@Override
	public int selectCountUsedByImageFromPDS(String fileName) throws SQLException {
		return session.selectOne("Pds-Mapper.selectCountUsedByImage",fileName);
	}

	@Override
	public int selectCountUsedByImageFromBoard(String fileName) throws SQLException {
		return session.selectOne("Board-Mapper.selectCountUsedByImage",fileName);
	}
}
