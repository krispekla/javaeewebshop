/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.controllers;

import com.krispeklaric.javaeewebshop.models.User;
import com.krispeklaric.javaeewebshop.services.UserService;
import com.krispeklaric.javaeewebshop.services.interfaces.IUserService;
import com.krispeklaric.javaeewebshop.utils.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kris
 */
public class RegisterServlet extends HttpServlet {

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

        IUserService userService = new UserService();
        boolean isInvalid = false;
        User user = new User();

//        Params
        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

//        Validations
        if (!firstname.isEmpty()) {
            request.setAttribute("firstname", firstname);
            user.setFirstname(firstname);
        }
        if (!lastname.isEmpty()) {
            request.setAttribute("lastname", lastname);
            user.setLastname(lastname);
        }

        if (username.isEmpty()) {
            request.setAttribute("invalidUsername", "Username is required");
        } else {
            request.setAttribute("username", username);
            if (!userService.checkIfUsernameIsAvailable(username)) {
                request.setAttribute("invalidUsername", "Username already in use");

                isInvalid = true;
            }
        }

        if (email.isEmpty()) {
            request.setAttribute("invalidEmail", "Email is required");
        } else {
            request.setAttribute("email", email);
            Matcher matcher = Constants.EMAIL_REGEX.matcher(email);

            if (!matcher.matches()) {
                request.setAttribute("invalidEmail", "Email is not in right format");
                isInvalid = true;
            } else if (!userService.checkIfEmailIsAvailable(email)) {
                request.setAttribute("invalidEmail", "Email is not available");
                isInvalid = true;
            }
        }
        if (password.isEmpty()) {
            request.setAttribute("invalidPassword", "Password is required");
        } else {
            Matcher matcherPassword = Constants.PASSWORD_REGEX.matcher(password);

            if (!matcherPassword.matches()) {
                request.setAttribute("invalidPassword", "Minimum 8 characters at least 1 Alphabet and 1 Number");

                isInvalid = true;
            }
        }

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            isInvalid = true;
        }

        if (isInvalid) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
        } else {
            user.setEmail(email);
            user.setPassword(password);
            user.setUsername(username);

            userService.register(user);

            request.setAttribute("status", "200");
            request.setAttribute("message", "Sucesfully registered. Please login!");

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
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
