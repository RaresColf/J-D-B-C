package com.sda.rares.jdbc.ex7;

import com.sda.rares.jdbc.ex7.model.Employee;
import com.sda.rares.jdbc.ex7.repository.EmployeeRepository;
import com.sda.rares.jdbc.ex7.repository.EmployeeRepositoryImpl;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

//        System.out.println(employeeRepository.findById(1));
//        System.out.println(employeeRepository.findById(999));
//
//
//        employeeRepository.deleteById(5);
//
//        Employee employee = new Employee(
//                null,
//                "Alex",
//                "Popescu",
//                new Date(2019,06,06),
//                "55566699998",
//                "alex@popescu.ro",
//                10000,
//                1,
//                4
//        );
//
//        employeeRepository.save(employee);

//     System.out.println( employeeRepository.findByDepartmentId(1));
//       System.out.println(employeeRepository.findAll());

//        employeeRepository.update();

        Employee employee1 = new Employee(
                7,
                "Alex",
                "Popescu",
                new Date(2019,06,06),
                "55566699998",
                "alex@popescu.ro",
                10000,
                3,
                4

        );

        employeeRepository.update(employee1);
    }
}
