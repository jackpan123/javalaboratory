package com.jackpan.rpc.simple;

/**
 * @author jackpan
 * @version v1.0 2021/2/25 13:16
 */
public class SimpleInvoke {

    public static void main(String[] args) throws Exception {
        //服务调用者只需要设置依赖
        SimpleService service1 = SimpleRpcFramework.refer(SimpleService.class, "127.0.0.1", 2333);
        System.out.println(service1.helloWorld("JackPan"));
    }
}
