package com.bookmarket.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDataSource {

	private static OracleDataSource instance = new OracleDataSource();

	public static OracleDataSource getInstance() {
		return instance;
	}

	private String driverClassName;
	private String url;
	private String username;
	private String password;

	private OracleDataSource() {
		this.url = "jdbc:oracle:thin:@localhost:1521:XE";
		this.username = "dw001";
		this.password = "dw001";

		try {
			Class.forName(driverClassName);
			System.out.println("init datasource loading...");

		} catch (ClassNotFoundException e) {
			System.out.println("fail datasource loading...");
		}
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Connection getConnection() throws SQLException{
		Connection conn = this.getConnection(this.url,this.username,this.password);
		return conn;
	}
	public Connection getConnection(String url, String username, String password) 
						throws SQLException{
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}

}






