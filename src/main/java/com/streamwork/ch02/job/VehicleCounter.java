package com.streamwork.ch02.job;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.streamwork.ch02.api.Event;
import com.streamwork.ch02.api.Operator;
import com.streamwork.ch02.vo.VehicleFee;
import com.streamwork.ch02.vo.VehicleResult;

class VehicleCounter extends Operator {
  private static final int DEFAULT_COUNTER = 0;
  private static final int COUNTER_INCREMENT_VALUE = 1;
  private static final int INITIAL_FEE = 0;

  public VehicleCounter(String name) {  super(name);  }

  @Override
  public void apply(Event vehicleEvent, List<Event> eventCollector) {
    String vehicleTypeName = ((VehicleEvent)vehicleEvent).getData();

    processCounting(vehicleTypeName);
    processFee(vehicleTypeName);

    // 다음 Operator에 넘겨주려면 eventCollector에 새로 이벤트를 쏴줘야 함.
    // 이걸 알았다면 계산 후 새로운 이벤트를 만들고 이를 옮기는 방법이 가능했음 (지금은 그냥 static 클래스를 하나 만듦)
    // 바꿔야 하지만 귀찮으니까 일단 여기까지만 하고 패스!
    eventCollector.add(vehicleEvent);
  }

  private void processFee(String vehicleTypeName) {
    Integer fee = VehicleResult.getOrDefaultOfFeeMap(vehicleTypeName, INITIAL_FEE) + VehicleFee.getFee(vehicleTypeName);
    VehicleResult.updateFeeMap(vehicleTypeName, fee);
  }

  private void processCounting(String vehicleTypeName) {
    Integer count = VehicleResult.getOrDefaultOfCountMap(vehicleTypeName, DEFAULT_COUNTER) + COUNTER_INCREMENT_VALUE;
    VehicleResult.updateCountMap(vehicleTypeName, count);
  }
}
