package com.aharpour.statistics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Interval {
    private double start;
    private double end;

    public boolean contains(double value) {
        return start <= value && end >= value;
    }
}
