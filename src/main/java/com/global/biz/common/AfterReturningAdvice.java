package com.global.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.global.biz.user.UserVO;

// 메소드가 실행되고 나서 수행

@Service
@Aspect
public class AfterReturningAdvice {

	/*
	@Pointcut("execution(* com.global.biz..*Impl.get*(..))")
	   public void getPointcut() {
	   }
	*/
	@AfterReturning(pointcut = "PointcutCommon.getPointcut()", returning = "returnObj")	
	public void afterLog(JoinPoint jp, Object returnObj) {
		
		String method = jp.getSignature().getName();
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO)returnObj;
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName()+"로그인(Admin)");
			}
		}
		
		System.out.println("[사후 처리] "+method+"() 메소드 리턴값: "
		+returnObj.toString());
	}
	
}
