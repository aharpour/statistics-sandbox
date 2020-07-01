package com.aharpour.statistics.confidence;

import com.aharpour.statistics.dto.Interval;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BernoulliDistributionConfidenceIntervalCalculatorHoeffdingTest {

    private final ConfidenceIntervalCalculator calculator = new BernoulliDistributionConfidenceIntervalCalculatorHoeffding();

    @Test
    void calculateConfidenceLevel() {
        double confidenceLevel = calculator.calculateConfidenceLevel(124, 80.0 / 124, 0.5232001738637733);
        assertEquals(0.95, confidenceLevel, 0.0001);
    }

    @Test
    void calculateConfidenceInterval() {
        Interval interval = calculator.calculateConfidenceInterval(124, 80.0 / 124, 0.95);
        assertAll(
                () -> assertEquals(0.52, interval.getStart(), 0.01),
                () -> assertEquals(0.76, interval.getEnd(), 0.01)
        );
    }

}
