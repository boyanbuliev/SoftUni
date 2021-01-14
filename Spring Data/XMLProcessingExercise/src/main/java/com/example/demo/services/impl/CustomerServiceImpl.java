package com.example.demo.services.impl;

import com.example.demo.models.dtos.CustomerSeedDto;
import com.example.demo.models.dtos.CustomerViewDto;
import com.example.demo.models.dtos.CustomerViewRootDto;
import com.example.demo.models.entities.Customer;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.services.CustomerService;
import com.example.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Random random;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Random random) {
        this.customerRepository = customerRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Override
    public void seedCustomers(List<CustomerSeedDto> customers) {
        customers.forEach(c -> {
            if (validationUtil.isValid(c)) {
                if (this.customerRepository.findByNameAndBirthDate(c.getName(), c.getBirthDate()) == null) {
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

    @Override
    public Customer getRandomCustomer() {
        return customerRepository.getOne((long) (random.nextInt((int) customerRepository.count()) + 1));
    }

    @Override
    public CustomerViewRootDto getAllOrderedCustomers() {
        CustomerViewRootDto customerViewRootDto = new CustomerViewRootDto();
        customerViewRootDto.setCustomers(customerRepository.findAllByBirthDateAndIsYoungDriver().stream()
                .map(c -> modelMapper.map(c, CustomerViewDto.class)).collect(Collectors.toList()));
        return customerViewRootDto;
    }
}
