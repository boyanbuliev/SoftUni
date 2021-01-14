package com.example.demo.services.impl;

import com.example.demo.models.dtos.CarSeedDto;
import com.example.demo.models.dtos.CarViewDto;
import com.example.demo.models.dtos.CarViewRootDto;
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
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final PartService partService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Random random;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartService partService, ValidationUtil validationUtil, ModelMapper modelMapper, Random random) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Transactional
    @Override
    public void seedCars(List<CarSeedDto> cars) {
        cars.forEach(c -> {
            if (validationUtil.isValid(c)) {
                if (carRepository.findByMakeAndModelAndTravelledDistance(c.getMake(),
                        c.getModel(), c.getTravelledDistance()) == null) {
                    Car car = modelMapper.map(c, Car.class);
                    car.setParts(partService.getRandomParts());
                    carRepository.save(car);
                } else {
                    System.out.println("Car already exists.");
                }
            } else {
                validationUtil.violations(c).stream().map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });
    }

    public Long getCount() {
        return carRepository.count();
    }

    @Override
    public CarViewRootDto getAllCarsFromMake(String make) {
        CarViewRootDto carViewRootDto = new CarViewRootDto();
        carViewRootDto.setCars(carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc(make)
                .stream().map(c -> modelMapper.map(c, CarViewDto.class)).collect(Collectors.toList()));
        return carViewRootDto;
    }

    @Transactional
    @Override
    public BigDecimal getPrice(Car car) {
        return carRepository.getOne(1L).getParts().stream()
                .map(Part::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public Car getRandomCar() {
        return carRepository.getOne((long) (random.nextInt((int) carRepository.count()) + 1));
    }
}
