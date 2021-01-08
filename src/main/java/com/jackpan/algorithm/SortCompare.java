package com.jackpan.algorithm;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author jackpan
 * @version v1.0 2021/1/7 13:22
 */
public class SortCompare {

    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();

        if (alg.equals("Insertion")) {
            Insertion.sort(a);
        }

        if (alg.equals("Selection")) {
            Selection.sort(a);
        }

        if (alg.equals("Shell")) {

        }

        if (alg.equals("Merge")) {

        }

        if (alg.equals("Quick")) {

        }

        if (alg.equals("Heap")) {

        }

        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t=0; t<T; ++t) {
            for (int i=0; i<N; ++i) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }

        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Insertion";
        String alg2 = "Selection";
        int N = 1000;
        int T = 1000;
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);

        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t1/t2, alg2);
    }
}
