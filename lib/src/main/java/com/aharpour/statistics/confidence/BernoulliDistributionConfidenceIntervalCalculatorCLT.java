package com.aharpour.statistics.confidence;

import com.aharpour.statistics.dto.Interval;
import com.aharpour.statistics.exceptions.ValidationException;
import com.aharpour.statistics.fundamentals.ZAlphaOverTwoCalculator;

public class BernoulliDistributionConfidenceIntervalCalculatorCLT implements ConfidenceIntervalCalculator {

    private final ZAlphaOverTwoCalculator zAlphaOverTwoCalculator = new ZAlphaOverTwoCalculator();

    @Override
    public double calculateConfidenceLevel(int sampleSize, double sampleMean, double comparingTo) {
        validateSample(sampleSize, sampleMean);
        if (comparingTo <= 0 || comparingTo >= 1) {
            throw new IllegalArgumentException("Expected mean is out of range. Expected values are [0, 1]");
        }
        double deviationFromMean = Math.abs(comparingTo - sampleMean);
        return 1 - zAlphaOverTwoCalculator.calculateAlpha(2 * deviationFromMean * Math.sqrt(sampleSize));
    }

    @Override
    public Interval calculateConfidenceInterval(int sampleSize, double sampleMean, double confidenceLevel) {
        if (confidenceLevel < 0 || confidenceLevel > 1) {
            throw new IllegalArgumentException("Confidence Level is out of range. Expected values are [0, 1]");
        }
        validateSample(sampleSize, sampleMean);
        double z = zAlphaOverTwoCalculator.calculateZAlphaOverTwo(1 - confidenceLevel);
        double deviation = z / (2 * Math.sqrt(sampleSize));
        return new Interval(Math.max(sampleMean - deviation, 0), Math.min(sampleMean + deviation, 1));
    }

    private void validateSample(int sampleSize, double sampleMean) {
        if (sampleSize < 30) {
            throw new ValidationException("Sample of " + sampleSize + " is too small for applying Central Limit Theorem.");
        }
        if (sampleMean <= 0 || sampleMean >= 1) {
            throw new IllegalArgumentException("Sample mean is out of range. Expected values are [0, 1]");
        }
    }
}
