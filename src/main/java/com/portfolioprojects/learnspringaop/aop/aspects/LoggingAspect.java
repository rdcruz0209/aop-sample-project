package com.portfolioprojects.learnspringaop.aop.aspects;

//1. Configuration
//2. AOP

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


//Declare as Configuration
//Declare as Aspect
@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger((getClass()));


    //Pointcut - When?
    // syntax = execution(* PACKAGE.*.*(..))
    //execution(* com.portfolioprojects.learnspringaop.aop.business.*.*(..))

    @Before("com.portfolioprojects.learnspringaop.aop.aspects.CommonPointCutConfig.allPackageConfigUsingBean()")
    //When?
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        //What to do when called
        logger.info(" Before Aspect - {} is called with arguments: {}", joinPoint, joinPoint.getArgs());
    }

    @After("com.portfolioprojects.learnspringaop.aop.aspects.CommonPointCutConfig.businessAndDataPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info(" After Aspect - {} has executed", joinPoint);
    }

    @AfterThrowing(
            pointcut = "com.portfolioprojects.learnspringaop.aop.aspects.CommonPointCutConfig.businessAndDataPackageConfig()",
            throwing = "exception")
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info(" AfterThrowing Aspect - {} has thrown an exception {}", joinPoint, exception);
    }

    @AfterReturning(
            pointcut = "com.portfolioprojects.learnspringaop.aop.aspects.CommonPointCutConfig.dataPackageConfig()",
            returning = "resultValue")
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
        logger.info(" AfterReturning Aspect - {} has successfully executed and returned {}", joinPoint, resultValue);
    }


}
