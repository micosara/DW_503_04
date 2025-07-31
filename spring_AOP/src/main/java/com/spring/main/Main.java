package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.aop.Behavior;
import com.spring.aop.BehaviorImpl;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = 
		new GenericXmlApplicationContext("classpath:com/spring/context/application-context.xml");
		
		Behavior behavior = ctx.getBean(Behavior.class);
		
		
		behavior.밥먹기();
		behavior.정신수양();		
		behavior.밥먹기();
		behavior.공부하기();
		behavior.놀기();
		behavior.데이트();
		behavior.운동();
		behavior.밥먹기();
		behavior.잠자기();

	}
}
