<%-- 
    Document   : cart
    Created on : Aug 15, 2020, 6:44:29 PM
    Author     : Kris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="css/cart.css" type="text/css">

<t:layout>
    <section class="container mt-5">
        <h3 class="text-center"> 
            ${fn:toUpperCase("Cart Checkout")}
        </h3>
        <hr />

        <div class="bg-white mt-5">
            <table class="table  table-hover">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Product name</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Price</th>
                        <th scope="col">Commands</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var = "nbId" scope = "page" value = "1"/>
                    <c:forEach items="${cart.getItems()}" var="item">
                        <tr>
                            <th scope="row">${nbId}</th>
                            <td>${item.getProduct().getName()}</td>
                            <td>${item.getQuantity()}</td>
                            <td>${item.getPrice()}</td>
                            <td class="d-flex mx-auto">
                                <button type="button" class="btn btn-secondary text-center mr-3" data-toggle="modal" data-target="#${item.getId_order_item()}_${item.getProduct().getId_product()}_modal">Edit</button>
                                <form action="cart?remove=true&&orderItemId=${item.getId_order_item()}" method="get">
                                    <button type="submit" class="btn btn-danger text-center">Remove</button>
                                </form>
                            </td>            

                        </tr>  
                        <c:set var = "nbId" scope = "page" value = "${nbId + 1}"/>


                        <!-- Modal -->
                    <div class="modal fade" " data-backdrop="static"  id="${item.getId_order_item()}_${item.getProduct().getId_product()}_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">${fn:toUpperCase("Edit - ")} ${fn:toUpperCase(item.getProduct().getName())}</h5>
                                    <button  type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="resetQuantity('${item.getId_order_item()}_${item.getProduct().getId_product()}_quantity', '${item.getQuantity()}')">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body cart-modal">
                                    <div class="d-flex flex-row justify-content-around align-items-center mb-3">
                                        <img src="${item.getProduct().getImgUrl()}" />

                                        <div class="d-flex flex-column justify-content-around align-items-around mb-3">
                                            <h6 class="my-3">Description:</h6>
                                            <p>${item.getProduct().getDescription()}</p> 
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row justify-content-end align-items-center mb-3">
                                        <h5 class="my-auto font-weight-semi">Price:</h5>
                                        <h5 class="mx-3 my-auto font-weight-light">${item.getProduct().getPrice()} <span class="font-weight-bold">$</span></h5>
                                    </div>
                                    <div class="d-flex flex-row justify-content-end align-items-center mb-3">
                                        <button class="btn btn-light" onclick="productCountHandler('${item.getId_order_item()}_${item.getProduct().getId_product()}_quantity', false)">-</button>
                                        <span id="${item.getId_order_item()}_${item.getProduct().getId_product()}_quantity" class="mx-3"></span>
                                        <button  class="btn btn-light" onclick="productCountHandler('${item.getId_order_item()}_${item.getProduct().getId_product()}_quantity')">+</button>

                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary shadow" data-dismiss="modal" onclick="resetQuantity('${item.getId_order_item()}_${item.getProduct().getId_product()}_quantity', '${item.getQuantity()}')">Cancel</button>
                                    <button class="btn btn-dark text-center shadow" onclick="testaddToCart()">Save</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <script type="text/javascript">
                        document.getElementById('${item.getId_order_item()}_${item.getProduct().getId_product()}_quantity').innerHTML = ${item.getQuantity()};
                    </script>
                </c:forEach>
                </tbody>
            </table>
            <div class="d-flex mt-3">
                <form class=" ml-auto" action="cart?removeAll=true" method="get">
                    <button type="submit" class="btn btn-danger btn-lg shadow text-center">Remove All</button>
                </form>
            </div>
            <div class="d-flex mt-5 p-2 mr-5  justify-content-end">
                <div class="d-flex flex-column">
                    <div class="d-flex">
                        <h4 class="font-weight-light mr-3">Total: </h4>
                        <h4> $${cart.calculateTotalPrice()}</h4>
                    </div>
                    <form class="mt-5" action="payment" method="get">
                        <button type="submit" class="btn btn-dark btn-lg shadow">Continue with payment</button>
                    </form>
                </div>
            </div>

        </div>

    </section>
</t:layout>

