package com.aharpour.statistics.confidence;

import com.aharpour.statistics.dto.Interval;
import org.apache.commons.math3.distribution.ExponentialDistribution;
import org.junit.jupiter.api.Test;

import java.util.stream.DoubleStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExponentialDistributionConfidenceIntervalCalculatorCLTTest {

    private final ConfidenceIntervalCalculator calculator = new ExponentialDistributionConfidenceIntervalCalculatorCLT();


    @Test
    void calculateConfidenceInterval() {
        runAnExperiment(0.1, 0.8);
        runAnExperiment(17.0, 0.8);
        runAnExperiment(123.0, 0.9);
    }

    @Test
    void calculateConfidenceLevel() {
        double confidenceLevel = calculator.calculateConfidenceLevel(100, 0.06454865336838168, 13.506785935097474);
        assertEquals(0.8, confidenceLevel, 0.01);
    }

    private void runAnExperiment(double lambda, double confidenceLevel) {
        int numberOfTries = 250;
        int success = 0;
        for (int i = 0; i < numberOfTries; i++) {
            Interval interval = generateASampleAndCalculateConfidenceIntervalForIt(lambda, 100, confidenceLevel);
            if (interval.contains(lambda)) {
                success++;
            }
        }
        double successPercentage = ((double) success) / numberOfTries;
        assertEquals(confidenceLevel, successPercentage, 0.1);
    }

    private Interval generateASampleAndCalculateConfidenceIntervalForIt(double lambda, int sampleSize, double confidenceLevel) {
        ExponentialDistribution exponentialDistribution = new ExponentialDistribution(1.0 / lambda);
        double[] sample = exponentialDistribution.sample(sampleSize);
        double mean = DoubleStream.of(sample)
                .average().getAsDouble();
        return calculator.calculateConfidenceInterval(sample.length, mean, confidenceLevel);
    }


}
