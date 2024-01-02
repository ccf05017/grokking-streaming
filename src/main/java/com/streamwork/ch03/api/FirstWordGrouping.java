package com.streamwork.ch03.api;

import com.streamwork.ch03.job.VehicleEvent;

import java.io.Serializable;

public class FirstWordGrouping implements GroupingStrategy, Serializable {
    private static final long serialVersionUID = -1121182295793347622L;

    public FirstWordGrouping() {
    }

    @Override
    public int getInstance(Event event, int parallelism) {
        System.out.println("분배로직이 돌고는 있음");
        return Math.abs(getKey(event).hashCode()) % parallelism;
    }

    private String getKey(Event event) {
        VehicleEvent vehicleEvent = (VehicleEvent) event;
        return vehicleEvent.getData().substring(0, 1);
    }
}
