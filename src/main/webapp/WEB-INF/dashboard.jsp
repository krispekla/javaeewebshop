<%-- 
    Document   : dashboard
    Created on : Aug 18, 2020, 9:36:14 PM
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
            ${fn:toUpperCase("Logging - User logins")}
        </h3>
        <hr />


        <table class="table  table-hover">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Order number Id</th>
                    <th scope="col">Username</th>
                    <th scope="col">Date</th>
                    <th scope="col">Ip address</th>
                </tr>
            </thead>
            <tbody>
                <c:set var = "nbId" scope = "page" value = "1"/>
                <c:forEach items="${logs}" var="log">
                    <tr>
                        <th scope="row">${nbId}</th>
                        <td>${log.getUsername()}</td>
                        <td>${log.getDateTime().toLocalDate()} ${log.getDateTime().getHour()}: ${log.getDateTime().getMinute()}</td>
                        <td>${log.getIpAddress()}</td>

                    </tr>  
                    <c:set var = "nbId" scope = "page" value = "${nbId + 1}"/>
                </c:forEach>
            </tbody>
        </table>

    </section>
</t:layout>

