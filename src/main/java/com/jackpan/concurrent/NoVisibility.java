package com.jackpan.concurrent;

/**
 * No Visibility class.
 * @author jackpan
 * @version v1.0 2020/12/13 16:09
 */
public class NoVisibility {

    private static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
