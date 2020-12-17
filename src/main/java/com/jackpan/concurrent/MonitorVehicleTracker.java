package com.jackpan.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jackpan
 * @version v1.0 2020/12/16 22:26
 */
public class MonitorVehicleTracker {

    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(this.locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint mutablePoint = this.locations.get(id);
        return mutablePoint == null ? null : new MutablePoint(mutablePoint);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint mutablePoint = this.locations.get(id);
        if (mutablePoint == null) {
            throw new IllegalArgumentException("No such ID: " + id);
        }
    }

    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> result = new HashMap<>();
        for (String id : m.keySet()) {
            result.put(id, new MutablePoint(m.get(id)));
        }
        return Collections.unmodifiableMap(result);
    }

}
