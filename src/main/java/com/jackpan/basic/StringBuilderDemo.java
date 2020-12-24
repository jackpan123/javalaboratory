package com.jackpan.basic;

/**
 * @author jackpan
 * @version v1.0 2020/12/24 18:04
 */
public class StringBuilderDemo {

    public static void main(String[] args) {
        String palindrome = "Dot saw I was Tod";

        StringBuilder sb = new StringBuilder(palindrome);
        sb.insert(1, "a");
        System.out.println(sb);

        sb.reverse();  // reverse it

        System.out.println(sb);
    }
}
