package com.aharpour.statistics.fundamentals;

import org.apache.commons.math3.distribution.NormalDistribution;

public class ZAlphaOverTwoCalculator {

    private final NormalDistribution normalDistribution = new NormalDistribution(0, 1);

    public double calculateZAlphaOverTwo(double alpha) {
        if (alpha < 0 || alpha > 1.0) {
            throw new IllegalArgumentException("Alpha is out of range. Expected range [0, 1.0]");
        }
        return normalDistribution.inverseCumulativeProbability(1 - (alpha / 2));
    }

    public double calculateAlpha(double zAlphaOverTwo) {
        double p = normalDistribution.cumulativeProbability(zAlphaOverTwo);
        return 2 * (1 - p);
    }
}
