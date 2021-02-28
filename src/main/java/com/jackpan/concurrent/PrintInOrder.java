package com.jackpan.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author jackpan
 * @version v1.0 2021/2/28 18:12
 */
public class PrintInOrder {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphoreOne = new Semaphore(1);
        Semaphore semaphoreTwo = new Semaphore(0);
        Semaphore semaphoreThree = new Semaphore(0);
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<100; ++i) {
                    try {
                        semaphoreOne.acquire();
                        System.out.println("A");
                        semaphoreTwo.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<100; ++i) {
                    try {
                        semaphoreTwo.acquire();
                        System.out.println("B");
                        semaphoreThree.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<100; ++i) {
                    try {
                        semaphoreThree.acquire();
                        System.out.println("C");
                        semaphoreOne.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
        threadA.join();
        threadB.join();
        threadC.join();
    }
}
