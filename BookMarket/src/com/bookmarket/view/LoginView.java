package com.bookmarket.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginView extends View {

	@Override
	public Map<String, Object> excute(Map<String, Object> params) {
		Scanner scann = new Scanner(System.in);
		String id = null;
		String pwd = null;
		
		System.out.println("****************** 로그인  *******************");
		System.out.print("아이디 : ");
		id = scann.nextLine();
		System.out.print("패스워드 : ");
		pwd = scann.nextLine();
		
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("id", id);
		resultMap.put("pwd", pwd);
		
		return resultMap;
	}

}
