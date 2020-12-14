package com.jackpan.dynamicproxy;

/**
 * @author jackpan
 * @version v1.0 2020/12/14 12:48
 */
public class SmsServiceImpl implements SmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }

    @Override
    public String sendByName(String message, String name) {
        System.out.println("send message:" + message + " name:" + name);
        return message + name;
    }
}
