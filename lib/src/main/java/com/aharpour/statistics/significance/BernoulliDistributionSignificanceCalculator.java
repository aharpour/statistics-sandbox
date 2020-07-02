package com.aharpour.statistics.significance;

import com.aharpour.statistics.confidence.BernoulliDistributionConfidenceIntervalCalculatorCLT;
import com.aharpour.statistics.confidence.BernoulliDistributionConfidenceIntervalCalculatorHoeffding;
import com.aharpour.statistics.confidence.ConfidenceIntervalCalculator;
import com.aharpour.statistics.dto.Interval;

import static java.lang.Math.*;

public class BernoulliDistributionSignificanceCalculator {

    public static final int NUMBER_OF_ROUNDS = 23;
    private final ConfidenceIntervalCalculator clt = new BernoulliDistributionConfidenceIntervalCalculatorCLT();
    private final ConfidenceIntervalCalculator hoeffding = new BernoulliDistributionConfidenceIntervalCalculatorHoeffding();



    public double calculateConfidenceLevel(int sampleASize, double sampleAMean, int sampleBSize, double sampleBMean) {
        double stepSize = 0.25;
        double testConfidenceLevel = 0.5;
        double confidenceLevel = 0.0;
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
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
        int numberOfSignificantDigits = (int) round(floor(-log10(1.0 / pow(2, NUMBER_OF_ROUNDS + 1))));

        return roundToNDigits(confidenceLevel, numberOfSignificantDigits) ;
    }

    private double roundToNDigits(double value, int numberOfSignificantDigits) {
        double factor = pow(10, numberOfSignificantDigits);
        return ((double) round(value * factor)) / factor;
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
