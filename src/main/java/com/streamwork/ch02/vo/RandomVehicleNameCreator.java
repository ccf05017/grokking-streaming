package com.streamwork.ch02.vo;

import java.util.List;
import java.util.Random;

public class RandomVehicleNameCreator {
    private final List<String> carCollection = List.of("excavator", "truck", "truck-mixer", "car", "SUV");

    public String create() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(this.carCollection.size());
        return carCollection.get(randomIndex);
    }
}
