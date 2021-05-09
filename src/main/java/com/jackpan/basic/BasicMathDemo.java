package com.jackpan.basic;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author jackpan
 * @version v1.0 2020/12/23 13:34
 */
public class BasicMathDemo {

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        double a = -191.635;
        double b = 43.74;
        int c = 16, d = 45;

        System.out.printf("The absolute value " + "of %.3f is %.3f%n",
                a, Math.abs(a));

        System.out.printf("The ceiling of " + "%.2f is %.0f%n",
                b, Math.ceil(b));

        System.out.printf("The floor of " + "%.2f is %.0f%n",
                b, Math.floor(b));

        System.out.printf("The rint of %.2f " + "is %.0f%n",
                b, Math.rint(b));

        System.out.printf("The round of %.2f " + "is %d%n",
                b, Math.round(b));

        System.out.printf("The max of %d and " + "%d is %d%n",
                c, d, Math.max(c, d));

        System.out.printf("The min of of %d " + "and %d is %d%n",
                c, d, Math.min(c, d));

        int n =3;
        int size = 11;
        double f1 = new BigDecimal((float)n/size).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
    }
}
