package com.streamwork.ch02.job;

import com.streamwork.ch02.api.Event;
import com.streamwork.ch02.api.Operator;
import com.streamwork.ch02.vo.VehicleResult;

import java.util.Collections;
import java.util.List;

public class VehicleResultPrinter extends Operator {
    public VehicleResultPrinter(String name) {
        super(name);
    }

    @Override
    public void apply(Event event, List<Event> eventCollector) {
        System.out.println("VehicleCounter --> ");
        printResult();
    }

    private void printResult() {
        // 프로덕션에서 이렇게 쓰긴 어려울듯 함.
        // VehicleType 컬렉션을 따로 만들고 이를 fee랑 counter가 같이 사용하도록 해야될듯.
        // 큰 문제는 없겠지만 Map 간 키가 다르게 들어가거나 한쪽에 없는 키가 생길 경우가 있을 수 있기 때문에 이를 대비해야 함
        List<String> vehicles = VehicleResult.getKeySets();
        Collections.sort(vehicles);

        for (String vehicle: vehicles) {
            System.out.println("  " + vehicle + ": " + VehicleResult.getOfCountMap(vehicle));
            System.out.println("  " + vehicle + " fee: " + VehicleResult.getOfFeeMap(vehicle));
            System.out.println("==========================================================");
        }
    }
}
