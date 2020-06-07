package com.aharpour.statistics.fundamentals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TAlphaOverTwoNCalculatorTest {
    private TAlphaOverTwoNCalculator calculator = new TAlphaOverTwoNCalculator();

    @Test
    void calculateTAlphaOverTwoN() {
        double tAlphaOverTwoN = calculator.calculateTAlphaOverTwoN(0.05, 9);
        assertEquals(2.262, tAlphaOverTwoN, 0.001);
    }

    @Test
    void calculateAlpha() {
        double alpha = calculator.calculateAlpha(2.262, 9);
        assertEquals(0.05, alpha, 0.001);
    }
}
