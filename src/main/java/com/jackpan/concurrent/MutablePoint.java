package com.jackpan.concurrent;

/**
 * @author jackpan
 * @version v1.0 2020/12/16 22:27
 */
public class MutablePoint {

    public int x, y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint mutablePoint) {
        this.x = mutablePoint.x;
        this.y = mutablePoint.y;
    }
}
