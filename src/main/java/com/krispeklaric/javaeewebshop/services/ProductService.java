/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.services;

import com.krispeklaric.javaeewebshop.models.Category;
import com.krispeklaric.javaeewebshop.repositories.CategoryRepository;
import com.krispeklaric.javaeewebshop.services.interfaces.IProductService;
import java.util.List;

/**
 *
 * @author Kris
 */
public class ProductService implements IProductService {

    private CategoryRepository _categoryRepository;

    public ProductService() {
        _categoryRepository = new CategoryRepository();
    }

    @Override
    public List<Category> getAllCategory() {
        return _categoryRepository.getAll();
    }

}
