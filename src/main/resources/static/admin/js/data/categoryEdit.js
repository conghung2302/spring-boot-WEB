function loadOptions() { 
    console.log("Load category")
    loadCategories();

    $('#categorySelect').change(function () {
        var categoryId = $(this).val();
        if (categoryId !== '') {
            loadBrands(categoryId);
        } else {
            $('#brandSelect').empty();
            $('#brandSelect').append('<option value="">Select Brand</option>');
        }
    });
};

function loadCategories() {
    $.ajax({
        url: 'http://localhost:8080/api/category/getAll', // Replace with your endpoint to fetch country data
        type: 'GET',
        success: function (data) {
            $('#categorySelect').empty();
            $('#categorySelect').append("<option value=''>Select category</option>");
            $.each(data, function (index, category) {
                $('#categorySelect').append('<option value="' + category.id + '">' + category.name + '</option>');
            });
        },
        error: function () {
            console.log('Error loading countries');
        }
    });
}

function loadBrands(categoryId) {
    $.ajax({
        url: 'http://localhost:8080/api/category/getOne/' + categoryId, // Replace with your endpoint to fetch city data based on country
        type: 'GET',
        success: function (data) {
            $('#brandSelect').empty();
            $('#brandSelect').append('<option value="">Select Brand</option>');
            $.each(data.brandSet, function (index, brand) {
                $('#brandSelect').append('<option value="' + brand.id + '">' + brand.name + '</option>');
            });
        },
        error: function () {
            console.log('Error loading cities');
        }
    });
}

