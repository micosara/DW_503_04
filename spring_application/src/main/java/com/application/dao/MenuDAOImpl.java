package com.application.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.application.dto.MenuVO;

public class MenuDAOImpl implements MenuDAO{

	private SqlSession session;

	public MenuDAOImpl(SqlSession session) {
		this.session = session;
	}

	public List<MenuVO> selectMainMenu() throws SQLException {
		return session.selectList("Menu-Mapper.selectMainMenu");
	}

	@Override
	public List<MenuVO> selectSubMenu(String mCode) throws SQLException {
		return session.selectList("Menu-Mapper.selectSubMenu", mCode);
	}

	@Override
	public MenuVO selectMenuByMcode(String mCode) throws SQLException {
		return session.selectOne("Menu-Mapper.selectMenuByMcode", mCode);
	}

	@Override
	public MenuVO selectMenuByMname(String mName) throws SQLException {
		return session.selectOne("Menu-Mapper.selectMenuByMname", mName);
	}
}
