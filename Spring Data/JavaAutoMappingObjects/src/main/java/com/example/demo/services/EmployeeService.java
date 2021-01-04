package com.example.demo.services;

import com.example.demo.entities.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    List<Employee> getAllManagers();

    List<Employee> getAllEmployeesWithBirthdayBefore(LocalDate date);

    Employee getEmployeeById(Long id);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee deleteEmployee(Long id);

    long getEmployeeCount();
}
