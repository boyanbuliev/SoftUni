package com.example.demo.controllers;

import com.example.demo.entities.Address;
import com.example.demo.entities.Employee;
import com.example.demo.models.EmployeeDTO;
import com.example.demo.models.ManagerDTO;
import com.example.demo.services.AddressService;
import com.example.demo.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AppController implements CommandLineRunner {
    private final EmployeeService employeeService;
    private final AddressService addressService;

    public AppController(EmployeeService employeeService, AddressService addressService) {
        this.employeeService = employeeService;
        this.addressService = addressService;
    }

    @Override
    public void run(String... args) throws Exception {
        ModelMapper mapper = new ModelMapper();
        Address address = new Address("Bulgaria", "Sofia", "1000");
        Address address1 = addressService.addAddress(address);
        Employee employee = new Employee("Pesho", "Goshov",
                1000, LocalDate.of(1990, 5, 12), address);
        Employee employee1 = employeeService.addEmployee(employee);
        EmployeeDTO employeeDTO = mapper.map(employee1, EmployeeDTO.class);
        System.out.println(employeeDTO);

        List<Address> addresses = List.of(
                new Address("Bulgaria", "Sofia", "ul. G.S.Rakovski, 50"),
                new Address("Bulgaria", "Sofia", "Bul. Dondukov, 45"),
                new Address("Bulgaria", "Sofia", "ul. Hristo Smirnenski, 40"),
                new Address("Bulgaria", "Sofia", "bul. Alexander Malinov, 93a"),
                new Address("Bulgaria", "Sofia", "bul. Slivnitsa, 50"),
                new Address("Bulgaria", "Plovdiv", "ul. Angel Kanchev,34")
        );
        addresses = addresses.stream().map(addressService::addAddress).collect(Collectors.toList());

        List<Employee> employees = List.of(
                new Employee("Steve", "Adams", 5780, LocalDate.of(1982, 3, 12),
                        addresses.get(0)),
                new Employee("Stephen", "Petrov", 2760, LocalDate.of(1974, 5, 19),
                        addresses.get(1)),
                new Employee("Hristina", "Petrova", 3680, LocalDate.of(1991, 11, 9),
                        addresses.get(1)),
                new Employee("Diana", "Atanasova", 6790, LocalDate.of(1989, 12, 9),
                        addresses.get(2)),
                new Employee("Samuil", "Georgiev", 4780, LocalDate.of(1979, 2, 10),
                        addresses.get(3)),
                new Employee("Slavi", "Hristov", 3780, LocalDate.of(1985, 2, 23),
                        addresses.get(4)),
                new Employee("Georgi", "Miladinov", 3960, LocalDate.of(1995, 3, 11),
                        addresses.get(5))
        );
        List<Employee> created = employees.stream().map(employeeService::addEmployee).collect(Collectors.toList());
        created.get(1).setManager(created.get(0));
        created.get(2).setManager(created.get(0));
        created.get(4).setManager(created.get(3));
        created.get(5).setManager(created.get(3));
        created.get(6).setManager(created.get(3));
        List<Employee> updated = created.stream().map(employeeService::updateEmployee).collect(Collectors.toList());

        TypeMap<Employee, ManagerDTO> managerTypeMap = mapper.createTypeMap(Employee.class, ManagerDTO.class)
                .addMappings(m -> {
                    m.map(Employee::getSubordinates, ManagerDTO::setEmployees);
                    m.map(src -> src.getAddress().getCity(), ManagerDTO::setCity);
                });
//        mapper.getTypeMap(Employee.class, EmployeeDTO.class)
//                .addMapping(src -> src.getAddress().getCity(), EmployeeDTO::setCity);
        mapper.validate();
        List<Employee> managers = employeeService.getAllManagers();
        List<ManagerDTO> managerDTOs = managers.stream().map(managerTypeMap::map).collect(Collectors.toList());
        managerDTOs.forEach(System.out::println);
        System.out.println("-".repeat(20));
        List<Employee> allEmployeesWithBirthdayBefore =
                employeeService.getAllEmployeesWithBirthdayBefore(LocalDate.of(1990, 1, 1));
        TypeMap<Employee, EmployeeDTO> employeeEmployeeDTOTypeMap = mapper.getTypeMap(Employee.class, EmployeeDTO.class)
                .addMapping(map -> map.getManager().getLastName(), EmployeeDTO::setManagerLastName);
        mapper.validate();
        allEmployeesWithBirthdayBefore.stream()
                .map(employeeEmployeeDTOTypeMap::map).forEach(System.out::println);

    }
}
