package test;

import java.util.Scanner;

public class ScannerEX {

	public static void main(String[] args) {
		
		Scanner scann = new Scanner(System.in);
		
		int inputNum = 0;
		
		try {
			System.out.println("정수를 입력하세요.");
			inputNum = Integer.parseInt(scann.nextLine());
			
		}catch(Exception e) {
			System.out.println("숫자가 아닙니다.");
			return;
		}
		System.out.println(inputNum);

	}

}
