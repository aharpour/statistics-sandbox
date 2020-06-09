package com.aharpour.statistics.significance;

import com.aharpour.statistics.dto.Interval;

import static java.lang.Math.*;

public class BernoulliDistributionSignificanceCalculatorHoeffding implements SignificanceCalculator {

    @Override
    public double calculateConfidenceLevel(int sampleSize, double sampleMean, double comparingTo) {
        validateSampleMean(sampleMean);
        if (comparingTo <= 0 || comparingTo >= 1) {
            throw new IllegalArgumentException("Expected mean is out of range. Expected values are [0, 1]");
        }
        double d = Math.abs(comparingTo - sampleMean);
        double alpha = 2.0 / exp(2.0 * sampleSize * pow(d, 2));
        return 1 - alpha;
    }

    @Override
    public Interval calculateConfidenceInterval(int sampleSize, double sampleMean, double confidenceLevel) {
        if (confidenceLevel < 0 || confidenceLevel > 1) {
            throw new IllegalArgumentException("Confidence Level is out of range. Expected values are [0, 1]");
        }
        validateSampleMean(sampleMean);
        double alpha = 1 - confidenceLevel;
        double deviation = sqrt(log(2.0 / alpha) / (2.0 * sampleSize));
        return new Interval(max(sampleMean - deviation, 0), min(sampleMean + deviation, 1));
    }

    private void validateSampleMean(double sampleMean) {

        if (sampleMean <= 0 || sampleMean >= 1) {
            throw new IllegalArgumentException("Sample mean is out of range. Expected values are [0, 1]");
        }
    }
}
