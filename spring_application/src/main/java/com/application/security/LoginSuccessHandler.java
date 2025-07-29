package com.application.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.application.dto.MemberVO;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		User user = (User)authentication.getDetails();	
		MemberVO loginUser = user.getMemberVO();  
		
		// session 저장
		HttpSession session = request.getSession();	
		session.setAttribute("loginUser", loginUser);
		session.setMaxInactiveInterval(6*60);
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

	
}
