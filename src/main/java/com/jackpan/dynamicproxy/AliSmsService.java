package com.jackpan.dynamicproxy;

/**
 * @author jackpan
 * @version v1.0 2020/12/14 13:00
 */
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
