<%-- 
    Document   : layout
    Created on : Aug 14, 2020, 8:27:27 AM
    Author     : pekla
--%>

<%@tag description="page layout" pageEncoding="UTF-8"%>
<%@attribute name="message"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Java web shop</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="./css/main.css" /> 
        <link rel="icon" href="./assets/favicon.ico" type="image/x-icon" />   
        <link rel="stylesheet" href="./js/Notiflix-2.4.0/dist/notiflix-2.4.0.min.css" />
    </head>
    <body class="app" onload="document.body.className += ' loaded';" class="fadein">
        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
        <script src="./js/Notiflix-2.4.0/dist/notiflix-2.4.0.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/@popperjs/core@2"></script>
        <script  type="text/javascript" src="./js/script.js" ></script>
        <t:header />
        <t:sidebar />
        <div class="content">
            <jsp:doBody/>
        </div>
        <t:footer />
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>