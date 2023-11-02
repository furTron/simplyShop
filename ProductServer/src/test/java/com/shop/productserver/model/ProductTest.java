package com.shop.productserver.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testNull() {
        Product productToTest = new Product();
        assertFalse(productToTest.testProduct());
    }


    @Test
    void testSellNumber() {
        Product productToTest = new Product();
        productToTest.setName("test");
        productToTest.setPrice(1.11);

        assertFalse(productToTest.testProduct()); // test sellNumber==Null

        productToTest.setSellNumber(123456789);
        assertTrue(productToTest.testProduct());

        productToTest.setSellNumber(100_000_000);
        assertTrue(productToTest.testProduct());

        productToTest.setSellNumber(999_999_999);
        assertTrue(productToTest.testProduct());

        productToTest.setSellNumber(0);
        assertFalse(productToTest.testProduct());

        productToTest.setSellNumber(-1);
        assertFalse(productToTest.testProduct());

        productToTest.setSellNumber(12345678);
        assertFalse(productToTest.testProduct());

        productToTest.setSellNumber(1234567890);
        assertFalse(productToTest.testProduct());
    }

    @Test
    void testName() {
        Product productToTest = new Product();
        productToTest.setSellNumber(123456789);
        productToTest.setName("test");
        productToTest.setPrice(1.11);

        assertTrue(productToTest.testProduct());

        productToTest.setName(null);
        assertFalse(productToTest.testProduct());

        productToTest.setName("");
        assertFalse(productToTest.testProduct());

        productToTest.setName(" ");
        assertFalse(productToTest.testProduct());

        productToTest.setName("A");
        assertTrue(productToTest.testProduct());
    }

    @Test
    void testPrice() {
        Product productToTest = new Product();
        productToTest.setSellNumber(123456789);
        productToTest.setName("test");

        assertFalse(productToTest.testProduct());  // test price==Null

        productToTest.setPrice(1.11);
        assertTrue(productToTest.testProduct());

        productToTest.setPrice(0);
        assertTrue(productToTest.testProduct());

        productToTest.setPrice(0.000001);
        assertTrue(productToTest.testProduct());

        productToTest.setPrice(-1);
        assertFalse(productToTest.testProduct());

        productToTest.setPrice(-0.00000001);
        assertFalse(productToTest.testProduct());
    }
}