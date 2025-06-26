package com.bookmarket.controller;

import java.util.Map;

import com.bookmarket.service.OracleUserServiceImpl;
import com.bookmarket.service.UserService;
import com.bookmarket.view.LoginView;
import com.bookmarket.view.View;

public class LoginController extends Controller{

	private View view = new LoginView();
	private UserService service = new OracleUserServiceImpl();
	
	@Override
	public void execute(Map<String, Object> request) throws Exception {
		
		
	}

}
