<%-- 
    Document   : orders
    Created on : Aug 18, 2020, 9:26:07 PM
    Author     : Kris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<link rel="stylesheet" href="css/product-overview.css" type="text/css">
<t:layout>
    <section class="container mt-5">
        <h3 class="text-center"> 
            ${fn:toUpperCase("Order history")}
        </h3>
        <hr />

    </section>
</t:layout>

