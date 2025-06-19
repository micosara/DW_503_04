package com.java.inheritance;

public class HouseCat extends Cat{

	String name;
	String address;
	String protector;
	
	public String getName() {
		return super.name;
	}
	
	@Override
	void meow() {
		System.out.print("¸Û¸Û Â¢¾î¿ä");
	}
	@Override
	void eat() {
		System.out.print("»ç·á¸¦ ");
		super.eat();
	}
	
	
}
