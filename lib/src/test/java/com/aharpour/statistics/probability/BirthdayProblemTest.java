package com.aharpour.statistics.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirthdayProblemTest {

    @Test
    void classicCase() {
        double result = new BirthdayProblem(365, 23).getResult();
        assertEquals(0.507297, result, 0.000001);
    }

}
