package com.jackpan.basic;

import java.util.ArrayList;

/**
 * @author jackpan
 * @version v1.0 2020/12/22 13:34
 */
public class EnsureCapacityTest {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<Object>();
        final int N = 10000000;
        long startTime = System.currentTimeMillis();
        list.ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法前："+(endTime - startTime));

    }
}
