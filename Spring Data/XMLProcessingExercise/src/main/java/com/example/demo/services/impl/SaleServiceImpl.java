package com.example.demo.services.impl;

import com.example.demo.models.entities.Sale;
import com.example.demo.repositories.SaleRepository;
import com.example.demo.services.CarService;
import com.example.demo.services.CustomerService;
import com.example.demo.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {
    private final Double[] DISCOUNTS = new Double[]{0D, 0.05, 0.10, 0.15, 0.2, 0.3, 0.4, 0.5};
    private final SaleRepository saleRepository;
    private final CustomerService customerService;
    private final CarService carService;
    private final Random random;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CustomerService customerService, CarService carService, Random random) {
        this.saleRepository = saleRepository;
        this.customerService = customerService;
        this.carService = carService;
        this.random = random;
    }


    @Override
    public void seedSales() {
        for (int i = 0; i < (random.nextInt(Math.toIntExact(carService.getCount()))) + 1; i++) {
            Sale sale = new Sale();
            sale.setBuyer(customerService.getRandomCustomer());
            sale.setCar(carService.getRandomCar());
            sale.setDiscount(DISCOUNTS[random.nextInt(DISCOUNTS.length)]);
            saleRepository.save(sale);
        }
    }
}
