package com.example.demo.services;

import com.example.demo.models.dtos.CustomerSeedDto;

import java.util.List;

public interface CustomerService {
    void seedCustomers(List<CustomerSeedDto> customers);
}
