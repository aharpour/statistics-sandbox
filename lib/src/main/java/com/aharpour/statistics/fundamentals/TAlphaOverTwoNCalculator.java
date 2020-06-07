package com.aharpour.statistics.fundamentals;

import org.apache.commons.math3.distribution.TDistribution;

public class TAlphaOverTwoNCalculator {

    public double calculateTAlphaOverTwoN(double alpha, int n) {
        TDistribution distribution = new TDistribution(n);
        if (alpha < 0 || alpha > 1.0) {
            throw new IllegalArgumentException("Alpha is out of range. Expected range [0, 1.0]");
        }
        return distribution.inverseCumulativeProbability(1 - (alpha / 2));
    }

    public double calculateAlpha(double tAlphaOverTwoN, int n) {
        TDistribution distribution = new TDistribution(n);
        double p = distribution.cumulativeProbability(tAlphaOverTwoN);
        return 2 * (1 - p);
    }
}
