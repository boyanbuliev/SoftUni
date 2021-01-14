package com.example.demo.services.impl;

import com.example.demo.models.dtos.PartSeedDto;
import com.example.demo.models.entities.Part;
import com.example.demo.repositories.PartRepository;
import com.example.demo.services.PartService;
import com.example.demo.services.SupplierService;
import com.example.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class PartServiceImpl implements PartService {
    private final SupplierService supplierService;
    private final PartRepository partRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Random random;

    @Autowired
    public PartServiceImpl(SupplierService supplierService, PartRepository partRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Random random) {
        this.supplierService = supplierService;
        this.partRepository = partRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Override
    public void seedParts(List<PartSeedDto> parts) {
        parts.forEach(p -> {
            if (validationUtil.isValid(p)) {
                if (partRepository.findByName(p.getName()) == null) {
                    Part part = modelMapper.map(p, Part.class);
                    part.setSupplier(supplierService.getRandomSupplier());
                    partRepository.save(part);
                } else {
                    System.out.println("Part already exists.");
                }
            } else {
                validationUtil.violations(p).stream().map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });
    }

    @Override
    public Set<Part> getRandomParts() {
        Set<Part> parts = new HashSet<>();
        for (int i = 0; i < random.nextInt(11) + 10; i++) {
            parts.add(partRepository.getOne((long) (random.nextInt((int) partRepository.count()) + 1)));
        }
        return parts;
    }
}
