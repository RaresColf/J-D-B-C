package com.sda.rares.jdbc.ex7.model;

import java.sql.Date;

/**
 * `employeeId` int(11) NOT NULL AUTO_INCREMENT,
 * `firstName` varchar(25) DEFAULT NULL,
 * `lastName` varchar(45) DEFAULT NULL,
 * `dateOfBirth` date DEFAULT NULL,
 * `phoneNumber` varchar(45) DEFAULT NULL,
 * `email` varchar(45) DEFAULT NULL,
 * `salary` int(11) DEFAULT NULL,
 * `departmentId` int(11) DEFAULT NULL,
 * `managerId` int(11) DEFAULT NULL,
 */

public class Employee {

   private Integer employeeId;
   private String firstName;
   private String lastName;
   private Date dateOfBirth;
   private String phoneNumber;
   private String email;
   private Integer salary;
   private Integer departmentId;
   private Integer managerId;

    public Employee(Integer employeeId, String firstName, String lastName, Date dateOfBirth, String phoneNumber, String email, Integer salary, Integer departmentId, Integer managerId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.salary = salary;
        this.departmentId = departmentId;
        this.managerId = managerId;
    }

    public Employee(){

    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", departmentId=" + departmentId +
                ", managerId=" + managerId +
                '}';
    }
}
