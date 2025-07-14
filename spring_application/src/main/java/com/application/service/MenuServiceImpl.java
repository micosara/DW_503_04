package com.application.service;

import java.sql.SQLException;
import java.util.List;

import com.application.dao.MenuDAO;
import com.application.dto.MenuVO;

public class MenuServiceImpl implements MenuService{

	private MenuDAO menuDAO;
	public MenuServiceImpl(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}
	@Override
	public List<MenuVO> getMainMenuList() throws SQLException {
		return menuDAO.selectMainMenu();
	}
	@Override
	public List<MenuVO> getSubMenuList(String mCode) throws SQLException {
		return menuDAO.selectSubMenu(mCode);
	}
	@Override
	public MenuVO getMenuByMcode(String mCode) throws SQLException {
		return menuDAO.selectMenuByMcode(mCode);
	}
	@Override
	public MenuVO getMenuByMname(String mName) throws SQLException {
		return menuDAO.selectMenuByMname(mName);
	}
}
