package com.example.demo;

import lombok.Data;

import java.sql.Time;

@Data
public class JnuBusSchedule {
    private int id;
    private char course;
    private boolean go_ocean_science;

    Time departure_time;
}
