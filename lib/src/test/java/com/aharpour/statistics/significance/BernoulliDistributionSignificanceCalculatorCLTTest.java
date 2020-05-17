package com.aharpour.statistics.significance;

import com.aharpour.statistics.dto.Interval;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BernoulliDistributionSignificanceCalculatorCLTTest {

    private BernoulliDistributionSignificanceCalculator calculator = new BernoulliDistributionSignificanceCalculatorCLT();

    @Test
    void calculateConfidenceLevel() {
        double confidenceLevel = calculator.calculateConfidenceLevel(124, 72.0 / 124, 0.5);
        assertTrue(confidenceLevel > 0.9);

        confidenceLevel = calculator.calculateConfidenceLevel(124, 75.0 / 124, 0.5);
        assertTrue(confidenceLevel > 0.98);

        confidenceLevel = calculator.calculateConfidenceLevel(124, 80.0 / 124, 0.5);
        assertTrue(confidenceLevel > 0.99);
    }

    @Test
    void calculateConfidenceInterval() {
        Interval interval = calculator.calculateConfidenceInterval(124, 80.0 / 124, 0.95);
        assertEquals(0.56, interval.getStart(), 0.01);
        assertEquals(0.73 , interval.getEnd(), 0.01);
    }
}