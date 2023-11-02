package com.shop.productserver.controller;

import com.shop.productserver.model.Product;
import com.shop.productserver.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.getProduct(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Optional<Product> newProduct){
        return productService.addProduct(newProduct);
    }

    @DeleteMapping("/{id}")
    public Product removeProduct(@PathVariable int id){
        return productService.removeProduct(id);
    }
}
