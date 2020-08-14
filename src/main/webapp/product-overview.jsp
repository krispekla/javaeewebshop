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
                        <h4>
                            ${fn:toUpperCase(product.getName())}
                        </h4>
                        <img src="${product.getImgUrl()}" />
                        <div class="product-item-commands">

                            <div class="d-flex flex-row justify-content-center align-items-center mb-3">
                                <button class="btn btn-light">-</button>
                                <span class="mx-3">0</span>
                                <button class="btn btn-light">+</button>
                            </div>
                            <div class="d-flex flex-row justify-content-around mt-3 ">
                                <button class="btn btn-light">details</button>
                                <button class="btn btn-dark text-center">Add to cart</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>
</t:layout>

