$(document).ready(function () {
    $("#btnCmt").click(function () {
        console.log("Click");
        var path = window.location.pathname; // Get the path from the URL
        var pathSegments = path.split('/'); // Split the path into segments

        // Get the value of the path variable
        var idPro_ = pathSegments[2];
        console.log("idPro: " + idPro_);

        var star1 = document.querySelector('#star1');

        
        $.ajax({
            url: "/addcmt",
            type: "POST",
            data: { idPro: idPro_, cmt: $('#cmtText').val() },
            success: function (response) {
                console.log(response)
                $("#addCmt").append(
                    '<div class="total-reviews"' +
                    'id="#cmtUser">' +
                    '<div class="rev-avatar">' +
                    '<img src="assets/img/about/avatar.jpg" alt="">' +
                    '</div>' +
                    '<div class="review-box">' +
                    '<div class="ratings">' +
                    '<span class="good"><i class="fa fa-star"></i></span>' +
                    '<span class="good"><i class="fa fa-star"></i></span>' +
                    '<span class="good"><i class="fa fa-star"></i></span>' +
                    '<span class="good"><i class="fa fa-star"></i></span>' +
                    '<span><i class="fa fa-star"></i></span>' +
                    '</div>' +
                    '<div class="post-author">' +
                    '<p><span>' + 'HungKiller' + '</span> 30 Nov, 2018</p>' +
                    '</div>' +
                    '<p id="comment">' + response.comment + '</p>' +
                    '</div>' +
                    '</div>');
            },
            error: function(params) {
               window.location.href = "/login";
            }
        });

        // $("#addCmt").append(
        //     '<div class="total-reviews"' +
        //     'id="#cmtUser">' +
        //     '<div class="rev-avatar">' +
        //     '<img src="assets/img/about/avatar.jpg" alt="">' +
        //     '</div>' +
        //     '<div class="review-box">' +
        //     '<div class="ratings">' +
        //     '<span class="good"><i class="fa fa-star"></i></span>' +
        //     '<span class="good"><i class="fa fa-star"></i></span>' +
        //     '<span class="good"><i class="fa fa-star"></i></span>' +
        //     '<span class="good"><i class="fa fa-star"></i></span>' +
        //     '<span><i class="fa fa-star"></i></span>' +
        //     '</div>' +
        //     '<div class="post-author">' +
        //     '<p><span>' + 'HungKiller' + '</span> 30 Nov, 2018</p>' +
        //     '</div>' +
        //     '<p id="comment">' + "Ga" + '</p>' +
        //     '</div>' +
        //     '</div>');
    });

});