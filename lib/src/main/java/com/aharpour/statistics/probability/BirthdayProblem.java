package com.aharpour.statistics.probability;


import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.MathContext.DECIMAL128;

public class BirthdayProblem {

    private final BigDecimal result;
    private static final MathContext MC = DECIMAL128;


    public BirthdayProblem(long numberOfCases, int numberOfDraws) {
        result = calculate(numberOfCases, numberOfDraws);
    }

    private BigDecimal calculate(long numberOfCases, int numberOfDraws) {
        BigDecimal possibilityOfUniqueDraw = BigDecimal.valueOf(1.0);
        for (int i = 0; i < numberOfDraws; i++) {
            BigDecimal divide = new BigDecimal(numberOfCases - i, MC).divide(new BigDecimal(numberOfCases, MC), MC);
            possibilityOfUniqueDraw = possibilityOfUniqueDraw.multiply(divide, MC);
        }
        return BigDecimal.valueOf(1.0).subtract(possibilityOfUniqueDraw);
    }

    public BigDecimal getResult() {
        return result;
    }
}
