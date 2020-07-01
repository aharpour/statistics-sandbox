package com.aharpour.statistics.confidence;

import com.aharpour.statistics.dto.Interval;

public interface ConfidenceIntervalCalculator {

    double calculateConfidenceLevel(int sampleSize, double sampleMean, double comparingTo);

    Interval calculateConfidenceInterval(int sampleSize, double sampleMean, double confidenceLevel);


}
