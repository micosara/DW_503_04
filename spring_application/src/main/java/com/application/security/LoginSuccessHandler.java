package com.application.security;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.application.dto.MemberVO;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	private String logFileName;
	private String logSavedPath;
		
	public LoginSuccessHandler(String logFileName, String logSavedPath) {
		super();
		this.logFileName = logFileName;
		this.logSavedPath = logSavedPath;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		User user = (User)authentication.getDetails();	
		MemberVO loginUser = user.getMemberVO();  
		
		// session 저장
		HttpSession session = request.getSession();	
		session.setAttribute("loginUser", loginUser);
		session.setMaxInactiveInterval(6*60);
		
		//로그인 정보를 스트링으로 저장.
		String tag ="[login:user]";
		String log =tag
					+loginUser.getId()+","					
					+loginUser.getPhone()+","
					+loginUser.getEmail()+","
					+request.getRemoteAddr()+","
					+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		File file=new File(logSavedPath);
		file.mkdirs();
		
		String logFilePath=logSavedPath+File.separator+logFileName;	
		BufferedWriter out=new BufferedWriter(new FileWriter(logFilePath,true));
		
		//로그를 기록
		try {
			out.write(log);
			out.newLine();
		}finally {
			out.close();
		}

		super.onAuthenticationSuccess(request, response, authentication);
	}

	
}
