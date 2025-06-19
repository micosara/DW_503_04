package com.bookmarket.controller;

import java.util.Map;

import com.bookmarket.exception.InvalidPasswordException;
import com.bookmarket.exception.NotFoundUserIDException;
import com.bookmarket.service.UserService;
import com.bookmarket.view.LoginView;
import com.bookmarket.view.View;

public class UserController {

	private View view = new LoginView();
	private UserService service = new UserService();
	
	public void login() {
		Map<String,Object> param = view.excute(null);
		
		String id = (String)param.get("id");
		String pwd =(String)param.get("pwd");
		
		try {
			service.login(id, pwd);
			// 로그인성공
			System.out.println("로그인 성공");
			
		} catch (NotFoundUserIDException| InvalidPasswordException e) { 
			System.out.println(e.getMessage());
		}
	}
}





