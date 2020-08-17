<%-- 
    Document   : header
    Created on : Aug 14, 2020, 8:29:41 AM
    Author     : pekla
--%>

<%@tag description="header" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
    #tooltip {
        background-color: #fff;
        padding: 5px 10px;
        border-radius: 4px;
        border: 1px solid grey;
        width: 380px;
        height: 230px;
    }
    #tooltip {
        display: none;
    }

    #tooltip[data-show] {
        display: block;
    }
</style>

<header class="header d-flex align-items-center shadow sticky-top">
    <div class="header-logo d-flex ml-5 mr-auto">
        <%@include file="../../assets/mobile.svg" %>
        <a href="index.jsp"><h1 class="ml-3">MOBILE 4U</h1></a>
    </div>
    <c:choose>
        <c:when test="${isAuthenticated == true}">
            <div class="d-flex justify-content-center align-items-center mr-4">
                <span class="text-white">welcome ${user.getUsername()}, 
                    <a href="login?logout=true" class="text-primary mx-2" href="login.jsp">logout</a>
                </span>
            </div>
        </c:when>    
        <c:otherwise>
            <a class="mr-4" href="login.jsp">login</a>
            <a class="mr-5" href="register.jsp">register</a>
        </c:otherwise>
    </c:choose>

    <div id="tooltip" class="shadow p-3" role="tooltip">
        <div class="container">
            <h4 class="text-nowrap text-center ">SHOPPING CART</h4>
            <hr/>
            <div class="d-flex flex-row justify-content-end align-items-center mb-3 mr-5">
                <h6 class="my-auto font-weight-normal">Number of items:</h6>
                <p class="mx-3 my-auto font-weight-bold">${cart.getNumberOfItems()}</p>
            </div>
            <div class="d-flex flex-row justify-content-end align-items-center mr-5">
                <h6 class="my-auto font-weight-normal">Total price:</h6>
                <p class="mx-3 my-auto font-weight-bold">${cart.calculateTotalPrice()} <span class="font-weight-bold">$</span></p>
            </div>
            <hr/>

            <div class="d-flex flex-row justify-content-end align-items-center ">
                <form action="cart.jsp">
                    <button type="submit" class="btn btn-dark text-center">Go to checkout page</button>
                </form>
            </div>
        </div>
    </div>


    <div id="headercart" aria-describedby="tooltip" class="header-cart hvr-float">

        <div class="cart p-1 mr-4">

            <img  src="./assets/cart.png" />
            <div class="cart-notification">
                <span>${cart.getNumberOfItems()}</span>
            </div>
        </div>

    </div>

    <script>
        const button = document.querySelector('#headercart');
        const tooltip = document.querySelector('#tooltip');

        // Pass the button, the tooltip, and some options, and Popper will do the
        // magic positioning for you:
        Popper.createPopper(button, tooltip, {
            placement: 'bottom',
            modifiers: [
                {
                    name: 'offset',
                    options: {
                        offset: [-380, 0]
                    }
                }
            ]
        });
        function show() {
            tooltip.setAttribute('data-show', '');
        }

        function hide() {
            tooltip.removeAttribute('data-show');
        }

        let menuToggle = false;
        button.addEventListener('click', function () {
            if (!menuToggle) {
                menuToggle = !menuToggle;
                show();
            } else {
                menuToggle = !menuToggle;
                hide();
            }
        });
    </script>

</header>