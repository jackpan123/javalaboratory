package com.jackpan.algorithm;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author jackpan
 * @version v1.0 2020/12/30 13:06
 */
public class DoublingTest {

    public static double timeTrial(int n) {
        int max = 1000000;
        int[] a = new int[n];

        for (int i=0; i < n; ++i) {
            a[i] = StdRandom.uniform(-max, max);
        }

        Stopwatch timer = new Stopwatch();
        int count = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        for (int n = 250; true ; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %5.1f\n", n, time);
        }
    }
}
