package com.jackpan.map.hashmap;


import java.util.HashMap;

public class HashMapInfiniteLoop {
    private static HashMap<Integer,String> map = new HashMap<Integer,String>(2, 1.5f);
    public static void main(String[] args) {
        System.out.println();
        map.put(5, "C");
        new Thread("Thread1") {
            public void run() {
                map.put(7, "B");
                map.put(9, "B");
                System.out.println(map);
            }
        }.start();
        new Thread("Thread2") {
            public void run() {
                map.put(3, "A");
                map.put(13, "A");
                System.out.println(map);
            }
        }.start();
        map.get(11);
    }
}
