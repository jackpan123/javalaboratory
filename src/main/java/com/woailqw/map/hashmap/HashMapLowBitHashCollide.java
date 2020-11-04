package com.woailqw.map.hashmap;

public class HashMapLowBitHashCollide {

    public static void main(String[] args) {
        Float a = new Float(0.0f);
        for (int i=0; i<10; ++i) {
            a += 1.0f;
            System.out.println(Integer.toBinaryString(a.hashCode()));
        }
    }
}
