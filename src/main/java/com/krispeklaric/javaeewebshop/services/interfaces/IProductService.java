/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.services.interfaces;

import com.krispeklaric.javaeewebshop.models.Category;
import java.util.List;

/**
 *
 * @author Kris
 */
public interface IProductService {

    List<Category> getAllCategory();

}
