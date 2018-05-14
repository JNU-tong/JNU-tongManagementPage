package hello;

import lombok.Data;

import java.sql.Time;

@Data
public class JnuBusSchedule {
    private int id;
    private String course;
    private int go_ocean_science;

    Time departure_time;
}
