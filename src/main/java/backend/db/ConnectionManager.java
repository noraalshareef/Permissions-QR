package backend.db;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import javax.naming.NamingException;
import java.sql.*;

public class ConnectionManager {




        public static Connection getFullStopConnection() throws SQLException, NamingException {


            DriverManager.registerDriver(new SQLServerDriver());
            return DriverManager.getConnection("jdbc:sqlserver://fullstop-server.database.windows.net:1433;databaseName=fullstop", "fullstop@fullstop-server", "NAYNora!");


        }


    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null)
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (statement != null)
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static void close(Statement statement, Connection connection) {
        if (statement != null)
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    public static void close(ResultSet resultSet, Statement statement) {
        if (resultSet != null)
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (statement != null)
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    public static void close(Connection connection) {
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static void close(Statement stmt) {
        if (stmt != null)
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
