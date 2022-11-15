package com.sda.rares.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionsUtils {
    public static final String DATABASE_HOST = "jdbc:mysql://localhost:3306/";
    //public static final String DATABASE_HOST = "jdbc:mysql://127.0.0.1:3306/";
    public static final String DATABASE_USERNAME = "root";
    public static final String DATABASE_PASSWORD = "root2022";

    public static final String HUMAN_RESOURCES_DATABASE = "hr";


    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(
                DATABASE_HOST.concat(HUMAN_RESOURCES_DATABASE),  // "jdbc:mysql://localhost:3306/humanResources"
                DATABASE_USERNAME,
                DATABASE_PASSWORD
        );
    }
}
