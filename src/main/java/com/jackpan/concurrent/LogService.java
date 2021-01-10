package com.jackpan.concurrent;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author jackpan
 * @version v1.0 2021/1/10 20:22
 */
public class LogService {

    private final BlockingQueue<String> queue;

    private final LoggerThread logger;

    private boolean isShutdown;

    private int reservations;

    public LogService(PrintWriter writer) {
        this.queue = new LinkedBlockingQueue<>(12);
        this.logger = new LoggerThread(writer);
    }

    public void start() {
        logger.start();
    }

    public void stop() {
        synchronized (this) {
            isShutdown = true;
        }
        logger.interrupt();
    }

    public void log(String msg) throws InterruptedException {
        synchronized (this) {
            if (isShutdown) {
                throw new IllegalStateException();
            }
            ++reservations;
        }
        queue.put(msg);
    }

    private class LoggerThread extends Thread {
        private final PrintWriter writer;

        public LoggerThread(PrintWriter writer) {
            this.writer = writer;
        }

        public void run() {
            try {
                while(true) {
                    try {
                        synchronized (LogService.this) {
                            if (isShutdown && reservations == 0) {
                                break;
                            }
                        }

                        String msg = queue.take();
                        synchronized (LogService.this) {
                            --reservations;
                        }
                        writer.println(msg);
                    } catch (InterruptedException e) {
                        // retry
                    }

                }
            } finally {
                writer.close();
            }
        }
    }
}
