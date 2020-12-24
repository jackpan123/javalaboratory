package com.jackpan.concurrent;

import com.jackpan.basic.EnhancementRequest;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jackpan
 * @version v1.0 2020/12/17 23:23
 */
public class DelegatingVehicleTracker {

    private final ConcurrentHashMap<String, Point> locations;

    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        locations = new ConcurrentHashMap<>(points);
        unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }


    /**
     * Gets locations.
     *
     * @return Value of locations.
     */
    public Map<String, Point> getLocations() {
        return this.unmodifiableMap;
    }

    /**
     * Gets unmodifiableMap.
     *
     * @return Value of unmodifiableMap.
     */
    public Point getLocation(String id) {
        return this.locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (this.locations.replace(id, new Point(x, y)) == null) {
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        }
    }
}
