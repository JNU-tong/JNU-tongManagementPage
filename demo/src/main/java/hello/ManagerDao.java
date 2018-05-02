package hello;

import java.sql.*;
import java.util.LinkedList;

public class ManagerDao {
    public LinkedList<Manager> get() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/jnutongmanagers", "root", "sslabflask");
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * from managers");
        LinkedList<Manager> managers = new LinkedList<>();

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            Manager manager = new Manager();
            manager.setNum(resultSet.getLong("num"));
            manager.setId(resultSet.getString("id"));
            manager.setRole(resultSet.getString("role"));
            manager.setPassword(resultSet.getString("password"));
            managers.add(manager);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return managers;
    }
}
