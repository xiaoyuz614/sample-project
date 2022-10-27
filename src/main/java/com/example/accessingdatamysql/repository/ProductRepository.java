package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.model.Customer;
import com.example.accessingdatamysql.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query("SELECT p FROM Product  p WHERE p.category = :category")
    List<Product> findProductByCategory(@Param("category") String category);

    @Query("SELECT p FROM Product  p WHERE p.price > :number")
    List<Product> findProductWithPriceGreaterThan(@Param("number") double number);



}
