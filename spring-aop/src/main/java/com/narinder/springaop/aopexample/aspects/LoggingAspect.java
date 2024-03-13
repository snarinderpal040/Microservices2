package com.narinder.springaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// Point cut - When ?
	// execution (* PACKAGE.*.*(..))
	@Before("execution(* com.narinder.springaop.aopexample.*.*.*(..))")
	public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
		// Logic - What ?
		logger.info("Before Aspect - {} is called with args {}",joinPoint, joinPoint.getArgs());
	}
	
	@After("execution(* com.narinder.springaop.aopexample.*.*.*(..))")
	public void logMethodCallAfterExecution(JoinPoint joinPoint) {
		logger.info("After Aspect - {} has executed",joinPoint);
	}
	
	@AfterThrowing(pointcut = "execution(* com.narinder.springaop.aopexample.*.*.*(..))", throwing = "exception")
	public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
		logger.info("AfterThrowing Aspect - {} has thrown an exception {}",joinPoint, exception);
	}
	
	@AfterReturning(pointcut = "execution(* com.narinder.springaop.aopexample.*.*.*(..))", returning = "resultValue")
	public void logMethodCallAfterReturning(JoinPoint joinPoint, Object resultValue) {
		logger.info("AfterReturning Aspect - {} has returned {}",joinPoint, resultValue);
	}

}
