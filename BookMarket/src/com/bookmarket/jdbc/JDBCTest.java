package com.bookmarket.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bookmarket.dto.Book;

public class JDBCTest {

	public static void main(String[] args) throws Exception{
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "dw001";
		String password = "dw001";
		
		// 1. driver loading
		Class.forName(driverClass);
		
		// 2. connection
		Connection conn = DriverManager.getConnection(url,username,password);
		
		// 3. statement 
		Statement stmt = conn.createStatement();
		
		// 4. sql
		String sql = "select * from book";
		
		// 5. execute statement
		ResultSet rs = stmt.executeQuery(sql);
		
		// 6. object mapping
		while(rs.next()) {
			System.out.println(rs.getString("bookId"));
			
		}
		
	}

}




