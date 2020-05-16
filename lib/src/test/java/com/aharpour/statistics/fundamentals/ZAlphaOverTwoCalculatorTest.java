package com.aharpour.statistics.fundamentals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZAlphaOverTwoCalculatorTest {

    private ZAlphaOverTwoCalculator calculator = new ZAlphaOverTwoCalculator();

    @Test
    void AlphaOverTwo10() {
        double zAlphaOverTwo = calculator.getZAlphaOverTwo(0.1);
        assertEquals(1.645, zAlphaOverTwo, 0.001);
    }

    @Test
    void AlphaOverTwo5() {
        double zAlphaOverTwo = calculator.getZAlphaOverTwo(0.05);
        assertEquals(1.96, zAlphaOverTwo, 0.001);
    }

    @Test
    void AlphaOverTwo2() {
        double zAlphaOverTwo = calculator.getZAlphaOverTwo(0.02);
        assertEquals(2.326, zAlphaOverTwo, 0.001);
    }

    @Test
    void AlphaOverTwo1() {
        double zAlphaOverTwo = calculator.getZAlphaOverTwo(0.01);
        assertEquals(2.576, zAlphaOverTwo, 0.001);
    }
}