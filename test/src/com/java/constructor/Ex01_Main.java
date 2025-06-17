package com.java.constructor;

public class Ex01_Main {

	public static void main(String[] args) {
		Ex01 e1 = new Ex01();
		print(e1);
		
		Ex01 e2 = new Ex01(10);
		print(e2);
		
		Ex01 e3 = new Ex01(10,20,30);
		print(e3);
	}
	
	public static void print(Ex01 e) {
		System.out.println(e.a);
		System.out.println(e.b);
		System.out.println(e.c);
	}

}
