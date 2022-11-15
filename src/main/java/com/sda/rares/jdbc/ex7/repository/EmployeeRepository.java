package com.sda.rares.jdbc.ex7.repository;

import com.sda.rares.jdbc.ex7.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Optional<Employee> findById(Integer id);

    List<Employee> findByDepartmentId(Integer departmentId);

    List<Employee> findAll();

    void save(Employee employee);

    void update(Employee employee);

    void deleteById(Integer id);
}
