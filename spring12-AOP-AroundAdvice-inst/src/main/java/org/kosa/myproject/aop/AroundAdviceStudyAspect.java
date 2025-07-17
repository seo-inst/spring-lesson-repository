package org.kosa.myproject.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.kosa.myproject.model.InventoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect // AOP 담당 클래스임을 알림
@Component // Bean 으로 생성 , 관리됨을 알림
public class AroundAdviceStudyAspect {
	private static final Logger logger = LoggerFactory.getLogger(AroundAdviceStudyAspect.class);

	/*
	 * Around Advice( 적용 시점 ) : before , after , after-returning, after-throwing 4가지
	 * advice를 모두 around advice로 처리할 수 있다 before : 메서드 실행 전 after : 메서드 실행 후 ( 예외
	 * 발생과 관계없이 항상 수행 ) after-returning : 메서드 정상 실행 후 값이 리턴될 때 after-throwing :
	 * Exception 및 Error 발생될 때
	 */
	@Around("execution(public * org.kosa.myproject.model.*Service.*(..))")
	public Object testAround(ProceedingJoinPoint point) throws Throwable {
		// 실제 Core 를 수행 , 만약 Around Advice 환경에서
		// 반드시 명시해야 한다. 아래 코드를 명시하지 않으면 Core 가 실행되지 않는다
		String className = point.getTarget().getClass().getName();
		String methodName = point.getSignature().getName();
		logger.debug("**AOP Before**class:{} method:{}", className, methodName);
		Object retValue = null;
		try {
			retValue = point.proceed();// 실제 Core 메서드를 실행: 매우 중요한 코드라인
			if (retValue != null) { // 리턴값이 있을때
				// 테스트 용도로 retValue 로 조작해본다
				// retValue+=" 불목~~";
				logger.debug("**AOP After-Returing**return value: {}", retValue);// 정상적으로 리턴할 때 실행하는 advice
			}
		} catch (InventoryException ie) {// after throwing : 재고부족으로 예외 발생할 때 대처 
			// 공급처에 정보 전달 
				logger.error("**AOP After-Throwing**message:{}",ie.getMessage(),ie);
				throw ie;
		} finally {
				logger.error("**AOP After**"); //  예외 발생 여부와 관계없이 항상 실행 
		}
		return retValue;
	}
}






