package com.jackpan.concurrent;

import java.math.BigInteger;

/**
 * @author jackpan
 * @version v1.0 2021/1/4 22:24
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {

    public BigInteger compute(String arg) {
        return new BigInteger(arg);
    }
}
