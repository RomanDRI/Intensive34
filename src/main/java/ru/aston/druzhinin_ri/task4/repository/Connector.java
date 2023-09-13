package ru.aston.druzhinin_ri.task4.repository;

import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {

    private Connector() {
    }

    public static Connection getConnector() throws SQLException {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

        String url = resourceBundle.getString("db.url");
        String user = resourceBundle.getString("db.user");
        String password = resourceBundle.getString("db.password");


        return DriverManager.getConnection(url, user, password);
    }
}