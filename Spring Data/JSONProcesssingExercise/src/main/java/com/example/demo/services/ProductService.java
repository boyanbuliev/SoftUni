package com.example.demo.services;

import com.example.demo.models.dtos.ProductReturnDto;
import com.example.demo.models.dtos.ProductSeedDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts(ProductSeedDto[] productSeedDtos);

    List<ProductReturnDto> productsInRange(BigDecimal lower, BigDecimal upper);
}
