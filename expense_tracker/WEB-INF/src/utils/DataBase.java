package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static final String JDBC_URL = "jdbc:mysql://crossover.proxy.rlwy.net:32349/railway";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "iZAHINFmqJDAGwPJyYsQzTVpDjgbLlcn";

    // Private constructor to prevent instantiation
    private DataBase() {}

    // Use a static block to load the driver only once
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("MySQL JDBC Driver not found");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
    }
}