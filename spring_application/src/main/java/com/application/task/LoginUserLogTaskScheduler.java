package com.application.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.application.dao.LoginUserLogDAO;

public class LoginUserLogTaskScheduler {

	private LoginUserLogDAO loginUserLogDAO;
	private String savePath="c:\\log";
	private String fileName="login_user_log.csv";
	
	
	public LoginUserLogTaskScheduler(LoginUserLogDAO loginUserLogDAO) {
		this.loginUserLogDAO = loginUserLogDAO;
	}

	public LoginUserLogTaskScheduler(LoginUserLogDAO loginUserLogDAO, String savePath, String fileName) {
		this.loginUserLogDAO = loginUserLogDAO;
		this.savePath = savePath;
		this.fileName = fileName;
	}
	
	public void loginUserLogToDataBase() throws Exception{
		FileReader reader = new FileReader(savePath+File.separator+fileName);		
		BufferedReader in=new BufferedReader(reader);
		
		loginUserLogDAO.deleteLoginUserLog();
		
		String textLine=null;
		try {
			while((textLine=in.readLine())!=null) {
				String[] logData =textLine.replace("[login:user]","").split(",");
				
				Map<String,Object> logVO=new HashMap<String,Object>();
				
				logVO.put("id",logData[0]);
				logVO.put("phone",logData[1]);
				logVO.put("email",logData[2]);
				logVO.put("ipAddress",logData[3]);
				logVO.put("indate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
													.parse(logData[4]));
				loginUserLogDAO.insertLoginUserLog(logVO);		
			}
		}finally {
			if(in!=null) in.close();
			if(reader!=null) reader.close();
		}
	}
	
}






