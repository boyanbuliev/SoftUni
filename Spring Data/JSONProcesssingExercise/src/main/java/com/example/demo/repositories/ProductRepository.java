package com.example.demo.repositories;

import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByPriceBetweenAndBuyerIsNull(BigDecimal lower, BigDecimal upper);

    List<Product> findAllByBuyerIsNotNull();

    List<Product> findAllBySellerAndBuyerIsNotNull(User seller);
}
