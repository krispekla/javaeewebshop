<%-- 
    Document   : header
    Created on : Aug 14, 2020, 8:29:41 AM
    Author     : pekla
--%>

<%@tag description="header" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<header class="header d-flex align-items-center shadow sticky-top">
    <div class="header-logo d-flex ml-5 mr-auto">
        <%@include file="../../assets/mobile.svg" %>
        <a href="index.jsp"><h1 class="ml-3">MOBILE 4U</h1></a>
    </div>
    <c:choose>
        <c:when test="${isAuthenticated == true}">

        </c:when>    
        <c:otherwise>
            <a class="mr-4" href="login.jsp">login</a>
            <a class="mr-5" href="register.jsp">register</a>
        </c:otherwise>
    </c:choose>
    <div class="header-cart hvr-float">
        <div class="cart p-1 mr-4">

            <img  src="./assets/cart.png" />
            <div class="cart-notification">
                <span>${cart.getNumberOfItems()}</span>
            </div>
        </div>
    </div>
</header>