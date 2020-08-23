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
                    <button onclick="createOrder('Cash')" class="btn btn-success shadow ml-5 p-3">Pay by recipient</button>
                </div>
            </section>
        </div>

    </section>
</t:layout>
<script src="https://www.paypalobjects.com/api/checkout.js"></script>

<script type="text/javascript">
                        function checkValidationsGoToNext() {
                            let nextBtn = document.querySelector("#example-basic > div.actions.clearfix > ul > li:nth-child(2) > a");
                            nextBtn.click();
                        }
                        ;

                        let form = $("#example-basic");
                        form.steps({
                            headerTag: "h3",
                            bodyTag: "section",
                            autoFocus: true
                        });


                        function createOrder(payType) {
                            let firstname = document.getElementById("firstname").value;
                            let lastname = document.getElementById("lastname").value;
                            let address = document.getElementById("address").value;
                            let city = document.getElementById("city").value;
                            let zip = document.getElementById("zip").value;
                            let phone = document.getElementById("phone").value;


                            let addressData = {
                                firstname,
                                lastname,
                                address,
                                city,
                                zip,
                                phone
                            }

                            let data = {
                                address: addressData,
                                paymentType: payType
                            };

                            axios.post('payment', data).then(response => {

                                if (response.status === 200) {
                                    console.log(response)
                                    sessionStorage.setItem("status", 200);
                                    sessionStorage.setItem("message", "Order succesfully created");

                                    window.location.href = 'https://smartphoneshop.azurewebsites.net/app/order-history';
                                } else if (response.status === 503) {
                                    sessionStorage.setItem("status", 500);
                                    sessionStorage.setItem("message", "Order could not be created, please contact support");
                                    window.location.reload();
                                }
                            }).catch(error => {
                                Notiflix.Notify.Failure(error);
                            });
                        }



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