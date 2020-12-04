package CompanyRoster2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departments = new HashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee;
            if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (tokens.length == 6) {
                employee = new Employee(name, salary, position, department, tokens[4], Integer.parseInt(tokens[5]));
            } else {
                try {
                    employee = new Employee(name, salary, position, department, Integer.parseInt(tokens[4]));
                } catch (NumberFormatException e) {
                    employee = new Employee(name, salary, position, department, tokens[4]);
                }
            }
            departments.putIfAbsent(department, new Department(department));
            departments.get(department).getEmployees().add(employee);
        }
        Department maxDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(f -> f.getValue().getAvgSalary()))
                .get()
                .getValue();
        System.out.println("Highest Average Salary: " + maxDepartment.getName());

        maxDepartment.getEmployees()
                .stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);
    }
}

