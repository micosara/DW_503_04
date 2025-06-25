package com.bookmarket.main;

import java.util.Scanner;

import com.bookmarket.controller.UserController;

public class Welcome {

	UserController ucont = new UserController();
	
	public static void main(String[] args) {
		Welcome w = new Welcome();
		w.ucont.login();
	}
	
	public void start() {

		Scanner input = new Scanner(System.in);
		String userName = null;
		String userMobile = null;
		String menu = null;

		System.out.print("이름 : ");
		userName = input.nextLine();

		System.out.print("연락처 : ");
		userMobile = input.nextLine();

		String greeting = "Welcome to Shopping Mall";
		String tagline = "Welcome to Book Market!";

		do {
			System.out.println("***********************************************");
			System.out.println("\t" + greeting);
			System.out.println("\t" + tagline);
			menuIntroduction();

			System.out.print("메뉴 번호 : ");
			menu = input.nextLine();
			System.out.println(menu + "번을 선택했습니다");

			switch (menu) {
			case "1":
				menuGuestInfo(userName, userMobile);
				break;
			case "2":
				menuCartItemList();
				break;
			case "3":
				menuCartClear();
				break;
			case "4":
				menuCartAddItem(mBook);
				break;
			case "5":
				menuCartRemoveItemCount();
				break;
			case "6":
				menuCartRemoveItem();
				break;
			case "7":
				menuCartBill();
				break;
			case "8":
				menuExit();
				break;
			default:
				System.out.println("메뉴 선택이 올바르지 않습니다.");
			}
		} while (!menu.equals("8"));
	}

	public static void menuIntroduction() {
		System.out.println("***********************************************");
		System.out.println(" 1. 고객 정보 확인하기 \t\t4. 바구니에 항목 추가하기");
		System.out.println(" 2. 장바구니 상품 목록 보기 \t5. 장바구니의 항목 수량 줄이기");
		System.out.println(" 3. 장바구니 비우기 \t\t6. 장바구니의 항목 삭제하기");
		System.out.println(" 7. 영수증 표시하기 \t\t8. 종료");
		System.out.println("***********************************************");
	}


	

	public static void menuExit() {
		System.out.println("프로그램을 종료합니다.");
	}

	
}
