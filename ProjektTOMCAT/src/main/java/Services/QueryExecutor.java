package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExecutor {
    public static ResultSet executeSelect(String selectQuery){
        try{
            Connection connection = DbConnector.connect();
            Statement statement = connection.createStatement();
            return statement.executeQuery(selectQuery);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables.getMessage());
        }
    }
    public static void executeQuery(String query){
        try{
            Connection connection = DbConnector.connect();
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables.getMessage());
        }
    }
}

