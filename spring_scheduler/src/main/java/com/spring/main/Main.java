package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx 
		= new GenericXmlApplicationContext("classpath:com/spring/context/task-context.xml");
	}
}
