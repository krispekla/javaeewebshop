/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.controllers;

import com.krispeklaric.javaeewebshop.dtos.CartDTO;
import com.krispeklaric.javaeewebshop.dtos.LogDTO;
import com.krispeklaric.javaeewebshop.models.User;
import com.krispeklaric.javaeewebshop.models.UserRole;
import com.krispeklaric.javaeewebshop.services.OrderService;
import com.krispeklaric.javaeewebshop.services.UserService;
import com.krispeklaric.javaeewebshop.services.interfaces.IUserService;
import com.krispeklaric.javaeewebshop.utils.Constants;
import com.krispeklaric.javaeewebshop.utils.LogHelper;
import java.io.IOException;
import java.time.LocalDateTime;
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
public class LoginServlet extends HttpServlet {

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
        String logout = request.getParameter("logout");
        if (!logout.isEmpty()) {
            HttpSession session = request.getSession();

            session.setAttribute(Constants.USER, null);
            session.setAttribute(Constants.ROLE, null);
            session.setAttribute(Constants.CART, new CartDTO());
            session.setAttribute(Constants.IS_AUTHENTICATED, false);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        } else {

            processRequest(request, response);
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
        boolean isInvalid = false;

        String username = request.getParameter(Constants.PARAM_USERNAME);
        String password = request.getParameter(Constants.PARAM_PASSWORD);

        if (username.isEmpty() || password.isEmpty()) {
            request.setAttribute("invalidLogin", "Username and password cannot be empty");

            isInvalid = true;
        }

        IUserService userService = new UserService();
        User result = userService.login(username, password);
        if (result == null) {
            request.setAttribute("invalidLogin", "Wrong username or password");
            isInvalid = true;
        }

        if (isInvalid) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        } else {
            UserRole userRole = userService.getUserRole(result);

            LogDTO log = new LogDTO();
            log.setDateTime(LocalDateTime.now());
            log.setUsername(username);
            log.setIpAddress(LogHelper.getClientIpAddress(request));
            LogHelper.writeLog(log.toString());

            HttpSession session = request.getSession();
            session.setAttribute(Constants.USER, result);
            session.setAttribute(Constants.ROLE, userRole.getName());
            session.setAttribute(Constants.IS_AUTHENTICATED, true);

            request.setAttribute(Constants.STATUS, "200");
            request.setAttribute(Constants.MESSAGE, "Sucesfully logged in");

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

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
