package com.bookmarket.controller;

import java.util.Map;

import com.bookmarket.session.ApplicationSession;

public class ExitController extends Controller{

	@Override
	public void execute(Map<String, Object> request) throws Exception {
		System.out.println("프로그램을 종료합니다.");
		ApplicationSession.getSession().removeAttribute("loginUser");
		System.exit(0);
	}

}
