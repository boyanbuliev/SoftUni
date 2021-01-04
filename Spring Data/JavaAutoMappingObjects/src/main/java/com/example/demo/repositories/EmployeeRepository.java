package com.example.demo.repositories;

import com.example.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByManagerIsNull();

    List<Employee> findAllByBirthdayBeforeOrderBySalaryDesc(LocalDate birthday);
}
