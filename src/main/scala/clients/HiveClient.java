package clients;


import repos.Repo;
import models.User;


import java.io.IOException;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;


// TODO: make into Singleton object
public class HiveClient {

    private Connection connection = null;
    private String driver_name = "org.apache.hive.jdbc.HiveDriver";
    private String con_uri = "jdbc:hive2://localhost:10000/gaming";

    private static HiveClient instance = null;

    public static void Connect() {

        try {
            Class.forName(driver_name);
            connection = DriverManager.getConnection(con_uri, "", "");
        } catch (ClassNotFoundException e) {
              e.printStackTrace();
              throw new ClassNotFoundException(s"${e.getMessage}");
        } catch (SQLException e) {
              e.printStackTrace();
              throw new SQLException(s"${e.getMessage}");
        }
    }

    public static void Close() {

        try { if (connection != null) { connection.close(); } }

        catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(s"${e.getMessage}");
        }
    }

    // Helper method to handle exceptions
    public static ResultSet Query_DB(repos.Repo.Friend f) {

        ResultSet result = null;

        try {
            Statement query = connection.createStatement();
            result = query.executeQuery(f.Get_Query());
        }

        catch (SQLException e){
            Close();
            e.printStackTrace();
            throw new SQLException(s"${e.getMessage}");
        }
        
        return result
    }
}
