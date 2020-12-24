package com.jackpan.basic;

import java.text.DecimalFormat;

/**
 * @author jackpan
 * @version v1.0 2020/12/23 13:27
 */
public class DecimalFormatDemo {

    public static void customFormat(String pattern, double value ) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        System.out.println(value + "  " + pattern + "  " + output);
    }

    static public void main(String[] args) {

        customFormat("###,###.###", 123456.789);
        customFormat("###.##", 123456.789);
        customFormat("000000.0000", 123.78);
        customFormat("$###,###.###", 12345.67);
    }
}
