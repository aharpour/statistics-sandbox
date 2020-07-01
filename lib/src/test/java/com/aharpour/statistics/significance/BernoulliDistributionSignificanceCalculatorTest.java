package com.aharpour.statistics.significance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BernoulliDistributionSignificanceCalculatorTest {

    private BernoulliDistributionSignificanceCalculator calculator = new BernoulliDistributionSignificanceCalculator();

    @Test
    void test() {

        double confidenceLevel = calculator.calculateConfidenceLevel(7, 6.0 / 7, 9, 2.0 / 9);

        assertEquals(0.59, confidenceLevel, 0.01);

    }

}
