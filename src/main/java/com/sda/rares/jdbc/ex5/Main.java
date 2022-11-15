package com.sda.rares.jdbc.ex5;

import com.sda.rares.jdbc.utils.DatabaseConnectionsUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 5. Display all employees along with the department they’re in (employeeId, firstName, lastName, dateOfBirth, departmentName) HOMEWORK
 */
public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnectionsUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT employeeId, firstName, lastName, dateOfBirth, d.name AS departmentName FROM employees JOIN departments AS d ON employees.departmentID = d.departmentID");

            while (resultSet.next()){
                Integer employeeId = resultSet.getInt("employeeId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                Integer departmentId = resultSet.getInt("departmentId");

                System.out.println(employeeId + " " + firstName + " " + lastName + " " + departmentId);
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
