package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspects {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspects.class);

	@Around("execution(* com.example.demo.serviceImplementation.*.*(..))")
	public void logArraound(ProceedingJoinPoint jointPoint) throws Throwable {
		logger.info("This Method execution is started {} ", jointPoint.getSignature().getName());
		jointPoint.proceed();
		logger.info("This Method execution is Finished {} ", jointPoint.getSignature().getName());

	}
}
