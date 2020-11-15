package com.jackpan.map.hashmap;

import java.util.HashMap;

/**
 * This experiment was carried out in JDK 1.7.
 *
 * @author jackpan
 * @version v1.0 2020/11/15 15:48
 */
public class HashMapDataLoss {

    private static HashMap map = new HashMap();

    public void putWithIdenticalKey() {
        System.out.println();
        map.put("aa", "aa");
        new Thread("Thread1") {
            public void run() {
                map.put("bb", "bb");
                System.out.println(map);
            }
        }.start();
        new Thread("Thread2") {
            public void run() {
                map.put("bb", "cc");
                System.out.println(map);
            }
        }.start();
        map.get("bb");
        System.out.println();
    }

    public void putWithLossData() {
        System.out.println();
        new Thread("Thread1") {
            public void run() {
                map.put(new UserKey(1), "bb");
                System.out.println(map);
            }
        }.start();
        new Thread("Thread2") {
            public void run() {
                map.put(new UserKey(2), "cc");
                System.out.println(map);
            }
        }.start();
        map.get(new UserKey(1));
    }

    public static void main(String[] args) {
        // new HashMapDataLoss().putWithIdenticalKey();
        new HashMapDataLoss().putWithLossData();
    }

    private class UserKey {

        private int id;

        public UserKey(int id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }
}
