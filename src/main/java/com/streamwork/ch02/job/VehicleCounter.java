package com.streamwork.ch02.job;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.streamwork.ch02.api.Event;
import com.streamwork.ch02.api.Operator;
import com.streamwork.ch02.vo.VehicleFee;

class VehicleCounter extends Operator {
  private static final int DEFAULT_COUNTER = 0;
  private static final int COUNTER_INCREMENT_VALUE = 1;
  private static final int INITIAL_FEE = 0;

  private final Map<String, Integer> countMap = new HashMap<String, Integer>();
  private final Map<String, Integer> feeMap = new HashMap<>();

  public VehicleCounter(String name) {  super(name);  }

  @Override
  public void apply(Event vehicleEvent, List<Event> eventCollector) {
    String vehicleTypeName = ((VehicleEvent)vehicleEvent).getData();

    processCounting(countMap, vehicleTypeName);
    processFee(vehicleTypeName);

    System.out.println("VehicleCounter --> ");
    printResult();
  }

  private void processFee(String vehicleTypeName) {
    Integer fee = feeMap.getOrDefault(vehicleTypeName, INITIAL_FEE) + VehicleFee.getFee(vehicleTypeName);
    feeMap.put(vehicleTypeName, fee);
  }

  private void processCounting(Map<String, Integer> countMap, String vehicleTypeName) {
    Integer count = countMap.getOrDefault(vehicleTypeName, DEFAULT_COUNTER) + COUNTER_INCREMENT_VALUE;
    countMap.put(vehicleTypeName, count);
  }

  private void printResult() {
    // 프로덕션에서 이렇게 쓰긴 어려울듯 함.
    // VehicleType 컬렉션을 따로 만들고 이를 fee랑 counter가 같이 사용하도록 해야될듯.
    // 큰 문제는 없겠지만 Map 간 키가 다르게 들어가거나 한쪽에 없는 키가 생길 경우가 있을 수 있기 때문에 이를 대비해야 함
    List<String> vehicles = new ArrayList<>(countMap.keySet());
    Collections.sort(vehicles);

    for (String vehicle: vehicles) {
      System.out.println("  " + vehicle + ": " + countMap.get(vehicle));
      System.out.println("  " + vehicle + " fee: " + feeMap.get(vehicle));
      System.out.println("==========================================================");
    }
  }
}
