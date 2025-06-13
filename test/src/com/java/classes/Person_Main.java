package com.java.classes;

public class Person_Main {

	public static void main(String[] args) {
		Person p = new Person();
		Person pp = new Person();
		
		p.name = "kim";
		p.reg_num = 11;
		
		pp.name = "Pak";
		pp.reg_num = 33;
		
		System.out.println(p.name);
		System.out.println(p.reg_num);
		
		System.out.println(pp.name);
		System.out.println(pp.reg_num);
		
		pp = p;
		
		System.out.println(pp.name);
		System.out.println(pp.reg_num);
		
		
	}

}






