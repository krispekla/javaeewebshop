/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.controllers;

import com.krispeklaric.javaeewebshop.models.Order;
import com.krispeklaric.javaeewebshop.models.User;
import com.krispeklaric.javaeewebshop.services.OrderService;
import com.krispeklaric.javaeewebshop.services.UserService;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class OrderHistoryServlet extends HttpServlet {

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
        Boolean isAuthenticated = (Boolean) session.getAttribute("isAuthenticated");

        if (!isAuthenticated) {

            request.setAttribute("status", "401");
            request.setAttribute("message", "Unauthorized, please login to view your order history!");

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        OrderService orderService = new OrderService();

        if (!session.getAttribute("role").equals("admin")) {
            List<Order> orders = orderService.getAll((User) session.getAttribute("user"));
            request.setAttribute("orders", orders);

        } else {
            UserService userService = new UserService();
            List<User> users = userService.getAll();
            List<Order> orders;

            String username = request.getParameter("username");
            String date = request.getParameter("date");

            if (username != null && date != null) {
                LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                User resultUser = userService.get(username);
                orders = orderService.getAll(resultUser, parsedDate);
            } else if (username != null) {
                User resultUser = userService.get(username);
                orders = orderService.getAll(resultUser);
            } else if (date != null) {
                LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                orders = orderService.getAll(parsedDate);
            } else {
                orders = orderService.getAll();
            }

            request.setAttribute("orders", orders);
            request.setAttribute("users", users);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/orders.jsp");
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
