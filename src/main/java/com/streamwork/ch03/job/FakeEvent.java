package com.streamwork.ch03.job;

import com.streamwork.ch03.api.Event;

public class FakeEvent extends Event {
    private final Integer fakeValue;

    public FakeEvent(Integer fakeValue) {
        this.fakeValue = fakeValue;
    }

    @Override
    public Integer getData() {
        return fakeValue;
    }
}
