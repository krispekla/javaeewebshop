/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.controllers;

import com.google.gson.Gson;
import com.krispeklaric.javaeewebshop.dtos.CartDTO;
import com.krispeklaric.javaeewebshop.dtos.ProductDTO;
import com.krispeklaric.javaeewebshop.models.OrderItem;
import com.krispeklaric.javaeewebshop.models.Product;
import com.krispeklaric.javaeewebshop.services.ProductService;
import com.krispeklaric.javaeewebshop.services.interfaces.IProductService;
import com.krispeklaric.javaeewebshop.utils.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pekla
 */
public class ProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String category = request.getParameter(Constants.PARAM_CATEGORY);

        IProductService productService = new ProductService();
        List<Product> products = productService.getProduct(category);
        request.setAttribute(Constants.PRODUCTS, products);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/product-overview.jsp");
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final StringBuilder sb = new StringBuilder();
        try (final BufferedReader br = request.getReader();) {
            String line = null;
            while (null != (line = br.readLine())) {
                sb.append(line);
            }
        }
        Gson gson = new Gson();
        ProductDTO product = gson.fromJson(sb.toString(), ProductDTO.class);

        HttpSession session = request.getSession();
        CartDTO cart = (CartDTO) session.getAttribute(Constants.CART);

        ProductService productService = new ProductService();
        OrderItem item = productService.get(product.getId(), product.getQuantity());
        
        cart.addOrUpdateItem(item);

        session.setAttribute(Constants.CART, cart);

        response.setStatus(HttpServletResponse.SC_OK);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
