package hello;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JnuTongConnectionMaker implements ConnectionMaker {
    @Value("${db.classname}")
    String classname= "com.mysql.jdbc.Driver";
    @Value("${db.url}")
    String url = "jdbc:mysql://localhost/jnutongmanagers";
    @Value("${db. username}")
    String username = "root";
    @Value("${db.password}")
    String password = "sslabflask";

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(classname);
        return DriverManager.getConnection(
                url, username, password);
    }
}
