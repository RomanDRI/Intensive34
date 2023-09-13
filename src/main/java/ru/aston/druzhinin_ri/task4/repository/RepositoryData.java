package ru.aston.druzhinin_ri.task4.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RepositoryData {
    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";


    public Boolean scriptRun() {
        try (Connection connection = Connector.getConnector();
             Statement statement = connection.createStatement()){
            statement.execute("RUNSCRIPT FROM 'sql/schema.sql'");
            statement.execute("RUNSCRIPT FROM 'sql/data.sql'");
            Class.forName ("org.h2.Driver");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

}
