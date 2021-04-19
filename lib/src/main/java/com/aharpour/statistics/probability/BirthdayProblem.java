package com.aharpour.statistics.probability;


import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL128;

public class BirthdayProblem {

    private final BigDecimal result;


    public BirthdayProblem(long numberOfCases, int numberOfDraws) {
        result = calculate(numberOfCases, numberOfDraws);
    }

    private BigDecimal calculate(long numberOfCases, int numberOfDraws) {
        BigDecimal possibilityOfUniqueDraw = BigDecimal.valueOf(1.0);
        for (int i = 0; i < numberOfDraws; i++) {
            BigDecimal divide = new BigDecimal(numberOfCases - i, DECIMAL128).divide(new BigDecimal(numberOfCases, DECIMAL128), DECIMAL128);
            possibilityOfUniqueDraw = possibilityOfUniqueDraw.multiply(divide, DECIMAL128);
        }
        return BigDecimal.valueOf(1.0).subtract(possibilityOfUniqueDraw);
    }

    public BigDecimal getResult() {
        return result;
    }
}
