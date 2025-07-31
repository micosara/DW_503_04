package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

//@Component
//@Aspect
public class Advice {
	
	//@After("execution(public * com.spring.aop..밥먹기*(..))")	
	//@Before("execution(public * com.spring.aop..잠자기*(..))")
	public void chikachika() {
		System.out.println("열심히 양치질을 합니다.");
	}
	
	//@Around("execution(public * com.spring.aop..잠자기*(..))")
	public void chikachikaAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("한번 닦았는데...");

		joinPoint.proceed();

		System.out.println("또 닦아요!!!!!!!");
	}

}


