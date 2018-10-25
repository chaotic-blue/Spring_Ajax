package com.company.hellospring.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service	//빈 등록
@Aspect		//aspectj-autoproxy 검색 (어드바이스 + 포인트컷)
public class AroundAdvice {
	
	@Around("BeforeAdvice.allpointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		//서비스 메서드 호출
		Object returnObj = pjp.proceed();
		
		stopwatch.stop();
		System.out.println(methodName + "() 메소드 수행에 걸린 시간 : "+ stopwatch.getTotalTimeMillis() + "(ms)초");
		
		return returnObj;
	}
}
