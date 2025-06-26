package com.bookmarket.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.bookmarket.dto.User;
import com.bookmarket.session.ApplicationSession;

public class MainView extends View {

	@Override
	public Map<String, Object> excute(Map<String, Object> params) {
		String menu = null;
		Scanner input = new Scanner(System.in);
		
		User loginUser 
		= (User)ApplicationSession.getSession().getAttribute("loginUser");
		
		System.out.println(loginUser.getId()+"님 안녕하세요.");
		System.out.println("전화번호 : "+loginUser.getPhone());
		System.out.println("등급 : "+loginUser.getAuthority());
		
		
		String greeting = "Welcome to Shopping Mall";
		String tagline = "Welcome to Book Market!";
		System.out.println("***********************************************");
		System.out.println("\t" + greeting);
		System.out.println("\t" + tagline);
		System.out.println("***********************************************");
		System.out.println(" 1. 고객 정보 확인하기 \t\t4. 바구니에 항목 추가하기");
		System.out.println(" 2. 장바구니 상품 목록 보기 \t5. 장바구니의 항목 수량 줄이기");
		System.out.println(" 3. 장바구니 비우기 \t\t6. 장바구니의 항목 삭제하기");
		System.out.println(" 7. 영수증 표시하기 \t\t8. 종료");
		System.out.println("***********************************************");
		
		
		System.out.print("메뉴 번호 : ");
		menu = input.nextLine();
		System.out.println(menu + "번을 선택했습니다");
		
		Map<String,Object> dataMap = new HashMap<String,Object>();
		
		dataMap.put("menu",menu);
		return dataMap;
	}

}
