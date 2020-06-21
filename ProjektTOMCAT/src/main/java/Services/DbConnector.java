package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/booksdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static final String DRIVER_NAME="com.mysql.jdbc.Driver";

    public static Connection connect(){
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
            connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
