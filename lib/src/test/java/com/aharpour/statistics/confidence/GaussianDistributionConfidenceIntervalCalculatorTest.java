package com.aharpour.statistics.confidence;

import com.aharpour.statistics.dto.Interval;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GaussianDistributionConfidenceIntervalCalculatorTest {

    private final GaussianDistributionConfidenceIntervalCalculator calculator = new GaussianDistributionConfidenceIntervalCalculator();

    @Test
    void calculateConfidenceInterval() {
        Interval interval = calculator.calculateConfidenceInterval(10, 9.259, 1.9903, 0.95);
        assertAll(
                () -> assertEquals(7.84, interval.getStart(), 0.01),
                () -> assertEquals(10.68, interval.getEnd(), 0.01)
        );
    }
}
