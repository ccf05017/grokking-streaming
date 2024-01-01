package com.streamwork.ch02.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VehicleFeeTest {
    @DisplayName("차량타입에 알맞는 요금을 알 수 있다.")
    @Test
    void getFeeTest() {
        String vehicleType = "car";
        Integer expectedFee = 3;

        Integer resultFee = VehicleFee.getFee(vehicleType);

        assertThat(resultFee).isEqualTo(expectedFee);
    }
}