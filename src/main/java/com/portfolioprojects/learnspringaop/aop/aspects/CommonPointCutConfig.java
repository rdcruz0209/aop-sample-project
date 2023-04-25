package com.portfolioprojects.learnspringaop.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfig {

    @Pointcut("execution(* com.portfolioprojects.learnspringaop.aop.*.*.*(..))")
    public void businessAndDataPackageConfig() {
    }

    @Pointcut("execution(* com.portfolioprojects.learnspringaop.aop.business.*.*(..))")
    public void businessPackageConfig() {
    }

    @Pointcut("execution(* com.portfolioprojects.learnspringaop.aop.data.*.*(..))")
    public void dataPackageConfig() {
    }

    @Pointcut("bean(*Service*)")
    public void allPackageConfigUsingBean() {
    }

    @Pointcut("@annotation(com.portfolioprojects.learnspringaop.aop.annotations.TrackTime)")
    public void trackTimeAnnotation() {

    }
}
