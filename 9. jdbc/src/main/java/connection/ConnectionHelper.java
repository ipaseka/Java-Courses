package connection;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    public static Connection getConnection(){

        try {
            DriverManager.registerDriver(new Driver());
            String url = "jdbc:mysql://" +
                        "localhost:" +
                        "3306/" +
                        "javatest?" +
                        "user=java_testUser&" +
                        "password=123456789&" +
                        "useSSL=false";
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
