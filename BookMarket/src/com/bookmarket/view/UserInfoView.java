package com.bookmarket.view;

import java.util.Map;

import com.bookmarket.dto.User;
import com.bookmarket.session.ApplicationSession;

public class UserInfoView extends View{

	@Override
	public Map<String, Object> excute(Map<String, Object> params) {
		User loginUser 
			= (User)ApplicationSession.getSession().getAttribute("loginUser");
		
		System.out.println("아이디 : "+loginUser.getId());
		System.out.println("이메일 : "+loginUser.getEmail());
		System.out.println("전화번호 : "+loginUser.getPhone());
		System.out.println("주  소 : "+loginUser.getAddress());
		System.out.println("권  한 : "+loginUser.getAuthority());
		
		return null;
	}

}
