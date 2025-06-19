package com.java.inheritance;



public class Cat_main {

	public static void main(String[] args) {
		HouseCat cat = new HouseCat();
		cat.name = "Kim";
		HouseCat cat2 = (HouseCat)cat;
		
		System.out.println(cat2.getName());
		System.out.println(cat.name);
		
	}

}









