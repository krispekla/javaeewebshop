/* global axios */

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


function addToCart(elementId, productId) {
    let productQuantity = parseInt(document.getElementById(elementId).innerHTML);
    let data = {
        quantity: productQuantity,
        id: productId
    };
    axios.post('products', data).then(response => {
        if (response.status === 200) {
            console.log('uspjeh updateano')
            window.location.reload();
        }
    }).catch(error => console.error(error));
}
