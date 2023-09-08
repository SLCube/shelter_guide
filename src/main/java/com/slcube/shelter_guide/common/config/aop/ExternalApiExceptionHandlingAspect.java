package com.slcube.shelter_guide.common.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExternalApiExceptionHandlingAspect {

    @Around("execution(* com.slcube.shelter_guide.batch.external_api.service.*.*(..))")
    public Object handleException(ProceedingJoinPoint joinPoint) throws Throwable {

        String className = joinPoint.getTarget().getClass().getName();

        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            log.error("Error while calling " + className + " REST API : ", e);
            throw e;
        }
    }
}
