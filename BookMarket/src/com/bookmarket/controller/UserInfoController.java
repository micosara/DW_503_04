package com.bookmarket.controller;

import java.util.Map;

import com.bookmarket.view.UserInfoView;
import com.bookmarket.view.View;

public class UserInfoController extends Controller{

	private View view = new UserInfoView();
	
	@Override
	public void execute(Map<String, Object> request) throws Exception {
		view.excute(null);
	}

}
