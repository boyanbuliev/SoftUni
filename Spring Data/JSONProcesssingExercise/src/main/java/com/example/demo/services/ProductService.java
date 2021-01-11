package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.models.dtos.ProductReturnDto;
import com.example.demo.models.dtos.ProductSeedDto;
import com.example.demo.models.dtos.SoldProductDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ProductService {
    void seedProducts(ProductSeedDto[] productSeedDtos);

    List<ProductReturnDto> productsInRange(BigDecimal lower, BigDecimal upper);

    Set<SoldProductDto> soldProductsBySeller(User seller);
}
