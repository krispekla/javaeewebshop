<%-- 
    Document   : sidebar
    Created on : Aug 14, 2020, 8:29:55 AM
    Author     : pekla
--%>

<%@tag description="sidebar" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<aside class="sidebar d-flex flex-column">
    <c:forEach items="${categories}" var="category">
        <a href="products?category=${category.getName()}">
            <div class="sidebar-item hvr-float hvr-float">
                <h4>
                    ${fn:toUpperCase(fn:substring(category.getName(), 0, 1))}${fn:toLowerCase(fn:substring(category.getName(), 1,fn:length(category.getName())))}
                </h4>
            </div>
        </a>
    </c:forEach>
</aside>