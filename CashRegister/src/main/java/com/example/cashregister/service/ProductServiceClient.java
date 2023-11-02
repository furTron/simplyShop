package com.example.cashregister.service;

import com.example.cashregister.model.dto.ProductOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductServiceClient {

    @GetMapping("/{id}")
    public Optional<ProductOutput> getProduct(@PathVariable long id);
}
