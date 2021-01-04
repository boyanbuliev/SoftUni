package com.example.demo.services;

import com.example.demo.entities.Employee;
import com.example.demo.exception.NonexistentEntityException;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getAllManagers() {
        return employeeRepository.findAllByManagerIsNull();
    }

    @Override
    public List<Employee> getAllEmployeesWithBirthdayBefore(LocalDate date) {
        return this.employeeRepository.findAllByBirthdayBeforeOrderBySalaryDesc(date);
    }

    @Override
    public Employee getEmployeeById(Long id) {
//        return employeeRepository.getOne(id);
        return employeeRepository.findById(id).orElseThrow(() -> new NonexistentEntityException(
                String.format("Employee with id =%s does not exist", id)));
    }

    @Transactional
    @Override
    public Employee addEmployee(Employee employee) {
        employee.setId(null);
        if (employee.getManager() != null) {
            employee.getManager().getSubordinates().add(employee);
        }
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public Employee updateEmployee(Employee employee) {
        Employee existing = getEmployeeById(employee.getId());
        Employee updated = employeeRepository.save(employee);
        if (existing.getManager() != null && !existing.getManager().equals(employee.getManager())) {
            existing.getManager().getSubordinates().remove(existing);
        }
        if (updated.getManager() != null && !updated.getManager().equals(existing.getManager())) {
            updated.getManager().getSubordinates().add(employee);
        }
        return updated;
    }

    @Transactional
    @Override
    public Employee deleteEmployee(Long id) {
        Employee removed = employeeRepository.getOne(id);
        if (removed.getManager() != null) {
            removed.getManager().getSubordinates().remove(removed);
        }
        employeeRepository.delete(employeeRepository.getOne(id));
        return removed;
    }

    @Override
    public long getEmployeeCount() {
        return employeeRepository.count();
    }
}
