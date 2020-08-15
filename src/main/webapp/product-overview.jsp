<%-- 
    Document   : product-overview
    Created on : Aug 14, 2020, 4:31:39 PM
    Author     : pekla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" href="css/product-overview.css" type="text/css">
<t:layout>
    <section class="container mt-5">
        <h3> 
            ${fn:toUpperCase(fn:substring(param.category, 0, 1))}${fn:toLowerCase(fn:substring(param.category, 1,fn:length(param.category)))}
        </h3>
        <hr />
        <div class="d-flex flex-wrap">

            <c:forEach items="${products}" var="product">

                <div class="product-item my-3">

                    <div class="product-item-wrapper hvr-float hvr-float shadow">
                        <h4 class="text-nowrap">${fn:toUpperCase(product.getName())}</h4>
                        <img src="${product.getImgUrl()}" />
                        <div class="product-item-commands">

                            <div class="d-flex flex-row justify-content-center align-items-center mb-3">
                                <h6 class="my-auto">Price:</h6>
                                <p class="mx-3 my-auto font-weight-light">${product.getPrice()}$</p>
                            </div>
                            <div class="d-flex flex-row justify-content-center align-items-center mb-3">
                                <button class="btn btn-light" onclick="productCountHandler('${product.getManufacturer()}_${product.getId_product()}', false)">-</button>
                                <span id="${product.getManufacturer()}_${product.getId_product()}" class="mx-3"></span>
                                <button  class="btn btn-light" onclick="productCountHandler('${product.getManufacturer()}_${product.getId_product()}')">+</button>
                            </div>
                            <div class="d-flex flex-row justify-content-around mt-3 ">
                                <button class="btn btn-light">details</button>
                                <button class="btn btn-dark text-center" onclick="addToCart('${product.getManufacturer()}_${product.getId_product()}',${product.getId_product()})">Add to cart</button>
                            </div>
                        </div>
                    </div>
                </div>
                <script type="text/javascript">
                    document.getElementById('${product.getManufacturer()}_${product.getId_product()}').innerHTML = 1;
                </script>
            </c:forEach>
        </div>
    </section>
</t:layout>

