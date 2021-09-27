package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ControllerProducts {
    private static long id = 1;
    private final ProductService productService;

    public ControllerProducts(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/add")
    public boolean addProduct(@RequestBody Product product) {
        product.setId(id++);
        return productService.addProduct(product);
    }

    @PostMapping("/all")
    public List<Product> getAllProduct(@RequestBody Product product) {
        return productService.getAllProducts();
    }

    @GetMapping("/get/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @GetMapping("/del")
    public boolean deleteProduct(@RequestBody Product product) {
        return productService.deleteProduct(id);
    }

}
