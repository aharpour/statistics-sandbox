package com.aharpour.statistics.probability;


public class BirthdayProblem {
    private final int numberOfCases;
    private final int numberOfDraws;
    private final double result;


    public BirthdayProblem(int numberOfCases, int numberOfDraws) {
        this.numberOfCases = numberOfCases;
        this.numberOfDraws = numberOfDraws;

        result = calculate(numberOfCases, numberOfDraws);
    }

    private double calculate(int numberOfCases, int numberOfDraws) {
        double possibilityOfUniqueDraw = 1.0;
        for (int i = 0; i < numberOfDraws; i++) {
            possibilityOfUniqueDraw *= ((double) numberOfCases - i) / numberOfCases;
        }
        return 1.0 - possibilityOfUniqueDraw;
    }

    public double getResult() {
        return result;
    }
}
