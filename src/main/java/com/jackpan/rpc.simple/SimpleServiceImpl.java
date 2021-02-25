package com.jackpan.rpc.simple;

/**
 * @author jackpan
 * @version v1.0 2021/2/25 13:04
 */
public class SimpleServiceImpl implements SimpleService {
    @Override
    public String helloWorld(String name) {
        return "Hello world，I am" + name;
    }
}
