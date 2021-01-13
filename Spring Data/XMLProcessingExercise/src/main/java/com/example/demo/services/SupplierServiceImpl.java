package com.example.demo.services;

import com.example.demo.models.dtos.SupplierSeedRootDto;
import com.example.demo.models.entities.Supplier;
import com.example.demo.repositories.SupplierRepository;
import com.example.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSuppliers(SupplierSeedRootDto suppliers) {
        if (validationUtil.isValid(suppliers)) {
            suppliers.getSuppliers().stream().map(s -> modelMapper.map(s, Supplier.class))
                    .forEach(supplierRepository::save);
        }
    }
}
