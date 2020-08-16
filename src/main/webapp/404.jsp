<%-- 
    Document   : 404
    Created on : Aug 16, 2020, 4:34:28 PM
    Author     : Kris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" href="css/index.css" type="text/css">
<t:layout>

    <div class="container jumbotron mt-5 d-flex flex-column justify-content-center align-items-center">
        <h1 class=" font-weight-bold mr-3">404<span class="font-weight-light ml-4">Page not found</span></h1>
        <a href="javascript:history.back()">Go Back to Previous page</a>
    </div>

</t:layout>
