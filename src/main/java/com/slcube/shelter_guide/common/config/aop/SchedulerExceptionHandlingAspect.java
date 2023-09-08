package com.slcube.shelter_guide.common.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class SchedulerExceptionHandlingAspect {

    @Around("execution(* com.slcube.shelter_guide.batch.external_api.scheduler.*.*(..))")
    public Object handleException(ProceedingJoinPoint joinPoint) throws Throwable {

        String className = joinPoint.getTarget().getClass().getName();

        try {
            log.info(">>> Start Fetch Shelter Information From External Api : {}", className);

            Object proceed = joinPoint.proceed();

            log.info(">>> Successfully complete Fetch Shelter Information From External Api : {}", className);

            return proceed;

        } catch (Exception e) {
            log.error(">>> Fetch Shelter Information From External Api Exception : " + className, e);
            throw e;
        }

    }
}
