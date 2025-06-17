package com.java.constructor;

public class Ex01 {

	int a,b,c;
	
	public Ex01() {};
	public Ex01(int a) {
		this(a,0,0);
	}
	public Ex01(int a, int b) {
		this(a,b,0);
	}
	public Ex01(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
}





