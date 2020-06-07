package com.aharpour.statistics.significance;

import com.aharpour.statistics.dto.Interval;
import com.aharpour.statistics.fundamentals.TAlphaOverTwoNCalculator;

import static java.lang.Math.sqrt;

public class GaussianDistributionSignificanceCalculator {

    private final TAlphaOverTwoNCalculator tFunction = new TAlphaOverTwoNCalculator();

    public Interval calculateConfidenceInterval(int sampleSize, double sampleMean, double sampleStandardDeviation, double confidenceLevel) {
        validateConfidenceLevel(confidenceLevel);
        validateSampleSize(sampleSize);

        double tAlpha = tFunction.calculateTAlphaOverTwoN(1 - confidenceLevel, sampleSize - 1);
        double deviation = tAlpha * sampleStandardDeviation / sqrt(sampleSize);
        return new Interval(sampleMean - deviation, sampleMean + deviation);
    }

    private void validateSampleSize(int sampleSize) {
        if (sampleSize <= 1) {
            throw new IllegalArgumentException("Sample size must be bigger than 1. Given Sample size: " + sampleSize);
        }
    }

    private void validateConfidenceLevel(double mean) {
        if (mean <= 0 || mean >= 1) {
            throw new IllegalArgumentException("ConfidenceLevel is out of range. Expected values are [0, 1]");
        }
    }

}
