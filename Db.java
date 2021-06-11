package sample;
import java.sql.*;
import java.sql.Connection;

public class Db {
    public String url = "jdbc:mysql://localhost:3306/javatime";
    public String username = "root";
    public String password = "rfrfirf123ilya123semyonov123@mail";
    public Connection connection;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/javatime";
            String username = "root";
            String password = "rfrfirf123ilya123semyonov123@mail";
            connection = DriverManager.getConnection(url, username, password);


        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        return connection;

    }
}


