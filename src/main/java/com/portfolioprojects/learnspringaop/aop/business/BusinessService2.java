package com.portfolioprojects.learnspringaop.aop.business;

import com.portfolioprojects.learnspringaop.aop.data.DataService1;
import com.portfolioprojects.learnspringaop.aop.data.DataService2;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {
    private final DataService2 dataService2;

    public BusinessService2(DataService2 dataService2) {
        this.dataService2 = dataService2;
    }

    public int calculateMin() {
        int[] data = dataService2.retrieveData();
//        throw new RuntimeException("Something went wrong");

        return Arrays.stream(data).map(a -> a * 1).min().orElse(0);

    }

//    execute business logic
//    Data

}
