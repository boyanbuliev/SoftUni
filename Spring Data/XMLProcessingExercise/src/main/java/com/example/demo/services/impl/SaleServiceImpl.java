package com.example.demo.services.impl;

import com.example.demo.repositories.SaleRepository;
import com.example.demo.services.CarService;
import com.example.demo.services.CustomerService;
import com.example.demo.services.SaleService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {
    private final int[] DISCOUNTS = new int[]{0, 5, 10, 15, 20, 30, 40, 50};
    private final SaleRepository saleRepository;
    private final CustomerService customerService;
    private final CarService carService;
    private final Random random;

    public SaleServiceImpl(SaleRepository saleRepository, CustomerService customerService, CarService carService, Random random) {
        this.saleRepository = saleRepository;
        this.customerService = customerService;
        this.carService = carService;
        this.random = random;
    }


    @Override
    public void seedSales() {
        int discount = DISCOUNTS[random.nextInt(DISCOUNTS.length)];
    }
}
