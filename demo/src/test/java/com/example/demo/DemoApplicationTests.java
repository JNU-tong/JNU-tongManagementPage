package com.example.demo;

import hello.JnuBusSchedule;
import hello.JnuBusScheduleDao;
import hello.JnuBusStation;
import hello.JnuBusStationDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@RunWith(SpringRunner.class)

@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {

	}

	@Test
	public void get() throws SQLException, ClassNotFoundException {

		// bus station information
		JnuBusStationDao jnuBusStationDao = new JnuBusStationDao();
		int bus_station_id = 1;
		JnuBusStation jnuBusStation = jnuBusStationDao.get(bus_station_id);
		System.out.println(jnuBusStation.getId());
		System.out.println(jnuBusStation.getStationName());

		JnuBusScheduleDao jnuBusScheduleDao = new JnuBusScheduleDao();
		int jnu_bus_schedule_id = 1;
		JnuBusSchedule jnuBusSchedule = jnuBusScheduleDao.get(jnu_bus_schedule_id);
		System.out.println(jnuBusSchedule.getId());
		System.out.println(jnuBusSchedule.getDeparture_time());
		System.out.println(jnuBusSchedule.getCourse());
		System.out.println(jnuBusSchedule.getGo_ocean_science());
	}

}
