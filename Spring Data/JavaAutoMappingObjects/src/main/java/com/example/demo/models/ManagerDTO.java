package com.example.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ManagerDTO {
    private String firstName;
    private String lastName;
    private String city;
    private List<EmployeeDTO> employees;

    private int getSubordinatesNumber() {
        return employees.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %s | Employees: %d%n", firstName, lastName, city, getSubordinatesNumber()));
        employees.forEach(s -> sb.append(String.format("\t- %s%n", s)));
        return sb.toString().trim();
    }
}
