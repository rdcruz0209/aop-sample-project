package com.portfolioprojects.learnspringaop;

import com.portfolioprojects.learnspringaop.aop.business.BusinessService1;
import com.portfolioprojects.learnspringaop.aop.business.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringAopApplication implements CommandLineRunner {


    private final BusinessService1 businessService1;
    private final BusinessService2 businessService2;

    public LearnSpringAopApplication(BusinessService1 businessService1, BusinessService2 businessService2) {
        this.businessService1 = businessService1;
        this.businessService2 = businessService2;
    }

    private final Logger logger = LoggerFactory.getLogger(getClass());


    public static void main(String[] args) {
        SpringApplication.run(LearnSpringAopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("BusinessService 1: Max Value returned is {}", businessService1.calculateMax());
        logger.info("BusinessService 2: Min Value returned is {}", businessService2.calculateMin());
    }
}
