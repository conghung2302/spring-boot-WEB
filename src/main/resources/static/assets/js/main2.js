/*global jQuery */
(function ($) {
	"use strict";

	var $window = $(window);
	$window.on('scroll', function () {
		// Sticky menu 
		var scroll = $window.scrollTop();
		if (scroll < 300) {
			$(".sticky").removeClass("is-sticky");
		} else {
			$(".sticky").addClass("is-sticky");
		}

		// Scroll To Top
		if ($(this).scrollTop() > 600) {
			$('.scroll-top').removeClass('not-visible');
		} else {
			$('.scroll-top').addClass('not-visible');
		}
	});

	// slide effect dropdown
	function dropdownAnimation() {
		$('.dropdown').on('show.bs.dropdown', function (e) {
			$(this).find('.dropdown-menu').first().stop(true, true).slideDown(500);
		});

		$('.dropdown').on('hide.bs.dropdown', function (e) {
			$(this).find('.dropdown-menu').first().stop(true, true).slideUp(500);
		});
	}
	dropdownAnimation();



	// mini cart toggler
	$(".mini-cart-btn").on("click", function (event) {
		event.stopPropagation();
		event.preventDefault();
		window.location.href = "/cart";
		$(".cart-list").slideToggle();
	});

	// responsive menu js
	jQuery('#mobile-menu').meanmenu({
		meanMenuContainer: '.mobile-menu',
		meanScreenWidth: "991"
	});

	// tooltip active js
	$('[data-toggle="tooltip"]').tooltip();

	//  Category Menu
	/*-- Variables --*/
	var categoryToggleWrap = $('.category-toggle-wrap');
	var categoryToggle = $('.category-toggle');
	var categoryMenu = $('.category-menu');

	/*-- Category Menu Toggles --*/
	function categorySubMenuToggle() {
		var screenSize = $window.width();
		if (screenSize <= 991) {
			$('.category-menu .menu-item-has-children > a').prepend('<span class="expand menu-expand"></span>');
			$('.category-menu .menu-item-has-children ul').slideUp();
		} else {
			$('.category-menu .menu-item-has-children > a .menu-expand').remove();
			$('.category-menu .menu-item-has-children ul').slideDown();
		}
	}

	$(window).on({
		load: function () {
			categorySubMenuToggle();
		},
		resize: function () {
			categorySubMenuToggle();
		}
	});

	categoryToggle.on('click', function () {
		categoryMenu.slideToggle();
	});

	// Category Sub Menu
	$('.category-menu').on('click', 'li a, li a .menu-expand', function (e) {
		var $a = $(this).hasClass('menu-expand') ? $(this).parent() : $(this);
		if ($a.parent().hasClass('menu-item-has-children')) {
			if ($a.attr('href') === '#' || $(this).hasClass('menu-expand')) {
				if ($a.siblings('ul:visible').length > 0) $a.siblings('ul').slideUp();
				else {
					$(this).parents('li').siblings('li').find('ul:visible').slideUp();
					$a.siblings('ul').slideDown();
				}
			}
		}
		if ($(this).hasClass('menu-expand') || $a.attr('href') === '#') {
			e.preventDefault();
			return false;
		}
	});

	// Hero main slider active js
	$('.hero-slider-active').slick({
		autoplay: false,
		infinite: true,
		fade: true,
		dots: true,
		arrows: false,
		prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
		nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
		responsive: [
			{
				breakpoint: 768,
				settings: {
					arrows: false,
				}
			},
			{
				breakpoint: 480,
				settings: {
					dots: false,
				}
			},
		]
	});

	// deal carousel active js
	$('.deals-carousel-active').slick({
		autoplay: false,
		infinite: true,
		fade: false,
		dots: false,
		arrows: true,
		prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
		nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
		appendArrows: ".slick-append",
		responsive: [{
			breakpoint: 992,
			settings: {
				slidesToShow: 2,
			}
		},
		{
			breakpoint: 480,
			settings: {
				slidesToShow: 1,
			}
		},
		]
	});

	// deal carousel active js
	$('.deals-carousel-active2').each(function () {
		var $this = $(this);
		var $arrowContainer = $(this).siblings('.section-title-2').find('.category-append');
		var $row = $this.attr("data-row") ? parseInt($this.attr("data-row"), 10) : 1;
		$this.slick({
			infinite: true,
			arrows: true,
			dots: false,
			slidesToShow: 2,
			slidesToScroll: 1,
			rows: $row,
			prevArrow: '<button class="slick-prev"><i class="fa fa-angle-left"></i></button>',
			nextArrow: '<button class="slick-next"><i class="fa fa-angle-right"></i></button>',
			appendArrows: $arrowContainer,
			responsive: [{
				breakpoint: 480,
				settings: {
					slidesToShow: 1,
				}
			},]
		});
	});

	// blog carousel active js
	$('.blog-carousel-active').each(function () {
		var $this = $(this);
		var $arrowContainer = $(this).siblings('.section-title-2').find('.category-append');
		var $row = $this.attr("data-row") ? parseInt($this.attr("data-row"), 10) : 1;
		$this.slick({
			infinite: true,
			arrows: true,
			dots: false,
			slidesToShow: 1,
			slidesToScroll: 1,
			rows: $row,
			prevArrow: '<button class="slick-prev"><i class="fa fa-angle-left"></i></button>',
			nextArrow: '<button class="slick-next"><i class="fa fa-angle-right"></i></button>',
			appendArrows: $arrowContainer
		});
	});

	// category Carousel For 3 row
	$('.category-carousel-active').each(function () {
		var $this = $(this);
		var $arrowContainer = $(this).siblings('.section-title-2').find('.category-append');
		var $row = $this.attr("data-row") ? parseInt($this.attr("data-row"), 10) : 1;
		$this.slick({
			infinite: true,
			arrows: true,
			dots: false,
			slidesToShow: 1,
			slidesToScroll: 1,
			rows: $row,
			prevArrow: '<button class="slick-prev"><i class="fa fa-angle-left"></i></button>',
			nextArrow: '<button class="slick-next"><i class="fa fa-angle-right"></i></button>',
			appendArrows: $arrowContainer,
			responsive: [{
				breakpoint: 992,
				settings: {
					slidesToShow: 2,
					rows: 3,
				}
			},
			{
				breakpoint: 576,
				settings: {
					slidesToShow: 1,
					rows: 3,
				}
			},
			]
		});
	});

	// featured category carousel active js
	$('.featured-carousel-active').slick({
		autoplay: false,
		infinite: true,
		fade: false,
		dots: false,
		arrows: true,
		prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
		nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
		slidesToShow: 4,
		responsive: [{
			breakpoint: 1200,
			settings: {
				slidesToShow: 3,
			}
		},
		{
			breakpoint: 768,
			settings: {
				slidesToShow: 2,
			}
		},
		{
			breakpoint: 480,
			settings: {
				slidesToShow: 1,
				arrows: false,
			}
		},
		]
	});

	// featured category carousel for 2 rows active js
	$('.featured-carousel-active2').each(function () {
		var $this = $(this);
		var $row = $this.attr("data-row") ? parseInt($this.attr("data-row"), 10) : 1;
		$this.slick({
			infinite: true,
			arrows: true,
			dots: false,
			slidesToShow: 4,
			slidesToScroll: 1,
			rows: $row,
			prevArrow: '<button class="slick-prev"><i class="fa fa-angle-left"></i></button>',
			nextArrow: '<button class="slick-next"><i class="fa fa-angle-right"></i></button>',
			responsive: [{
				breakpoint: 1200,
				settings: {
					slidesToShow: 3,
				}
			},
			{
				breakpoint: 768,
				settings: {
					slidesToShow: 2,
				}
			},
			{
				breakpoint: 480,
				settings: {
					slidesToShow: 1,
					arrows: false,
				}
			},
			]
		});
	});

	// latest product carousel active js
	$('.latest-product-active').slick({
		autoplay: false,
		infinite: true,
		fade: false,
		dots: false,
		arrows: true,
		prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
		nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
		slidesToShow: 5,
		responsive: [{
			breakpoint: 992,
			settings: {
				slidesToShow: 3,
			}
		},
		{
			breakpoint: 768,
			settings: {
				slidesToShow: 2,
			}
		},
		{
			breakpoint: 480,
			settings: {
				slidesToShow: 1,
			}
		},
		]
	});

	// testimonial carousel active js
	$('.testimonial-carousel-active').slick({
		autoplay: false,
		infinite: true,
		fade: false,
		dots: true,
		arrows: false,
		slidesToShow: 1
	});

	// brand slider active js
	var brand = $('.brand-active');
	brand.slick({
		infinite: true,
		arrows: true,
		autoplay: true,
		speed: 1000,
		pauseOnFocus: false,
		pauseOnHover: false,
		slidesToShow: 5,
		prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
		nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
		responsive: [{
			breakpoint: 992,
			settings: {
				slidesToShow: 4,
			}
		},
		{
			breakpoint: 768,
			settings: {
				slidesToShow: 3,
				arrows: false,
			}
		},
		{
			breakpoint: 575,
			settings: {
				slidesToShow: 2,
				arrows: false,
			}
		},
		{
			breakpoint: 479,
			settings: {
				slidesToShow: 1,
				arrows: false,
			}
		},
		]
	});

	// latest blog carousel active js
	$('.blog-carousel-active2').slick({
		autoplay: false,
		infinite: true,
		fade: false,
		dots: false,
		arrows: true,
		prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
		nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
		slidesToShow: 4,
		responsive: [{
			breakpoint: 991,
			settings: {
				slidesToShow: 3,
			}
		},
		{
			breakpoint: 768,
			settings: {
				slidesToShow: 2,
			}
		},
		{
			breakpoint: 480,
			settings: {
				slidesToShow: 1,
			}
		},
		]
	});

	// blog carousel active js
	$('.blog-carousel-active3').each(function () {
		var $this = $(this);
		var $arrowContainer = $(this).siblings('.section-title-2').find('.category-append');
		var $row = $this.attr("data-row") ? parseInt($this.attr("data-row"), 10) : 1;
		$this.slick({
			infinite: true,
			arrows: true,
			dots: false,
			slidesToShow: 2,
			slidesToScroll: 1,
			rows: $row,
			prevArrow: '<button class="slick-prev"><i class="fa fa-angle-left"></i></button>',
			nextArrow: '<button class="slick-next"><i class="fa fa-angle-right"></i></button>',
			appendArrows: $arrowContainer,
			responsive: [{
				breakpoint: 480,
				settings: {
					slidesToShow: 1,
				}
			},]
		});
	});

	// prodct details slider active
	$('.product-large-slider').slick({
		slidesToShow: 1,
		slidesToScroll: 1,
		fade: true,
		arrows: true,
		asNavFor: '.pro-nav',
		prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
		nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
	});

	// product details slider nav active
	$('.pro-nav').slick({
		slidesToShow: 4,
		slidesToScroll: 1,
		asNavFor: '.product-large-slider',
		centerMode: true,
		arrows: true,
		centerPadding: 0,
		focusOnSelect: true,
		prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
		nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>'
	});

	// prodct details slider active
	$('.product-box-slider').slick({
		autoplay: false,
		infinite: true,
		fade: false,
		dots: false,
		arrows: true,
		prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
		nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
		slidesToShow: 3,
		responsive: [{
			breakpoint: 768,
			settings: {
				slidesToShow: 2,
			}
		},
		{
			breakpoint: 480,
			settings: {
				slidesToShow: 1,
			}
		},
		]
	});

	// blog gallery slider
	var gallery = $('.blog-gallery-slider');
	gallery.slick({
		arrows: true,
		autoplay: true,
		autoplaySpeed: 5000,
		pauseOnFocus: false,
		pauseOnHover: false,
		fade: true,
		dots: false,
		infinite: true,
		slidesToShow: 1,
		prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
		nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>'
	});

	// image zoom effect
	$('.img-zoom').zoom();

	$(document).ready(function () {
		$('.header-mini-cart').on('click', function () {
			console.log('header-mini-cart')
			window.location.href = '/cart';
		});
	});

	// nice select active js
	$('select').niceSelect();

	// modal fix
	$('.modal').on('shown.bs.modal', function (e) {
		e.preventDefault();
		$('.pro-nav').resize();
	});

	// pricing filter
	var rangeSlider = $(".price-range"),
		amount = $("#amount"),
		minPrice = rangeSlider.data('min'),
		maxPrice = rangeSlider.data('max');
	rangeSlider.slider({
		range: true,
		min: minPrice,
		max: maxPrice,
		values: [minPrice, maxPrice],
		slide: function (event, ui) {
			amount.val("$" + ui.values[0] + " - $" + ui.values[1]);
		}
	});
	amount.val(" $" + rangeSlider.slider("values", 0) +
		" - $" + rangeSlider.slider("values", 1));

	// product view mode change js
	$('.product-view-mode').on('click', 'a', function (e) {
		e.preventDefault();
		var shopProductWrap = $('.shop-product-wrap');
		var viewMode = $(this).data('target');
		$('.product-view-mode a').removeClass('active');
		$(this).addClass('active');
		shopProductWrap.removeClass('grid list').addClass(viewMode);
	});

	// Checkout Page accordion
	$("#create_pwd").on("change", function () {
		$(".account-create").slideToggle("100");
	});

	$("#ship_to_different").on("change", function () {
		$(".ship-to-different").slideToggle("100");
	});

	// Payment Method Accordion
	$('input[name="paymentmethod"]').on('click', function () {
		var $value = $(this).attr('value');
		$('.payment-method-details').slideUp();
		$('[data-method="' + $value + '"]').slideDown();
	});

	// scroll to top
	$('body').on('click', '.scroll-top', function (e) {
		e.preventDefault();
		$('html,body').animate({
			scrollTop: 0
		}, 1000);
	});

	// Mailchimp for dynamic newsletter
	$('#mc-form').ajaxChimp({
		language: 'en',
		callback: mailChimpResponse,
		// ADD YOUR MAILCHIMP URL BELOW HERE!
		url: 'https://company.us19.list-manage.com/subscribe/post?u=2f2631cacbe4767192d339ef2&amp;id=24db23e68a'

	});

	// mailchimp active js
	function mailChimpResponse(resp) {
		if (resp.result === 'success') {
			$('.mailchimp-success').html('' + resp.msg).fadeIn(900);
			$('.mailchimp-error').fadeOut(400);

		} else if (resp.result === 'error') {
			$('.mailchimp-error').html('' + resp.msg).fadeIn(900);
		}
	}

	// google map
	var map_id = $('#map_content');
	if (map_id.length > 0) {
		var $lat = map_id.data('lat'),
			$lng = map_id.data('lng'),
			$zoom = map_id.data('zoom'),
			$maptitle = map_id.data('maptitle'),
			$mapaddress = map_id.data('mapaddress'),
			mymap = L.map('map_content').setView([$lat, $lng], $zoom);

		L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
			attribution: 'Map',
			maxZoom: 18,
			id: 'mapbox.streets',
			scrollWheelZoom: false,
			accessToken: 'pk.eyJ1Ijoic2hha2lsYWhtbWVlZCIsImEiOiJjamk4anF6NDgwMGd5M3BwM2c4eHU5dmIzIn0.yBLGUAB8kV1I1yGGonxzzg'
		}).addTo(mymap);

		var marker = L.marker([$lat, $lng]).addTo(mymap);
		marker.bindPopup('<b>' + $maptitle + '</b><br>' + $mapaddress).openPopup();
		mymap.scrollWheelZoom.disable();
	}


	// Login
	$(document).ready(function () {
		$('#signupBtn').click(function () {
			// Lấy giá trị từ trường input
			var name_ = $('#name').val();
			var email_ = $('#email').val();
			var address_ = $('#address').val();
			var phone_ = $('#phone').val();
			var password_ = $('#password').val();
			var cpassword_ = $('#cpassword').val();

			console.log(name_ + " " + email_ + " " + password_ + " " + cpassword_)
			$.ajax({
				url: '/api/signup',
				method: 'POST',
				data: JSON.stringify({
					name: name_,
					email: email_,
					address: address_,
					phone: phone_,
					password: password_,
					cpassword: cpassword_
				}),
				headers: {
					'Accept': 'application/json',
					'Content-Type': 'application/json'
				},
				success: function () {
					alert("Dang Ky thanh cong")
				},
				error: function (xhr, status, error) {
					alert(xhr.responseText);
				}
			});
		});
	});

	$(document).ready(function () {
		$('#loginBtn').click(function () {
			// Lấy giá trị từ trường input
			var email_ = $('#email2').val();
			var password_ = $('#password2').val();

			$.ajax({
				url: '/api/login',
				method: 'POST',
				data: JSON.stringify({
					email: email_,
					password: password_,
				}),
				headers: {
					'Accept': 'application/json',
					'Content-Type': 'application/json'
				},
				success: function () {
					window.location.href = '/';
					alert("Dang nhap thanh cong")
				},
				error: function (xhr, status, error) {
					alert(xhr.responseText);
				}
			});
		});
	});



	function updateCart(id_, qty_) {
		$.ajax({
			url: 'editProductcart',
			method: 'POST',
			data: {
				id: id_,
				qty: qty_,
			},
			success: function (response) {
				resetCart(response);
				console.log("updated");
			},
			error: function (xhr, status, error) {
			}
		});
	}

	// quantity change js
	var proQty = $('.pro-qty');
	proQty.prepend('<span class="dec qtybtn">-</span>');
	proQty.append('<span class="inc qtybtn">+</span>');
	proQty.on('click', '.qtybtn', function () {
		var $button = $(this);
		var oldValue = $button.parent().find('input').val();

		var id = $button.parent().find('input').attr('title');
		console.log(id);
		if ($button.hasClass('inc')) {
			var newVal = parseFloat(oldValue) + 1;
			updateCart(id, newVal);
		} else {
			// Don't allow decrementing below zero
			if (oldValue > 0) {
				var newVal = parseFloat(oldValue) - 1;
				updateCart(id, newVal);
			} else {
				newVal = 0;
			}
		}
		$button.parent().find('input').val(newVal);
	});


	function resetCart(response) {
		console.log(response);
		var total = 0;
		response.forEach(function (obj) {
			total += obj.product.price * obj.qty;
		});

		console.log(total);

		$('#totalCart').text('$' + total);
		$('.cart-total-price').html('<span>total</span>' + '$' + total);
		$('.cart-notification').text(response.length);
		if (total > 0) {
			$('.total-amount').text('$' + (total + 70));
		} else {
			$('.total-amount').text('$' + 0);
		}
	}

	// remove product from cart
	$(document).ready(function () {
		$('#cartTable').on('click', '#remove', function () {
			var id = $(this).attr('title');
			console.log("title: " + id);
			var tag = $(this).closest('tr');

			$.ajax({
				url: 'remove-product-cart',
				method: 'POST',
				data: {
					id: id
				},
				success: function (response) {
					resetCart(response);
					tag.remove();
				},
				error: function (xhr, status, error) {
					alert(xhr.responseText);
				}
			});

		});
	});

	$(document).ready(function () {
		const txtSearch = document.getElementById('search');
		const btn = document.getElementById('btnSearch')

		btn.addEventListener('click', function () {
			console.log(txtSearch.value);
			$.ajax({
				url: "/search",
				type: "POST",
				data: { p: txtSearch},
				success: function (response) {
					console.log("Added to cart")
				},
				error: function (xhr, status, error) {
					console.log(xhr.message);
				}
			});
		})
		
});

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
		// if (value == null) {
		// 	window.location.href = "/login";
		// }
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


$(document).ready(function () {

	// const product = document.getElementById('idPro');
	// const colorSelect = document.getElementById('color');
	// const quantityInput = document.getElementById('quantity');

	const order = document.getElementById('orderBtn');


	order.addEventListener('click', function () {

		const email_ = document.getElementById('email').value;
		const address_ = document.getElementById('street-address').value;
		const phone_ = document.getElementById('phone').value;

		$.ajax({
			url: "/saveOrderCart",
			type: "POST",
			data: { email: email_, address: address_, phone: phone_ },

			success: function (response) {
				alert("thanh cong");
			},
			error: function () {
				alert("Them that bai");
			}
		});
	});
});


}(jQuery));