package ge.tbc.testautomation.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class MSSQLConnection {
      public static Connection connect() {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
            String dbUrl = DBConfiguration.getURL();
            String dbUsername = DBConfiguration.getUsername();
            String dbPassword = DBConfiguration.getPassword();
           Connection connection =  DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
