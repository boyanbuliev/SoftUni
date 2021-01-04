package com.example.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private double salary;
    //    private LocalDate birthday;
//    private String city;
    private String managerLastName;

    @Override
    public String toString() {
        return String.format("%s %s %.2f %s", firstName, lastName, salary, managerLastName);
    }
}
