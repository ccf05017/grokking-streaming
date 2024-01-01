package com.streamwork.ch02.vo;

import java.util.Arrays;

public enum VehicleFee {
    EXCAVATOR("excavator", 10),
    TRUCK("truck", 5),
    TRUCKMIXER("truck-mixer", 8),
    CAR("car", 3),
    SUV("suv", 4);

    private final String vehicleTypeName;
    private final Integer feeValue;

    VehicleFee(String vehicleTypeName, Integer feeValue) {
        this.vehicleTypeName = vehicleTypeName;
        this.feeValue = feeValue;
    }

    public static Integer getFee(String vehicleType) {
        return Arrays.stream(VehicleFee.values()).filter(vehicleFee -> vehicleFee.vehicleTypeName.equals(vehicleType))
                .findFirst()
                .map(vehicleFee -> vehicleFee.feeValue)
                .orElse(0);
    }
}
