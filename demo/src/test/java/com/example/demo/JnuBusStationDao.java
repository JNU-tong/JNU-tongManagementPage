package com.example.demo;

import java.sql.*;

public class JnuBusStationDao {
    public JnuBusStation get(int id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/businfo?characterEncoding=utf-8", "root", "sslabflask");
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * from jnu_bus_station WHERE id = ?");
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        JnuBusStation jnuBusStation = new JnuBusStation();
        jnuBusStation.setId(resultSet.getInt("id"));
        jnuBusStation.setStationName(resultSet.getString("name"));

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return jnuBusStation;
    }
}
