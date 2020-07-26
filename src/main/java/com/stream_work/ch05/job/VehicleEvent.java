package com.stream_work.ch05.job;

import com.stream_work.ch05.api.Event;

public class VehicleEvent extends Event {
  private final String type;

  public VehicleEvent(String type) {
    this.type = type;
  }

  @Override
  public String getData() {
    return type;
  }
}
