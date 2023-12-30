package com.streamwork.ch02.job;

import com.streamwork.ch02.api.Event;

public class VehicleEvent extends Event {
  private final String type;

  public VehicleEvent(String type) {
    this.type = type;
  }

  // 이 프레임워크에서의 라이프사이클 Hook
  @Override
  public String getData() {
    return type;
  }
}
