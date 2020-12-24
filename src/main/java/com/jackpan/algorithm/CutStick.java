package com.jackpan.algorithm;

/**
 * @author jackpan
 * @version v1.0 2020/12/24 13:04
 */
public class CutStick {

    public static void main(String[] args) {
        System.out.println(curStick(5, 100));
    }

    /**
     *
     * @param m Number of people
     * @param n Need cut stick number
     * @return
     */
    private static int curStick(int m, int n) {
        return forLoop(m, n);
    }

    private static int dfs(int m, int n, int current) {

        if (current >= n) {
            return 0;
        } else if (current <= m) {
            return 1 + dfs(m, n, current * 2);
        } else {
            return 1 + dfs(m, n, current + m);
        }
    }

    private static int forLoop(int m, int n) {
        int count = 0;
        int current = 1;

        while (current < n) {
            current += Math.min(current, m);
            count++;
        }

        return count;
    }



}
