package com.example.demo.services.impl;

import com.example.demo.models.dtos.CarSeedDto;
import com.example.demo.models.entities.Car;
import com.example.demo.models.entities.Part;
import com.example.demo.repositories.CarRepository;
import com.example.demo.services.CarService;
import com.example.demo.services.PartService;
import com.example.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final PartService partService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartService partService, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public void seedCars(List<CarSeedDto> cars) {
        cars.forEach(c -> {
            if (validationUtil.isValid(c)) {
                Car car = modelMapper.map(c, Car.class);
                car.setParts(partService.getRandomParts());
                carRepository.save(car);
            } else {
                validationUtil.violations(c).stream().map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });
    }
@Transactional
    @Override
    public BigDecimal getPrice() {
        System.out.println();
        System.out.println(carRepository.getOne(1L).getParts().stream().map(Part::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        return null;
    }
}
