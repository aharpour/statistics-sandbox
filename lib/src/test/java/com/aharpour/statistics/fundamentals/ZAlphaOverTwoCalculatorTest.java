package com.aharpour.statistics.fundamentals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZAlphaOverTwoCalculatorTest {

    private ZAlphaOverTwoCalculator calculator = new ZAlphaOverTwoCalculator();

    @Test
    void calculateAlphaOverTwoOf10() {
        double zAlphaOverTwo = calculator.calculateZAlphaOverTwo(0.1);
        assertEquals(1.645, zAlphaOverTwo, 0.001);
    }

    @Test
    void calculateAlphaOverTwoOf5() {
        double zAlphaOverTwo = calculator.calculateZAlphaOverTwo(0.05);
        assertEquals(1.96, zAlphaOverTwo, 0.001);
    }

    @Test
    void calculateAlphaOverTwoOf2() {
        double zAlphaOverTwo = calculator.calculateZAlphaOverTwo(0.02);
        assertEquals(2.326, zAlphaOverTwo, 0.001);
    }

    @Test
    void calculateAlphaOverTwoOf1() {
        double zAlphaOverTwo = calculator.calculateZAlphaOverTwo(0.01);
        System.out.println(zAlphaOverTwo);
        assertEquals(2.576, zAlphaOverTwo, 0.001);
    }

    @Test
    void fromAlphaOverTwo10ToAlpha() {
        assertEquals(0.1, calculator.calculateAlpha(1.6448536269514724), 0.0001);
    }

    @Test
    void fromAlphaOverTwo5ToAlpha() {
        assertEquals(0.05, calculator.calculateAlpha(1.959963984540054), 0.0001);
    }

    @Test
    void fromAlphaOverTwo2ToAlpha() {
        assertEquals(0.02, calculator.calculateAlpha(2.326347874040841), 0.0001);
    }

    @Test
    void fromAlphaOverTwo1ToAlpha() {
        assertEquals(0.01, calculator.calculateAlpha(2.5758293035489004), 0.0001);
    }


}