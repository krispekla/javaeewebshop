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
                <h5>Filters:</h5>
                <div class="p-3 d-flex justify-content-start align-items-center mb-3">
                    <label class="mr-3 my-auto" for="username">User:</label>

                    <select onchange="onFilterChange()" class="mr-5" name="username" id="username">
                        <option value="all">all</option>
                        <c:forEach items="${users}" var="us">
                            <option value="${us.getUsername()}">${us.getUsername()}</option>
                        </c:forEach>
                    </select>

                    <label class="mr-3 my-auto" for="date">Date:</label>

                    <input onchange="onFilterChange()" type="date" id="date" name="trip-start"
                           min="2020-06-21" >

                    <button onclick="clearFitlers()" type="button" class="btn btn-secondary shadow ml-3 ">clear</button>
                    <a id="orderFilterButton" href="order-history" class="btn btn-dark btn-large shadow  px-3 ml-5">Filter</a>

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
                    <c:choose>
                        <c:when test="${orders.isEmpty()}">
                            <div class="d-flex justify-content-center align-items-center mr-4">
                                <td>Did not find any records</td>
                            </div>
                        </c:when>    
                        <c:otherwise>
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
                        </c:otherwise>
                    </c:choose>
                </table>

            </c:otherwise>
        </c:choose>


        <script type="text/javascript">
            function onFilterChange() {
                let usernameSelect = document.getElementById("username");
                let username = usernameSelect.options[usernameSelect.selectedIndex].value;
                let date = document.getElementById("date");
                let filterButton = document.getElementById("orderFilterButton");
                let userFilter = "";
                let dateFilter = "";
                if (username != "all") {
                    userFilter = "username=" + username;
                } else {
                    userFilter = null;
                    filterButton.href = "order-history";
                }

                if (date.value != "") {
                    dateFilter = "date=" + date.value;
                }

                if (userFilter && dateFilter) {
                    let usernameDateFilter = "order-history?" + userFilter + "&" + dateFilter;
                    filterButton.href = usernameDateFilter;
                } else if (userFilter) {
                    let usernameOnlyFilter = "order-history?" + userFilter;
                    filterButton.href = usernameOnlyFilter;

                } else if (dateFilter) {
                    let dateOnlyFilter = "order-history?" + dateFilter;
                    filterButton.href = dateOnlyFilter;
                }
            }
            function clearFitlers() {
                let username = document.getElementById("username");
                let date = document.getElementById("date");
                let filterButton = document.getElementById("orderFilterButton");

                username.value = "all";
                date.value = ""
                filterButton.href = "order-history";
            }

            const queryString = window.location.search;
            const urlParams = new URLSearchParams(queryString);
            const paramUsername = urlParams.get('username');
            const paramDate = urlParams.get('date');


            if (paramUsername != null) {
                document.getElementById("username").value = paramUsername;
                onFilterChange();
            }

            if (paramDate != null) {
                document.getElementById("date").value = paramDate;
                onFilterChange();
            }

        </script>



    </section>
</t:layout>

