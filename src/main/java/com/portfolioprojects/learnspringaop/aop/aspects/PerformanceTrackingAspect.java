package com.portfolioprojects.learnspringaop.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger((getClass()));

    //    @Around("com.portfolioprojects.learnspringaop.aop.aspects.CommonPointCutConfig.businessAndDataPackageConfig()")
    @Around("com.portfolioprojects.learnspringaop.aop.aspects.CommonPointCutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // Start a timer
        long startTimeMillis = System.currentTimeMillis();
        // Execute the method - JoinPoint does not allow execution of method so we use ProceedingJoinPoint
//        ProceedingJoinPoint exposes the proceed(..) method in order to support around advice in @AJ aspects
        Object returnValue = proceedingJoinPoint.proceed();
//        System.out.println(returnValue.getClass());
//        System.out.println(proceedingJoinPoint.getThis());
        // Stop the Timer
        long stopTimeMillis = System.currentTimeMillis();
        long executionDuration = stopTimeMillis - startTimeMillis;
        logger.info(
                "Around Aspect - {} method executed in {}",
                proceedingJoinPoint, executionDuration);

        return returnValue;
    }


}
