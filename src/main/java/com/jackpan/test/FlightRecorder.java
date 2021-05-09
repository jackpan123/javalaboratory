package com.jackpan.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jackpan
 * @version v1.0 2021/4/26 19:52
 */
public class FlightRecorder {

    public static void main(String[] args) {
        List<Object> items = new ArrayList<>(1);
        try {
            while (true){
                items.add(new Object());
            }
        } catch (OutOfMemoryError e){
            System.out.println(e.getMessage());
        }
        assert items.size() > 0;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
