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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kris
 */
public class CartServlet extends HttpServlet {

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

    }

    protected void removeCartItemByProductId(HttpServletRequest request, HttpServletResponse response, Long removeItemId) throws ServletException, IOException {

        HttpSession session = request.getSession();
        CartDTO cart = (CartDTO) session.getAttribute("cart");

        List<OrderItem> items = cart.getItems();
        OrderItem temp = null;
        for (OrderItem item : items) {
            if (Long.compare(item.getProduct().getId_product(), removeItemId) == 0) {
                temp = item;
                break;
            }
        }
        if (temp != null) {
            items.remove(temp);
        }

        cart.setItems(items);
        session.setAttribute("cart", cart);

        request.setAttribute("status", "200");
        request.setAttribute("message", "Sucesfully removed item.");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cart.jsp");
        dispatcher.forward(request, response);
    }

    protected void removeAllItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        CartDTO cart = (CartDTO) session.getAttribute("cart");

        cart = new CartDTO();

        session.setAttribute("cart", cart);

        request.setAttribute("status", "200");
        request.setAttribute("message", "Sucesfully removed all items.");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cart.jsp");
        dispatcher.forward(request, response);
    }

    private void updateItem(HttpServletRequest request, HttpServletResponse response, long updateItemId, long quantity) throws ServletException, IOException {

        HttpSession session = request.getSession();
        CartDTO cart = (CartDTO) session.getAttribute("cart");

        List<OrderItem> items = cart.getItems();
        OrderItem temp = null;
        int i = 0;
        for (OrderItem item : items) {
            if (Long.compare(item.getProduct().getId_product(), updateItemId) == 0) {
                temp = item;
                item.setQuantity(quantity);
                BigDecimal newPrice = BigDecimal.valueOf(quantity).multiply(item.getProduct().getPrice());
                item.setPrice(newPrice);
                break;
            }
            i++;
        }

        cart.setItems(items);
        session.setAttribute("cart", cart);

        request.setAttribute("status", "200");
        request.setAttribute("message", "Item quantity succesfully updated");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cart.jsp");
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
        String removeItem = request.getParameter("removeId");
        String removeAll = request.getParameter("removeAll");
        String updateItemId = request.getParameter("updateItemId");
        String updateQuantity = request.getParameter("updateQuantity");

        if (removeItem != null) {
            removeCartItemByProductId(request, response, Long.parseLong(removeItem));
        }

        if (removeAll != null) {
            removeAllItems(request, response);
        }

        if (updateItemId != null && updateQuantity != null) {
            updateItem(request, response, Long.parseLong(updateItemId), Long.parseLong(updateQuantity));
        }
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
        processRequest(request, response);
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
