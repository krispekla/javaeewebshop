/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.utils;

import com.krispeklaric.javaeewebshop.dtos.CartDTO;
import com.krispeklaric.javaeewebshop.models.Category;
import com.krispeklaric.javaeewebshop.services.ProductService;
import com.krispeklaric.javaeewebshop.services.interfaces.IProductService;
import java.util.List;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author pekla
 */
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        IProductService productService = new ProductService();
        List<Category> categories = productService.getAllCategory();
        CartDTO cart = new CartDTO();
        se.getSession().setAttribute("categories", categories);
        se.getSession().setAttribute("isAuthenticated", false);
        se.getSession().setAttribute("cart", cart);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        se.getSession().setAttribute("categories", null);
        se.getSession().setAttribute("isAuthenticated", false);
        se.getSession().setAttribute("cart", null);
    }
}
