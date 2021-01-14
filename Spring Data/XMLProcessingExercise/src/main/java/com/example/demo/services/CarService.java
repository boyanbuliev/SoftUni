package com.example.demo.services;

import com.example.demo.models.dtos.CarSeedDto;
import com.example.demo.models.entities.Car;

import java.math.BigDecimal;
import java.util.List;

public interface CarService {
    void seedCars(List<CarSeedDto> cars);

    BigDecimal getPrice();
}
