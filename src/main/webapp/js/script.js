/* global axios, Notiflix */

function productCountHandler(elementId, increase = true) {
    let elementValue = parseInt(document.getElementById(elementId).innerHTML);

    if ((elementValue === 1 && !increase) || (elementValue === 10 && increase))
        return;

    if (!increase) {
        elementValue--;
    } else {
        elementValue++;
    }
    document.getElementById(elementId).innerHTML = elementValue;
}

// Notiflix Notify - All Options
Notiflix.Notify.Init({position: 'right-top', width: '300px', fontSize: '17px', distance: '95px', timeout: 1800});

function addToCart(elementId, productId) {
    let productQuantity = parseInt(document.getElementById(elementId).innerHTML);
    let data = {
        quantity: productQuantity,
        id: productId
    };
    document.getElementById(elementId).innerHTML = 1;
    axios.post('products', data).then(response => {

        if (response.status === 200) {
            sessionStorage.setItem("status", 200);
            sessionStorage.setItem("message", "Succesfully added to cart");
            window.location.reload();
        }
    }).catch(error => {
        Notiflix.Notify.Failure(error);
    });
}

function resetQuantity(elementId, initialQuantity) {
    document.getElementById(elementId).value = initialQuantity;
}


let status = sessionStorage.getItem("status");
let message = sessionStorage.getItem("message");

if (status == 200) {
    Notiflix.Notify.Success(message);
}

if (status == 500) {
    Notiflix.Notify.Failure(message);
}

sessionStorage.clear();


