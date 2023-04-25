package com.portfolioprojects.learnspringaop.aop.business;

import com.portfolioprojects.learnspringaop.aop.annotations.TrackTime;
import com.portfolioprojects.learnspringaop.aop.data.DataService1;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {
    private final DataService1 dataService1;

    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    @TrackTime
    public int calculateMax() {
        int[] data = dataService1.retrieveData();
//        throw new RuntimeException("Something went wrong");

        return Arrays.stream(data).map(a -> a * 1).max().orElse(0);

    }

//    execute business logic
//    Data

}
