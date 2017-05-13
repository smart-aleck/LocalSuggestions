package com.fabs.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class EncryptionLogging {

    private final static Logger logger = LogManager.getLogger();

    @Before("execution(* com.fabs.encryption..*(..))")
    public void before(JoinPoint joinPoint){
        logger.debug(String.format("[%s] called",
                joinPoint.getSignature().toShortString()));
    }

    @AfterReturning(pointcut="execution(* com.fabs.encryption..*(..))", returning="result")
    public void after(JoinPoint joinPoint, Object result){
        logger.debug(String.format("[%s] returns %s",
                joinPoint.getSignature().toShortString(),result));
    }

    @AfterThrowing(pointcut="execution(* com.fabs.encryption..*(..))", throwing = "exception")
    public void afterException(JoinPoint joinPoint, Exception exception){
        logger.error(String.format("[%s] returns %s",
                joinPoint.getSignature().toShortString(), exception));
    }
}
