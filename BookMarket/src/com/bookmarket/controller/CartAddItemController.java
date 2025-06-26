package com.bookmarket.controller;

import java.util.Map;

public class CartAddItemController extends Controller{

	@Override
	public void execute(Map<String, Object> request) throws Exception {
		System.out.println("장바구니 아이템 추가하기");
	}

}
