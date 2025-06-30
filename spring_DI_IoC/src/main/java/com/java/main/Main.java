package com.java.main;

import com.java.cal.Calculator;
import com.java.operator.Divide;
import com.java.operator.Minus;
import com.java.operator.Multiplex;
import com.java.operator.Summation100;

public class Main {

	public static void main(String[] args) {
	
		Calculator cal = new Calculator();
		
		cal.setSum(new Summation100());
		cal.setDiv(new Divide());
		cal.setMulti(new Multiplex());
		cal.setMinus(new Minus());
		
		
		System.out.println(cal.plus(3, 4));
		System.out.println(cal.minus(3, 4));
		System.out.println(cal.div(3, 4));
		System.out.println(cal.multi(3, 4));
	}

}
