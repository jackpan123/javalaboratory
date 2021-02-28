package com.jackpan.concurrent;

/**
 * @author jackpan
 * @version v1.0 2021/2/25 15:14
 */
public class MemoryVisibilityTest {

    public static void main(String[] args) {
        SimpleThread a = new SimpleThread();
        a.start();
        for ( ; ; ) {
            synchronized (a) {

            }
            if (a.isFlag()) {
                System.out.println("有点东西");
            }
        }
    }


}

class SimpleThread extends Thread {
    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = true;
        System.out.println("flag=" + flag);
    }
}
