package com.example.cashregister.service;

import com.example.cashregister.exeption.CashRegisterError;
import com.example.cashregister.exeption.CashRegisterException;
import com.example.cashregister.exeption.FeignResponseException;
import com.example.cashregister.model.Product;
import com.example.cashregister.model.dto.ProductOutput;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductServiceClient productServiceClient;

    public ProductService(ProductServiceClient productServiceClient) {
        this.productServiceClient = productServiceClient;
    }

    public Product getProduct(long sellNumber) {
        Optional<ProductOutput> output = productServiceClient.getProduct(sellNumber);
        if (output.isEmpty()) throw new CashRegisterException(CashRegisterError.NO_RESPONSE_FROM_PRODUCT_SERVER);
        if (output.get().getMessage() != null) throw new FeignResponseException(output.get().getMessage());

        ProductOutput productOutput = output.get();
        if (productOutput.getName() == null)
            throw new CashRegisterException(CashRegisterError.INCORRECT_INPUT_FROM_PRODUCT_SERVER);
        if (productOutput.getPrice() == null)
            throw new CashRegisterException(CashRegisterError.INCORRECT_INPUT_FROM_PRODUCT_SERVER);
        if (productOutput.getSellNumber() == null)
            throw new CashRegisterException(CashRegisterError.INCORRECT_INPUT_FROM_PRODUCT_SERVER);

        return new Product(productOutput.getSellNumber(), productOutput.getName(), productOutput.getPrice());
    }

    public void checkProductNumber(long productNumber){
        if (productNumber > 999_999_999L || productNumber < 100_000_000L)
            throw new CashRegisterException(CashRegisterError.WRONG_PRODUCT_NUMBER);
    }

}