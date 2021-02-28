package com.jackpan.concurrent;

/**
 * @author jackpan
 * @version v1.0 2021/2/28 17:41
 */
public class DeadLockSample extends Thread {
    private String frs;
    private String second;
    public DeadLockSample(String name, String frs, String second) {
        super(name);
        this.frs = frs;
        this.second = second;
    }
    public void run() {
        synchronized (frs) {
            System.out.println(this.getName() + " obtained: " + frs);
            try {
                Thread.sleep(1000L);
                synchronized (second) {
                    System.out.println(this.getName() + " obtained: " + second);
                }
            } catch (InterruptedException e) {
                // Do nothing
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockSample t1 = new DeadLockSample("Thread1", lockA, lockB);
        DeadLockSample t2 = new DeadLockSample("Thread2", lockB, lockA);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
