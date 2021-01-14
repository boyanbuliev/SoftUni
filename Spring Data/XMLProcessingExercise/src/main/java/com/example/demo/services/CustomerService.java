package com.example.demo.services;

import com.example.demo.models.dtos.CustomerSeedDto;
import com.example.demo.models.dtos.CustomerViewRootDto;
import com.example.demo.models.entities.Customer;

import java.util.List;

public interface CustomerService {
    void seedCustomers(List<CustomerSeedDto> customers);

    Customer getRandomCustomer();

    CustomerViewRootDto getAllOrderedCustomers();
}
