<%-- 
    Document   : index
    Created on : Aug 13, 2020, 10:46:51 AM
    Author     : Kris
--%>

<%@page import="java.util.List"%>
<%@page import="com.krispeklaric.javaeewebshop.models.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java web shop</title>
    </head>
    <body>
    <td>${ requestScope.cat1}</td> 
        <h1>Hello World! ${requestScope.categories}</h1>


    <%
        int i = 1;
        List<Category> list = (List) request.getAttribute("categories");
    %> 

    <%
        for (Category u : list) {
    %> 
    <tr> 
        <td><%=i++%></td> 
        <td><%=u.getName()%></td> 
    </tr> 
    <%
        }
    %> 
    <div>
        <h2>Pozdrav</h2>
        <jsp:useBean id="cat1" class="com.krispeklaric.javaeewebshop.models.Category" scope="request" />
        <jsp:getProperty name="cat1" property="name" />
    </div>
</body>
</html>
