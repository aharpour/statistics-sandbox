package com.aharpour.statistics.significance;

import com.aharpour.statistics.confidence.BernoulliDistributionConfidenceIntervalCalculatorCLT;
import com.aharpour.statistics.confidence.BernoulliDistributionConfidenceIntervalCalculatorHoeffding;
import com.aharpour.statistics.confidence.ConfidenceIntervalCalculator;
import com.aharpour.statistics.dto.Interval;

public class BernoulliDistributionSignificanceCalculator {

    private final ConfidenceIntervalCalculator clt = new BernoulliDistributionConfidenceIntervalCalculatorCLT();
    private final ConfidenceIntervalCalculator hoeffding = new BernoulliDistributionConfidenceIntervalCalculatorHoeffding();



    public double calculateConfidenceLevel(int sampleASize, double sampleAMean, int sampleBSize, double sampleBMean) {
        double stepSize = 0.25;
        double testConfidenceLevel = 0.5;
        double confidenceLevel = 0.0;
        for (int i = 0; i < 20; i++) {
            Interval intervalA = getConfidenceInterval(sampleASize, sampleAMean, testConfidenceLevel);
            Interval intervalB = getConfidenceInterval(sampleBSize, sampleBMean, testConfidenceLevel);

            if (intervalA.overlap(intervalB)) {
                testConfidenceLevel -= stepSize;
            } else {
                confidenceLevel = testConfidenceLevel;
                testConfidenceLevel += stepSize;
            }
            stepSize = stepSize / 2;
        }
        return confidenceLevel;
    }

    private Interval getConfidenceInterval(int sampleSize, double sampleMean, double confidenceLevel) {
        var calculator = getConfidenceIntervalCalculator(sampleSize);
        return calculator.calculateConfidenceInterval(sampleSize, sampleMean, confidenceLevel);
    }

    private ConfidenceIntervalCalculator getConfidenceIntervalCalculator(int sampleSize) {
        if (sampleSize > 30) {
            return clt;
        }
        return hoeffding;
    }
}
