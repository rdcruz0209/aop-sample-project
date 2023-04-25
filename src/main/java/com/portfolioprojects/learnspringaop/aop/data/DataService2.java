package com.portfolioprojects.learnspringaop.aop.data;

import com.portfolioprojects.learnspringaop.aop.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {

    @TrackTime
    public int[] retrieveData() {
        try {
            Thread.sleep(36);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new int[]{111, 222, 333, 444, 555};
    }

}
