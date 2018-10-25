package com.company.hellospring.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service	//빈 등록
@Aspect		//aspectj-autoproxy 검색 (어드바이스 + 포인트컷) 자동으로 aop 설정
public class AfterAdvice {
	
	@After("BeforeAdvice.allpointcut()")
	public void finallyLog() {
		System.out.println("[사후 처리] 무조건 실행");
	}
}
