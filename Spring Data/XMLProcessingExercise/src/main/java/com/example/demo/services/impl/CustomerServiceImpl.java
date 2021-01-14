package com.example.demo.services.impl;

import com.example.demo.models.dtos.CustomerSeedDto;
import com.example.demo.models.entities.Customer;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.services.CustomerService;
import com.example.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;

    }

    @Override
    public void seedCustomers(List<CustomerSeedDto> customers) {
        customers.forEach(c -> {
            if (validationUtil.isValid(c)) {
                if (this.customerRepository.findByName(c.getName()) == null) {
                    this.customerRepository.save(modelMapper.map(c, Customer.class));
                } else {
                    System.out.println("Customer already exists");
                }
            } else {
                validationUtil.violations(c).stream().map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });
    }
}
