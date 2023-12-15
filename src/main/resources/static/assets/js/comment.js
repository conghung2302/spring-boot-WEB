$(document).ready(function () {
    console.log('Add to cart')
    const product = document.getElementById('idPro');
    const colorSelect = document.getElementById('color');
    const quantityInput = document.getElementById('quantity');
    const addToCartBtn = document.getElementById('addToCartBtn');


    addToCartBtn.addEventListener('click', function () {

        const color = colorSelect.value;
        const qty = quantityInput.value;
        const id = product.value;
        var value = sessionStorage.getItem('email');
        console.log("Email: " + value);

        $.ajax({
            url: "/addToCart",
            type: "POST",
            data: { id: id, color: color, qty: qty },
            success: function (response) {
                resetCart(response);
                console.log("Added to cart")
            },
            error: function (xhr, status, error) {
                console.log(xhr.message);
            }
        });
    });
});
