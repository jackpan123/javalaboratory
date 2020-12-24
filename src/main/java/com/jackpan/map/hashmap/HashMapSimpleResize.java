package com.jackpan.map.hashmap;

import java.util.HashMap;

/**
 * HashMap simple resize.
 *
 * @author jackpan
 * @version v1.0 2020/11/15 17:47
 */
public class HashMapSimpleResize {

    private static HashMap map = new HashMap();

    public static void main(String[] args) {

        for (int i=0; i<100000; ++i) {
            final int finalI = i;
            (new Thread() {
                @Override
                public void run() {
                    map.put(finalI, new EasyCoding());
                }
            }).start();
        }
        System.out.println();
    }


}
class UserKey {

    private int id;

    UserKey(int id) {
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

class EasyCoding {}
