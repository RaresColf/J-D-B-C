package com.sda.rares.jdbc.ex7.repository;

import com.sda.rares.jdbc.ex7.model.Employee;
import com.sda.rares.jdbc.utils.DatabaseConnectionsUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public Optional<Employee> findById(Integer id) {
        try {
            Connection connection = DatabaseConnectionsUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees WHERE employeeId =" + id);
            Optional<Employee> result;

            if (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("employeeId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getDate("dateOfBirth"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("email"),
                        resultSet.getInt("salary"),
                        resultSet.getInt("departmentId"),
                        resultSet.getInt("managerId")
                );

                result = Optional.of(employee);
            } else {
                result = Optional.empty();
            }

            resultSet.close();
            statement.close();
            connection.close();

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Employee> findByDepartmentId(Integer departmentId) {
        try {
            Connection connection = DatabaseConnectionsUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees WHERE departmentID =" + departmentId);
            List<Employee> result = new ArrayList<>();

            while (resultSet.next()){
                Employee employee = new Employee(
                        resultSet.getInt("employeeId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getDate("dateOfBirth"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("email"),
                        resultSet.getInt("salary"),
                        resultSet.getInt("departmentId"),
                        resultSet.getInt("managerId")
                );
                result.add(employee);

            }
            resultSet.close();
            statement.close();
            connection.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Employee> findAll() {
        try {
            Connection connection = DatabaseConnectionsUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
            List<Employee> result = new ArrayList<>(); // initializam o lista goala

            while (resultSet.next()){
                Employee employee = new Employee(
                        resultSet.getInt("employeeId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getDate("dateOfBirth"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("email"),
                        resultSet.getInt("salary"),
                        resultSet.getInt("departmentId"),
                        resultSet.getInt("managerId")
                );
                result.add(employee);   // aici nu mai suprascriu lista ca sa avem alta lista goala, ci adaug fiecare element interat
            }
            resultSet.close();
            statement.close();
            connection.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();    // pentru ca la liste niciodata nu punem return null, o sa returnam o lsita goala
        }
    }

    @Override
    public void save(Employee employee) {
        try {
            Connection connection = DatabaseConnectionsUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO employees (firstName, lastName, dateOfBirth, phoneNumber, email, salary, departmentId, managerId) VALUES (?,?,?,?,?,?,?,?)"
            );
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setDate(3, employee.getDateOfBirth());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setString(5, employee.getEmail());
            preparedStatement.setInt(6, employee.getSalary());
            preparedStatement.setInt(7, employee.getDepartmentId());
            preparedStatement.setInt(8, employee.getManagerId());

            int affectedRows = preparedStatement.executeUpdate();

            System.out.println("Inserted result is: " + (affectedRows == 1 ? "OK" : "ERROR"));    // varianta cu operator ternar , adica un IF simplificat

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee employee) {
        try {
            Connection connection = DatabaseConnectionsUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE employees SET firstName=?, lastName=?, dateOfBirth=?, phoneNumber=?, email=?, salary=?, departmentId=?, managerId=? WHERE employeeId=?"
            );
            preparedStatement.setInt(9,employee.getEmployeeId());
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setDate(3, employee.getDateOfBirth());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setString(5, employee.getEmail());
            preparedStatement.setInt(6, employee.getSalary());
            preparedStatement.setInt(7, employee.getDepartmentId());
            preparedStatement.setInt(8, employee.getManagerId());

            int affectedRows = preparedStatement.executeUpdate();

            System.out.println("Updated result is: " + (affectedRows == 1 ? "OK" : "ERROR"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteById(Integer id) {

        try {
            Connection connection = DatabaseConnectionsUtils.getConnection();
            Statement statement = connection.createStatement();
            int affectedRows = statement.executeUpdate("DELETE FROM employees WHERE employeeId =" + id);
            if (affectedRows == 1) {
                System.out.println("Employee deleted");
            } else {
                System.out.println("Employee not found");
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
