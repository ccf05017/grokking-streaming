package com.streamwork.ch02.vo;

import com.streamwork.ch02.job.VehicleEvent;

import java.util.List;
import java.util.Random;

public class RandomVehicleEventCreator {
    private final List<String> carCollection = List.of("excavator", "truck", "truck-mixer", "car", "SUV");

    public VehicleEvent create() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(this.carCollection.size());
        return new VehicleEvent(carCollection.get(randomIndex));
    }
}
