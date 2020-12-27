package com.jackpan.concurrent;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * @author jackpan
 * @version v1.0 2020/12/27 22:19
 */
public class Indexer implements Runnable {

    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                indexFile(queue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private void indexFile(File file) {
        if (file.getName().contains("LDC")) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
