package com.sda.rares.jdbc.ex1;

import com.sda.rares.jdbc.utils.DatabaseConnectionsUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnectionsUtils.getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM projects");
            //projectId, description

            while (resultSet.next()) {
                Integer projectId = resultSet.getInt("projectId");
                String description = resultSet.getString("description");

                System.out.println(projectId + " " + description);

            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}