package com.company.hellospring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service	//빈 등록
@Aspect		//aspectj-autoproxy 검색 (어드바이스 + 포인트컷)
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut="BeforeAdvice.allpointcut()", returning="returnObj")
	//이렇게 반환 받는 값이 있으면 pointcut= returning = 이렇게 한다.
	public void afterLog(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		String returnStr = returnObj != null ? returnObj.toString() : "";//모든 메서드 뒤에는 toString이 다있다.
		System.out.println("[사후처리] " + methodName + " : " + returnStr);
	}
}
