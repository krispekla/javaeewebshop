/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.controllers;

import com.google.gson.Gson;
import com.krispeklaric.javaeewebshop.dtos.CartDTO;
import com.krispeklaric.javaeewebshop.dtos.OrderDTO;
import com.krispeklaric.javaeewebshop.models.Order;
import com.krispeklaric.javaeewebshop.models.User;
import com.krispeklaric.javaeewebshop.services.OrderService;
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
 * @author Kris
 */
public class PaymentServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        Boolean isAuthenticated = (Boolean) session.getAttribute(Constants.IS_AUTHENTICATED);

        if (!isAuthenticated) {

            request.setAttribute(Constants.STATUS, "401");
            request.setAttribute(Constants.MESSAGE, "Unauthorized, please login to proceed with payment!");

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/payment.jsp");
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
        OrderDTO order = gson.fromJson(sb.toString(), OrderDTO.class);

        HttpSession session = request.getSession();

        CartDTO cart = (CartDTO) session.getAttribute(Constants.CART);
        User user = (User) session.getAttribute(Constants.USER);

        order.setUser(user);
        order.setItems(cart.getItems());

        OrderService orderService = new OrderService();
        Order result = orderService.create(order);

        List<Order> orders = orderService.getAll(user);

        session.setAttribute(Constants.CART, new CartDTO());
        session.setAttribute(Constants.ORDERS, orders);
        if (result != null) {
            response.setStatus(HttpServletResponse.SC_OK);

            request.setAttribute(Constants.STATUS, "200");
            request.setAttribute("data", "Order succesfully created!");

        } else {
            response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);

            request.setAttribute(Constants.STATUS, "500");
            request.setAttribute("data", "Order could not be created, please contact support!");
        }
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
