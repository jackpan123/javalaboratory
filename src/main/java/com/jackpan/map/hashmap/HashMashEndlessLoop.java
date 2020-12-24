package com.jackpan.map.hashmap;

import java.util.HashMap;

/**
 * Hash mash endless loop.
 *
 * @author jackpan
 * @version v1.0 2020/11/15 21:29
 */
public class HashMashEndlessLoop {

    private static HashMap<Long, EasyCoding> map = new HashMap<Long, EasyCoding>();

    public static void main(String[] args) {
        for (int i=0; i<100000; ++i) {
            (new Thread() {
                @Override
                public void run() {
                    map.put(System.nanoTime(), new EasyCoding());
                }
            }).start();
        }
    }
}
