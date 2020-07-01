package com.aharpour.statistics.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntervalTest {

    @Test
    void containsTest() {
        Interval interval = new Interval(-5.3, 12.2);
        assertAll(
                () -> assertTrue(interval.contains(-5.0)),
                () -> assertTrue(interval.contains(0)),
                () -> assertTrue(interval.contains(10.0)),
                () -> assertTrue(interval.contains(-5.2999)),
                () -> assertTrue(interval.contains(12.19999)),
                () -> assertFalse(interval.contains(12.20001)),
                () -> assertFalse(interval.contains(-5.3001))
        );
    }

    @Test
    void partialOverlapTest() {
        Interval a = new Interval(0.0, 10.0);
        Interval b = new Interval(5.0, 15.0);


        assertAll(
                () -> assertTrue(a.overlap(b)),
                () -> assertTrue(b.overlap(a))
        );
    }

    @Test
    void totalOverlapTest() {
        Interval a = new Interval(-5.0, 10.0);
        Interval b = new Interval(-2.0, -1.0);


        assertAll(
                () -> assertTrue(a.overlap(b)),
                () -> assertTrue(b.overlap(a))
        );
    }

    @Test
    void touchOverlapTest() {
        Interval a = new Interval(-5.0, 0.0);
        Interval b = new Interval(0.0, 1.0);


        assertAll(
                () -> assertTrue(a.overlap(b)),
                () -> assertTrue(b.overlap(a))
        );
    }

    @Test
    void noOverlapTest() {
        Interval a = new Interval(-5.0, 2.0);
        Interval b = new Interval(2.5, 15.0);


        assertAll(
                () -> assertFalse(a.overlap(b)),
                () -> assertFalse(b.overlap(a))
        );
    }


}
