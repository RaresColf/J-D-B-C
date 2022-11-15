package com.sda.rares.jdbc.ex4;
/**
 * 4. Display all employees that haven’t been assigned to a department HOMEWORK
 */

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
            ResultSet resultSet = statement.executeQuery("SELECT employeeId,firstName, lastName FROM employees WHERE departmentId IS NULL");

            while (resultSet.next()){
                Integer employeeId = resultSet.getInt("employeeId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");

                System.out.println(employeeId + " " + firstName + " " + lastName);
            }
            resultSet.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
