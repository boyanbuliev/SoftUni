package com.example.demo.services.impl;

import com.example.demo.models.dtos.SupplierSeedDto;
import com.example.demo.models.entities.Supplier;
import com.example.demo.repositories.SupplierRepository;
import com.example.demo.services.SupplierService;
import com.example.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Random;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Random random;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Random random) {
        this.supplierRepository = supplierRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Override
    public void seedSuppliers(List<SupplierSeedDto> suppliers) {
        suppliers.forEach(s -> {
            if (validationUtil.isValid(s)) {
                if (this.supplierRepository.findByName(s.getName()) == null) {
                    this.supplierRepository.save(modelMapper.map(s, Supplier.class));
                } else {
                    System.out.println("Supplier already added");
                }

            } else {
                validationUtil.violations(s).stream().map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });
    }

    @Override
    public Supplier getRandomSupplier() {
        return this.supplierRepository
                .getOne((long) (random.nextInt((int) supplierRepository.count()) + 1));
    }
}
