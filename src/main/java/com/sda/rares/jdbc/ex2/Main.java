package com.sda.rares.jdbc.ex2;

import com.sda.rares.jdbc.utils.DatabaseConnectionsUtils;

import java.sql.*;

/**
 * 2. Display all employees (employeeId, firstName, lastName, dateOfBirth) HOMEWORK
 */
public class Main {
    public static void main(String[] args) {

        try {
            Connection connection = DatabaseConnectionsUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT employeeId, firstName, lastName, dateOfBirth  FROM employees ");

            while (resultSet.next()){
                Integer employeeId = resultSet.getInt("employeeId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");

                System.out.println(employeeId + " " + firstName + " " + lastName + " " + dateOfBirth);

            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
