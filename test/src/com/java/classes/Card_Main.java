package com.java.classes;

public class Card_Main {

	public static void main(String[] args) {
		
		System.out.println(Card.WIDTH);
		System.out.println(Card.HEIGHT);

		Card card1 = new Card("Heart",7);
//		card1.kind = "Heart";
//		card1.num = 7;
		
		Card card2 = new Card("Diamond",8);
//		card2.kind = "Diamond";
//		card2.num = 8;
		
		Card.WIDTH = 1000;
		card1.WIDTH = 2000;
		card2.WIDTH = 3000;
		
		System.out.println(card1.kind);
		System.out.println(card2.kind);
		Card.size();
		card1.size();
		card2.size();
		
		//Card.info();
		card1.info();
		card2.info();
		
		System.out.println(Card.copyWriter());
		System.out.println(Card.whos("±èÇü¹Î"));
	}

}





