package com.streamwork.ch02.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleResult {
    private static final Map<String, Integer> countMap = new HashMap<String, Integer>();
    private static final Map<String, Integer> feeMap = new HashMap<>();

    public static Integer getOfCountMap(String vehicleTypeName) {
        return countMap.get(vehicleTypeName);
    }

    public static Integer getOfFeeMap(String vehicleTypeName) {
        return feeMap.get(vehicleTypeName);
    }
    public static Integer getOrDefaultOfCountMap(
            String vehicleTypeName, Integer default_value
    ) {
        return countMap.getOrDefault(vehicleTypeName, default_value);
    }

    public static Integer getOrDefaultOfFeeMap(
            String vehicleTypeName, Integer default_value
    ) {
        return feeMap.getOrDefault(vehicleTypeName, default_value);
    }

    public static void updateCountMap(String vehicleTypeName, Integer count) {
        countMap.put(vehicleTypeName, count);
    }

    public static void updateFeeMap(String vehicleTypeName, Integer fee) {
        feeMap.put(vehicleTypeName, fee);
    }

    public static List<String> getKeySets() {
        return new ArrayList<>(countMap.keySet());
    }
}
