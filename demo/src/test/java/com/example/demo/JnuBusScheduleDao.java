package com.example.demo;

import hello.JnuTongConnectionMaker;

import java.sql.*;

public class JnuBusScheduleDao {
    public JnuBusSchedule get(int id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/businfo?characterEncoding=utf-8", "root", "sslabflask");
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from jnu_bus_schedule where id = ? ;");
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        JnuBusSchedule jnuBusSchedule = new JnuBusSchedule();
        jnuBusSchedule.setId(resultSet.getInt("id"));
        jnuBusSchedule.setDeparture_time(resultSet.getTime("departure_time"));
    }
}
