package com.java.quiz;

import java.util.Scanner;

public class Quiz_UpDown {
	public static void main(String[] args) {
		int input = 0;
		int comNum = (int) (Math.random() * 100 + 1);

		int MAX = 100;
		int MIN = 1;
		int count = 0;

		final String INTRO = "컴퓨터는 숫자를 결정했습니다.\n시작하겠습니다.\n";

		Scanner scan = new Scanner(System.in);

		System.out.println("******** 업다운 게임 ********\n\n");
		System.out.println(INTRO);

		boolean flagMenu1 = true;
		while (flagMenu1) {
			System.out.println(MIN + "부터 " + MAX + "사이의 숫자를 입력하세요.\n");

			input = Integer.parseInt(scan.nextLine().trim());
			count++;
			if (input != comNum) {
				if (input >= MIN && input < comNum) {
					System.out.println("업!!!");
					MIN = input + 1;
				} else if (input <= MAX && input > comNum) {
					System.out.println("다운!!!");
					MAX = input - 1;
				} else {
					System.out.println("입력이 올바르지 않습니다.");
				}
				continue;
			}

			System.out.println("축하합니다. 정답입니다.");
			System.out.println(count + "번째 맞췄습니다.");

			input = 0;
			comNum = (int) (Math.random() * 100 + 1);
			MAX = 100;
			MIN = 1;
			count = 0;

			boolean flagMenu2 = true;
			while (flagMenu2) {
				System.out.print("\n\n게임을 종료하시겠습니까? (y/n)\n");
				switch (scan.nextLine().charAt(0)) {
				case 'Y':
				case 'y':
					System.out.println("게임을 종료합니다.");
					flagMenu1 = false;
					flagMenu2 = false;
					
					break;
				case 'N':
				case 'n':
					System.out.println("게임을 계속 진행합니다.\n\n");
					flagMenu1 = true;
					flagMenu2 = false;
					
					System.out.println(INTRO);
					break;
				default:
					System.out.println("메뉴선택이 잘못 되었습니다");
				}
			}
		}
	}
}
