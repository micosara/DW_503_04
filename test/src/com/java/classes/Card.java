package com.java.classes;

public class Card {

	static int WIDTH = 100;
	static int HEIGHT = 200;

	String kind;
	int num;

	public Card(String kind, int num) {
		super();
		this.kind = kind;
		this.num = num;
	}

	public static void size() {
		System.out.println(WIDTH + "X" + HEIGHT);
	}

	public void info() {
		System.out.println(kind + ":" + num);
	}

	public static String copyWriter() {
		return "Kim";
	}

	public static String whos(String name) {
		return name + "\'s card";
	}
}



