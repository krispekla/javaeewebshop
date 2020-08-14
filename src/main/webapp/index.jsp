<%-- 
    Document   : index
    Created on : Aug 13, 2020, 10:46:51 AM
    Author     : Kris
--%>

<%@page import="java.util.List"%>
<%@page import="com.krispeklaric.javaeewebshop.models.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" href="css/index.css" type="text/css">
<t:layout>

    <div class="container jumbotron mt-3">
        <h2 class="text-center font-weight-light">Find perfect mobile for you or your loved ones</h2>
    </div>
    <div class="container mx-auto mt-3">
        <h3 class="ml-2 my-3">Category</h3>
        <div class="index-categories  d-flex flex-wrap">

            <c:forEach items="${categories}" var="category">
                <div class="category-item my-3">
                    <a href="products?category=${category.getName()}">
                        
                    <div class="category-item-wrapper hvr-float hvr-float shadow">
                        <h4>
                            ${fn:toUpperCase(fn:substring(category.getName(), 0, 1))}${fn:toLowerCase(fn:substring(category.getName(), 1,fn:length(category.getName())))}
                        </h4>
                        <img src="${category.getLogoUrl()}" />
                    </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>

</t:layout>

