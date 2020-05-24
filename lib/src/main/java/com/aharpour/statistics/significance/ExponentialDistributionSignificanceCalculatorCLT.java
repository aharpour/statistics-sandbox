package com.aharpour.statistics.significance;

import com.aharpour.statistics.dto.Interval;
import com.aharpour.statistics.exceptions.ValidationException;
import com.aharpour.statistics.fundamentals.ZAlphaOverTwoCalculator;

/**
 * This calculator calculates confidence interval around one over sample's mean as an indicator for lambda of an exponential distribution.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Exponential_distribution">https://en.wikipedia.org/wiki/Exponential_distribution</a>
 */
public class ExponentialDistributionSignificanceCalculatorCLT implements SignificanceCalculator {

    private final ZAlphaOverTwoCalculator zAlphaOverTwoCalculator = new ZAlphaOverTwoCalculator();

    @Override
    public double calculateConfidenceLevel(int sampleSize, double sampleMean, double comparingTo) {
        validateSample(sampleSize, sampleMean);
        if (comparingTo <= 0) {
            throw new IllegalArgumentException("Expected mean is out of range. Expected values are [0,)");
        }
        double deviationFromMean = Math.abs(comparingTo - (1.0 / sampleMean));
        return 1 - zAlphaOverTwoCalculator.calculateAlpha(sampleMean * deviationFromMean * Math.sqrt(sampleSize));
    }

    @Override
    public Interval calculateConfidenceInterval(int sampleSize, double sampleMean, double confidenceLevel) {
        if (confidenceLevel < 0 || confidenceLevel > 1) {
            throw new IllegalArgumentException("Confidence Level is out of range. Expected values are [0, 1]");
        }
        validateSample(sampleSize, sampleMean);
        double z = zAlphaOverTwoCalculator.calculateZAlphaOverTwo(1 - confidenceLevel);
        double deviation = z / (sampleMean * Math.sqrt(sampleSize));
        return new Interval(Math.max((1.0 / sampleMean) - deviation, 0), (1.0 / sampleMean) + deviation);
    }

    private void validateSample(int sampleSize, double sampleMean) {
        if (sampleSize < 30) {
            throw new ValidationException("Sample of " + sampleSize + " is too small for applying Central Limit Theorem.");
        }
        if (sampleMean <= 0) {
            throw new IllegalArgumentException("Sample mean is out of range. Expected values are [0,)");
        }
    }
}
