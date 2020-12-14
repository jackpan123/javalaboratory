package com.jackpan.dynamicproxy;

/**
 * @author jackpan
 * @version v1.0 2020/12/14 12:48
 */
public interface SmsService {
    String send(String message);

    String sendByName(String message, String name);
}
