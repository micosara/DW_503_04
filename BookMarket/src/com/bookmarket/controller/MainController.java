package com.bookmarket.controller;

import java.util.Map;

import com.bookmarket.view.MainView;
import com.bookmarket.view.View;

public class MainController extends Controller {
	private View view = new MainView();

	@Override
	public void execute(Map<String, Object> request) throws Exception {

		Map<String, Object> dataMap = view.excute(null);

		String menu = (String) dataMap.get("menu");

		switch (menu) {
		case "1":
			break;
		case "2":
			break;
		case "3":
			break;
		case "4":
			break;
		case "5":
			break;
		case "6":
			break;
		case "7":
			break;
		case "8":
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			break;
		default:
			System.out.println("메뉴 선택이 올바르지 않습니다.");
		}
	}

}
