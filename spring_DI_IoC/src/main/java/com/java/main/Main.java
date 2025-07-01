package com.java.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.java.cal.Calculator;

public class Main {

	public static void main(String[] args) {
	
//		Calculator cal = new Calculator();
//		
//		cal.setSum(new Summation100());
//		cal.setDiv(new Divide());
//		cal.setMulti(new Multiplex());
//		cal.setMinus(new Minus());
		
		ApplicationContext context 
		= new GenericXmlApplicationContext(
				"classpath:com/spring/context/application-context.xml");
		
		Calculator cal = context.getBean("calc",Calculator.class);
		
		System.out.println(cal.plus(3, 4));
		System.out.println(cal.minus(3, 4));
		System.out.println(cal.div(3, 4));
		System.out.println(cal.multi(3, 4));
	}

}
