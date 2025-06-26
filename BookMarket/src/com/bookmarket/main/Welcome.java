package com.bookmarket.main;

import com.bookmarket.controller.Controller;
import com.bookmarket.controller.MainController;

public class Welcome {
	
	public static void main(String[] args) {
		Controller main = new MainController();
		
		try {
			while(true) main.execute(null);
			
		} catch (Exception e) {
			System.out.println("프로그램을 시작할 수 없습니다.");
		}
	}
	

	
}
