package com.company.hellospring.common;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service	//빈 등록
@Aspect		//aspectj-autoproxy 검색 (어드바이스 + 포인트컷)
public class AfterThrowingAdvice {
	
	@AfterThrowing("BeforeAdvice.allpointcut()")
	public void exceptionLog() {
		System.out.println("[예외 처리] 비즈니스 로직 수행 중 예외 발생");
	}
}
