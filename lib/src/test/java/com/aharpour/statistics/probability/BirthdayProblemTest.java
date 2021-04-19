package com.aharpour.statistics.probability;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BirthdayProblemTest {

    @Test
    void classicCase() {
        BigDecimal result = new BirthdayProblem(365L, 23).getResult();
        assertEquals(0.507297, result.doubleValue(), 0.000001);
    }

}
