<%-- 
    Document   : login
    Created on : Aug 14, 2020, 1:39:59 PM
    Author     : pekla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="css/login.css" type="text/css">

<t:layout>
    <div class="login container card bg-light p-3 shadow">
        <form action="login" method="POST" class="p-3 d-flex flex-column">
            <h2 class="text-center mb-3">Login</h2>

            <div class="form-group">
                <label for="username">Username <span class="text-danger">*</span></label>
                <input name="username" type="text" class="form-control" id="username" autofocus aria-describedby="emailHelp" placeholder="Enter username" required>
            </div>
            <div class="form-group">
                <label for="password">Password <span class="text-danger">*</span></label>
                <input name="password" type="password" class="form-control" id="password" placeholder="Password" required>
            </div>
            <c:if test="${not empty invalidLogin}">
                <large id="emailHelp" class="form-text text-danger">${invalidLogin}</large>
                </c:if>
            <button type="submit" class="btn btn-dark  mx-auto mt-4 px-5">Login</button>
        </form>
    </div>

</t:layout>

