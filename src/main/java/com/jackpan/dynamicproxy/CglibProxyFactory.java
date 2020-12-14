package com.jackpan.dynamicproxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author jackpan
 * @version v1.0 2020/12/14 13:02
 */
public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }

    public static void main(String[] args) {
        SmsService aliSmsService = (SmsService) CglibProxyFactory.getProxy(SmsServiceImpl.class);
        aliSmsService.send("java");
        aliSmsService.sendByName("java", "Jack");
    }
}
