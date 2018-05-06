package com.example.demo;

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
		int id = 1;
		JnuBusStation jnuBusStation = jnuBusStationDao.get(id);
		System.out.println(jnuBusStation.getId());
		System.out.println(jnuBusStation.getStationName());

	}

}
