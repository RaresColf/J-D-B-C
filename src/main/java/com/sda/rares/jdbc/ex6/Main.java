package com.sda.rares.jdbc.ex6;

//3. Display all employees with names starting with the letter J (employeeId, firstName, lastName, dateOfBirth)

import com.sda.rares.jdbc.utils.DatabaseConnectionsUtils;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert prefix");
        String prefix = scanner.nextLine();

        findEmployeesStartingWith(prefix);

    }

    public static void findEmployeesStartingWith( String prefix){
        try {
            Connection connection = DatabaseConnectionsUtils.getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT employeeId, firstName, lastName, dateOfBirth FROM employees WHERE firstname LIKE '" + prefix +"%'");
                // executeQuery se foloseste doar in cazurile de SELECT

            while (resultSet.next()) {
                Integer employeeId = resultSet.getInt("employeeID");
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
