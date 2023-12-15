
// save Product
$(document).ready(function () {
    $('#categorySelect').change(function () {
        var categoryId = $(this).val();
        if (categoryId !== '') {
            loadBrands(categoryId);
        } else {
            $('#brandSelect').empty();
            $('#brandSelect').append('<option value="">Select Brand</option>');
        }
    });
});

// Function to handle button click event
function saveData() {
    var name_ = $('#name').val();
    var price_ = $('#price').val();
    var weight_ = $('#weight').val();

    var pin_ = $('#pin').val();
    var cpu_ = $('#cpu').val();
    var ram_ = $('#ram').val();
    var os_ = $('#os').val();
    var screen_ = $('#screen').val();
    var wifi_ = $('#wifi').val();
    var ssd_ = $('#ssd').val();

    var brandId_ = $('#brandSelect').val();




    var desc_ = "NULL";

    var file = document.getElementById('file');
    var files = file.files;

    var formData = new FormData();
    for (var i = 0; i < files.length; i++) {
        formData.append('files', files[i]);
    }


    formData.append("name", name_);
    formData.append("price", price_);
    formData.append("weight", weight_);
    formData.append("description", desc_);

    formData.append("pin", pin_);
    formData.append("ram", ram_);
    formData.append("os", os_);
    formData.append("screen", screen_);
    formData.append("wifi", wifi_);
    formData.append("cpu", cpu_);
    formData.append("ssd", ssd_);
    formData.append("brandId", brandId_);

    // var selectedValues = [];
    // for (var option of document.getElementById('mySelect').options) {
    //     if (option.selected) {
    //         selectedValues.push(option.value)
    //         formData.append("colors", option.value);
    //     }
    // }

    // formData.append("color", selectedValues);
    // console.log(formData);
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://10.50.141.9:8080/api/product/saveOne');
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                window.location.href = '/Admin/product';
            } else {
                console.error(xhr.statusText);
            }
        }
    };

    xhr.send(formData);



}
$('#save').click(function () {
    saveData();
});