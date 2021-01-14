package com.example.demo.services;

import com.example.demo.models.dtos.SupplierSeedDto;
import com.example.demo.models.entities.Supplier;

import java.util.List;

public interface SupplierService {
    void seedSuppliers(List<SupplierSeedDto> suppliers);

    Supplier getRandomSupplier();
}
