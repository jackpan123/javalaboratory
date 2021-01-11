package com.jackpan.concurrent;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jackpan
 * @version v1.0 2021/1/11 23:00
 */
public class UEHLogger implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.SEVERE, "Thread terminated with exception: " + t.getName(), e);
    }
}
