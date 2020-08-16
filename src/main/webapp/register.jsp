<%-- 
    Document   : register
    Created on : Aug 14, 2020, 1:40:11 PM
    Author     : pekla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/register.css" type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

<t:layout>
    <div class="register container card bg-light p-3 shadow">
        <form action="register" method="post" class="p-3 d-flex flex-column">
            <h2 class=" mb-3 text-center">Register</h2>

            <div class="form-group">
                <label for="firstname">First Name</label>
                <input name="firstname" type="text" class="form-control" id="firstname" aria-describedby="firstnameHelp" value="${firstname}">
            </div>
            <div class="form-group">
                <label for="lastname">Last Name</label>
                <input name="lastname" type="text" class="form-control" id="lastname" aria-describedby="lastnameHelp" value="${lastname}">
            </div>
            <div class="form-group">
                <label for="username">Username <span class="text-danger">*</span></label>
                <input name="username" type="text" class="form-control" id="username" aria-describedby="usernameHelp" value="${username}" >
                <div class="invalid-feedback">
                    <c:if test="${not empty invalidUsername}">
                        <c:out value="${invalidUsername}" />
                    </c:if>
                </div>
            </div>
            <div class="form-group">
                <label for="email">Email <span class="text-danger">*</span></label>
                <input name="email" type="email" class="form-control" id="email" aria-describedby="emailHelp" value="${email}">
                <div class="invalid-feedback">
                    <c:if test="${not empty invalidEmail}">
                        <c:out value="${invalidEmail}" />
                    </c:if>
                </div>
            </div>
            <div class="form-group password-group">
                <label for="password">Password <span class="text-danger">*</span></label>
                <input name="password" type="password" class="form-control" id="password" required>
                <i onclick="passwordEyeToggle('password')" class="password-eye fas fa-eye-slash" id="display"></i>
                <div class="invalid-feedback">
                    <c:if test="${not empty invalidPassword}">
                        <c:out value="${invalidPassword}" />
                    </c:if>
                </div>
            </div>

            <button type="submit" class="btn btn-dark mx-auto mt-4 px-5">Register</button>
        </form>

    </div>
    <script type="text/javascript">
        function passwordEyeToggle(inputElementId) {
            let a = document.getElementById(inputElementId);
            if (a.type == "password") {
                a.type = "text";
            } else {
                a.type = "password";
            }
        }

        if (`${invalidUsername}` !== '') {
            let usernameElement = document.getElementById("username");
            usernameElement.classList.add("is-invalid");
        }
        if (`${invalidEmail}` !== '') {
            let emailElement = document.getElementById("email");
            emailElement.classList.add("is-invalid");
        }
        if (`${invalidPassword}` !== '') {
            let passwordElement = document.getElementById("password");
            passwordElement.classList.add("is-invalid");
        }

    </script>
</t:layout>

