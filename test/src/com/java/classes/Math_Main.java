package com.java.classes;

public class Math_Main {

	public static void main(String[] args) {
		System.out.println(Math.PI);
		System.out.println(Math.random());
		System.out.println(Math.sin(45));
		
		Sin s1 = new Sin();
		Sin s2 = new Sin();
		
		s1.angle = 60;
		s2.angle = 45;
		
		System.out.println(s1.sin());
		System.out.println(s2.sin());
		System.out.println(Sin.sin(45));
		System.out.println(s1.sin(45));
		System.out.println(s2.sin(45));

	}

}
