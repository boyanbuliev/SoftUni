package com.example.demo.services;

import com.example.demo.models.dtos.ProductSeedDto;

public interface ProductService {
    void seedProducts(ProductSeedDto[] productSeedDtos);

}
