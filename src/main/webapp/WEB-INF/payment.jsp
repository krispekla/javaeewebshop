<%-- 
    Document   : payment
    Created on : Aug 19, 2020, 12:10:07 PM
    Author     : Kris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script  type="text/javascript" src="https://www.paypal.com/sdk/js?client-id=ASxvnDiHmzsuRa3KRR3ZLaYJmf0tWdhPcaaOZ4GFtL69j5Xi9aA3c-4pDwtHHbr7qac7Xg9o3Vha4Vog" ></script>
<link rel="stylesheet" href="css/jquery.steps.css" type="text/css">

<t:layout>
    <section class="container mt-5">
        <h3 class="text-center"> 
            ${fn:toUpperCase("Payment")}
        </h3>
        <hr />


        <div id="example-basic" class="mb-5">
            <h3>Shipping address</h3>
            <section>
                <div class="container">

                    <h4 class="p-4">Delivery informations:</h4>
                    <form onsubmit="event.preventDefault(); checkValidationsGoToNext();" id="payment" action="" class="p-4">
                        <div class="row">

                            <div class="form-group col-4">
                                <label for="firstname">First Name <span class="text-danger">*</span></label>
                                <input id="firstname" name="firstname" type="text" required>
                            </div>
                            <div class="form-group">
                                <label for="lastname">Last Name <span class="text-danger">*</span></label>
                                <input id="lastname" name="lastname" type="text" required>
                            </div>
                        </div>
                        <div class="row">

                            <div class="form-group col-4">
                                <label for="address">Street and House Nb.<span class="text-danger">*</span></label>
                                <input id="address" name="address" type="text" required>
                            </div>
                            <div class="form-group">
                                <label for="city">City<span class="text-danger">*</span></label>
                                <input id="city" name="city" type="text" required>
                            </div>
                        </div>
                        <div class="row">

                            <div class="form-group col-4">
                                <label for="zip">Zip code <span class="text-danger">*</span></label>
                                <input id="zip" name="zip" type="text" required>
                            </div>
                            <div class="form-group">
                                <label for="phone">Phone<span class="text-danger">*</span></label>
                                <input id="phone" name="phone" type="text" required>
                            </div>
                        </div>
                        <div class="row">
                            <button type="submit" class="btn btn-dark shadow mx-auto btn-large">Next</button>
                        </div>
                    </form>                    

                </div>

            </section>
            <h3>Payment</h3>
            <section>
                <h5 class="text-center h5 mt-3">Select type of payment and pay:</h5>
                <div class="d-flex justify-content-center align-items-center mt-5">
                    <div id="paypal-button"></div>
                    <button class="btn btn-success shadow ml-5 p-3">Pay by recipient</button>
                </div>
            </section>
        </div>

    </section>
</t:layout>
<script src="https://www.paypalobjects.com/api/checkout.js"></script>

<script>

                        function checkValidationsGoToNext(e) {
                            let nextBtn = document.querySelector("#example-basic > div.actions.clearfix > ul > li:nth-child(2) > a");
                            nextBtn.click();
                        }
                        ;

                        var form = $("#example-basic");
                        form.steps({
                            headerTag: "h3",
                            bodyTag: "section",
                            autoFocus: true
                        });

                        paypal.Button.render({
                            // Configure environment
                            env: 'sandbox',
                            client: {
                                sandbox: 'ASxvnDiHmzsuRa3KRR3ZLaYJmf0tWdhPcaaOZ4GFtL69j5Xi9aA3c-4pDwtHHbr7qac7Xg9o3Vha4Vog',
                                production: 'demo_production_client_id'
                            },
                            // Customize button (optional)
                            locale: 'en_US',
                            style: {
                                size: 'large',
                                color: 'gold',
                                shape: 'rect',
                            },

                            // Enable Pay Now checkout flow (optional)
                            commit: true,

                            // Set up a payment
                            payment: function (data, actions) {
                                return actions.payment.create({
                                    transactions: [{
                                            amount: {
                                                total: '0.01',
                                                currency: 'USD'
                                            }
                                        }]
                                });
                            },
                            // Execute the payment
                            onAuthorize: function (data, actions) {
                                return actions.payment.execute().then(function () {
                                    // Show a confirmation message to the buyer
                                    window.alert('Thank you for your purchase!');
                                });
                            }
                        }, '#paypal-button')
</script>