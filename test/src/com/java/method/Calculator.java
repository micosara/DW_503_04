package com.java.method;

public class Calculator {

	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		
		System.out.println(sum(1.4,1.5));
		System.out.println(sub(x,y));
		System.out.println(multi(x,y));
		System.out.println(div(x,y));

	}

	public static int sum(int a) {
		return a + a;
	} // 더하기
	public static int sum(int a, int b) {
		return a + b;
	} // 더하기
	public static float sum(float a, float b) {
		return a + b;
	} // 더하기
	public static double sum(double a, double b) {
		return a + b;
	} // 더하기
	public static int sum(int a, int b, int c) {
		return a + b + c;
	} // 더하기

	public static int sub(int a, int b) {
		return a - b;
	} // 빼기

	public static int multi(int a, int b) {
		return a * b;
	} // 곱하기

	public static float div(int a, int b) {
		return a / (float) b;
	} // 나누기

}
