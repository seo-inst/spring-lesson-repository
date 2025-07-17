package org.kosa.myproject.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class PerformanceReportAspect {
	private static final Logger logger = LoggerFactory.getLogger(PerformanceReportAspect.class);

	@Around("execution(public * org.kosa.myproject.model..*Service.*(..))")
	public Object checkTimeLogging(ProceedingJoinPoint point) throws Throwable {
		Object retValue = null;
		StopWatch watch = new StopWatch();
		watch.start();
		try {
			retValue = point.proceed(); // 실제 core 메서드를 실행
		} finally {
			watch.stop();
			long time = watch.getTotalTimeMillis();
			if(time>=500 && time<1000) {
				String className = point.getTarget().getClass().getName();
				String methodName = point.getSignature().getName();
				logger.warn("메서드 실행 소요시간 {}  core class {} method {}",time,className,methodName);
			}else if(time>1000) {
				String className = point.getTarget().getClass().getName();
				String methodName = point.getSignature().getName();
				logger.error("메서드 실행 소요시간 {}  core class {} method {}",time,className,methodName);
			}
		}
		return retValue;
	}
}









