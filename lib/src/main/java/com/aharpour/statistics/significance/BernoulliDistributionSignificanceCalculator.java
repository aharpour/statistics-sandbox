package com.aharpour.statistics.significance;

import com.aharpour.statistics.dto.Interval;

public interface BernoulliDistributionSignificanceCalculator {

    double calculateConfidenceLevel(int sampleSize, double sampleMean, double expectedMean);

    Interval calculateConfidenceInterval(int sampleSize, double sampleMean, double confidenceLevel);


}
