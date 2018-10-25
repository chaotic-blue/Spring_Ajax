package com.company.hellospring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service	//빈 등록
@Aspect		//aspectj-autoproxy 검색 (어드바이스 + 포인트컷)
public class BeforeAdvice {
	
	//포인트 컷
	//포인트 컷은 한군데만 지정하면 된다. 다른 클래스에 해도 됨.
	@Pointcut("execution(* com.company..*Impl.*(..))")
	public void allpointcut() {}
	
	@Pointcut("execution(* com.company..*Impl.get*(..))")
	public void getpointcut() {}
	
	@Before("allpointcut()")
	public void beforeLog(JoinPoint jp) {

		//실행할 서비스 메서드 정보 조회
		String methodName = jp.getSignature().getName();//서비스명
		Object[] args = jp.getArgs();//넘어가는 args 값을 참조 
		//인수가 없을경우 nullpoint 에러 발생
		String argsStr = args != null && args.length>0 ? args[0].toString() : "";
		
		System.out.println("[사전 처리] " + methodName + " : " + argsStr);
	} 
}
