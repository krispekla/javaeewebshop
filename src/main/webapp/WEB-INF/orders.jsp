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


        <c:choose>
            <c:when test="${role != 'admin'}">

                <table class="table  table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Order number Id</th>
                            <th scope="col">Date</th>
                            <th scope="col">Payment type</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Delivery address</th>
                            <th scope="col">Total price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var = "nbId" scope = "page" value = "1"/>
                        <c:forEach items="${orders}" var="order">
                            <tr>
                                <th scope="row">${order.getId_order()}</th>
                                <td>${order.getCreated().toLocalDate()} ${order.getCreated().getHour()}: ${order.getCreated().getMinute()}</td>
                                <td>${order.getPayment_type()}</td>
                                <td>${order.getOrderItem().size()}</td>
                                <td>${order.getAddress().getAddress()}</td>
                                <td>${order.getTotal()} <span class="font-weight-bold">$</span></td>

                            </tr>  

                        </c:forEach>
                    </tbody>
                </table>
            </c:when>    
            <c:otherwise>
                <div class="p-3 d-flex justify-content-start align-items-center mb-3">

                    <div class="dropdown mr-4">
                        <button class="btn btn-dark shadow dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Select user
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a href="order-history" class="dropdown-item  text-dark">All</a>
                            <c:forEach items="${users}" var="us">
                                <a href="order-history?username=${us.getUsername()}" class="dropdown-item  text-dark">${us.getUsername()}</a>
                            </c:forEach>
                        </div>
                    </div>

                    <label class="mr-3 my-auto" for="date">Start date:</label>

                    <input type="date" id="date" name="trip-start"
                           min="2020-08-21" >

                    <!--<a href="order-history?username=" class="dropdown-item  text-dark">All</a>-->

                </div>

                <table class="table  table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Order number Id</th>
                            <th scope="col">Username</th>
                            <th scope="col">Date</th>
                            <th scope="col">Payment type</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Delivery address</th>
                            <th scope="col">Total price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var = "nbId" scope = "page" value = "1"/>
                        <c:forEach items="${orders}" var="order">
                            <tr>
                                <th scope="row">${order.getId_order()}</th>
                                <td>${order.getUser().getUsername()}</td>
                                <td>${order.getCreated().toLocalDate()} ${order.getCreated().getHour()}: ${order.getCreated().getMinute()}</td>
                                <td>${order.getPayment_type()}</td>
                                <td>${order.getOrderItem().size()}</td>
                                <td>${order.getAddress().getAddress()}</td>
                                <td>${order.getTotal()} <span class="font-weight-bold">$</span></td>

                            </tr>  

                        </c:forEach>
                    </tbody>
                </table>

            </c:otherwise>
        </c:choose>






    </section>
</t:layout>

