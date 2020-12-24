package com.jackpan.map.hashmap;

public class ConvertJavaDocToPlainText {

    public static void main(String[] args) {
        String ha ="Returns the same hash code for the given object as\n"
            + "     * would be returned by the default method hashCode(),\n"
            + "     * whether or not the given object's class overrides\n"
            + "     * hashCode().\n"
            + "     * The hash code for the null reference is zero.";

        System.out.println(ha.replaceAll("[*\n]", ""));
    }

}
