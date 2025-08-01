package com.application.dao;

import java.sql.SQLException;

public interface RemoveFileSchedulerDAO {

	int selectCountUsedByImageFromNotice(String fileName) throws SQLException;
	int selectCountUsedByImageFromPDS(String fileName) throws SQLException;
	int selectCountUsedByImageFromBoard(String fileName) throws SQLException;
}
