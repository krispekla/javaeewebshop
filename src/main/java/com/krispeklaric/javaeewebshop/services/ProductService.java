/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.services;

import com.krispeklaric.javaeewebshop.models.Category;
import com.krispeklaric.javaeewebshop.models.OrderItem;
import com.krispeklaric.javaeewebshop.models.Product;
import com.krispeklaric.javaeewebshop.repositories.CategoryRepository;
import com.krispeklaric.javaeewebshop.repositories.ProductRepository;
import com.krispeklaric.javaeewebshop.services.interfaces.IProductService;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Kris
 */
public class ProductService implements IProductService {

    private CategoryRepository _categoryRepository;
    private ProductRepository _productRepository;

    public ProductService() {
        _categoryRepository = new CategoryRepository();
        _productRepository = new ProductRepository();
    }

    @Override
    public List<Category> getAllCategory() {
        return _categoryRepository.getAll();
    }

    @Override
    public List<Product> getProduct(String category) {
        Category categoryResult = _categoryRepository.get(category);
        return _productRepository.getAll(categoryResult);
    }

    @Override
    public OrderItem get(int productId, int quantity) {
        Product product = _productRepository.get(Long.valueOf(productId));

        if (product == null) {
            return null;
        }
        
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        orderItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(quantity)));

        return orderItem;
    }

}
