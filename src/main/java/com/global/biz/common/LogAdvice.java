package com.global.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// BoardService (비즈니스 로직) 실행되기전 공통으로 처리할 
// 로직을 처리하는 클래스
@Service
public class LogAdvice {

	@Pointcut("execution(* com.global.biz..*Impl.*(..))")
	public void allPointcut() {
		// 포인트 컷
	}
	@Pointcut("execution(* com.global.biz..*Impl.get*(..))")
   public void getPointcut() {
		
	}
	
	@Before("allPointcut()")// 어드바이스
	public void printLog() {
		System.out.println("[공통로직] 비즈니스 로직(bean) 수행 전 동작.....");
	}
}
