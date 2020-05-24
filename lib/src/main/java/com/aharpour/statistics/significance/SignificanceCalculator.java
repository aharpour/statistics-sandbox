package com.aharpour.statistics.significance;

import com.aharpour.statistics.dto.Interval;

public interface SignificanceCalculator {

    double calculateConfidenceLevel(int sampleSize, double sampleMean, double comparingTo);

    Interval calculateConfidenceInterval(int sampleSize, double sampleMean, double confidenceLevel);


}
