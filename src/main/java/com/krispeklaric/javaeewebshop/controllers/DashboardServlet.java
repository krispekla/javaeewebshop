/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.controllers;

import com.krispeklaric.javaeewebshop.dtos.LogDTO;
import com.krispeklaric.javaeewebshop.utils.LogHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
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
public class DashboardServlet extends HttpServlet {

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
        String role = (String) session.getAttribute("role");

        if (!isAuthenticated) {
            request.setAttribute("status", "401");
            request.setAttribute("message", "Unauthorized, please login to proceed with payment!");

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (!role.equalsIgnoreCase("admin")) {
            request.setAttribute("status", "401");
            request.setAttribute("message", "Unauthorized, you do not have admin rights!");

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            return;
        }

        String page = request.getParameter("page");

        Integer pageNb = 1;
        if (page != null) {
            pageNb = Integer.parseInt(page);
        }
        Integer rowPerPage = 10;

        List<LogDTO> logs = LogHelper.readLogs();
        Integer pageCount = (logs.size() + rowPerPage - 1) / rowPerPage;
        Integer skip = rowPerPage * (pageNb - 1);
                

        request.setAttribute("logs", logs.stream().skip(skip).limit(rowPerPage).collect(Collectors.toList()));
        request.setAttribute("pages", pageCount);
        request.setAttribute("current", pageNb);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp");
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
