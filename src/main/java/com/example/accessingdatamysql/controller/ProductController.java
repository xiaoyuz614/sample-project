package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.model.Product;
import com.example.accessingdatamysql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/category")
    public @ResponseBody
    Iterable<Product> getProductByCategory(@RequestParam String category) {
        return productRepository.findProductByCategory(category);
    }

    @GetMapping(path = "/price-range")
    public @ResponseBody
    Iterable<Product> getProductWithPriceWithinRange(@RequestParam double lower, @RequestParam double upper) {
        return productRepository.findProductsWithinRange(lower, upper);
    }
}
