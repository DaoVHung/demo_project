<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html><html lang="en"><head>    <title>Vegefoods - Free Bootstrap 4 Template by Colorlib</title>    <meta charset="utf-8">    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"          rel="stylesheet">    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/open-iconic-bootstrap.min.css">    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/animate.css">    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/owl.carousel.min.css">    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/owl.theme.default.min.css">    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/magnific-popup.css">    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/aos.css">    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/ionicons.min.css">    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/bootstrap-datepicker.css">    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/jquery.timepicker.css">    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/flaticon.css">    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/icomoon.css">    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/style.css">    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">    <%--    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/rate.css">--%>    <style>        .py-1 {            background-color: black;        }        .bg-primary {            background-color: black;        }    </style></head><body class="goto-here"><jsp:include page="../header.jsp"/><div class="hero-wrap hero-bread"     style="background-image: url('<%=request.getContextPath()%>/View/User/images/still-life-vegetables-Avocado-zucchini-Broccoli-basil-2191895-wallhere.com.jpg');">    <div class="container">        <div class="row no-gutters slider-text align-items-center justify-content-center">            <div class="col-md-9 ftco-animate text-center">                <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Cart</span></p>                <h1 class="mb-0 bread">My Cart</h1>            </div>        </div>    </div></div><section class="ftco-section ftco-cart">    <form action="<%=request.getContextPath()%>/StarServlet" method="post">        <div class="container">            <div class="row">                <div class="col-md-12 ftco-animate">                    <div class="cart-list">                        <form action="<%=request.getContextPath()%>/CartServlet" method="post">                            <p>${notify}</p>                            <table class="table">                                <thead class="thead-primary">                                <tr class="text-center, pro">                                    <th>&nbsp;</th>                                    <th>&nbsp;</th>                                    <th id="poduct-name">Product name</th>                                    <th>Rate</th>                                    <th>Update</th>                                </tr>                                </thead>                                <tbody>                                <c:forEach items="${listCart}" var="c">                                    <tr class="text-center">                                        <td class="product-remove"><a href="#"><span class="ion-ios-close"></span></a>                                        </td>                                        <td class="image-prod">                                            <div class="img"                                                 style="background-image:url(<%=request.getContextPath()%>/View/User/images/${c.productImg});"></div>                                        </td>                                        <td class="product-name">                                            <h3>${c.productName}</h3>                                        </td>                                        <td>                                            <select name="rateStar" id="rateStar">                                                <option value="0" selected>Rate Star</option>                                                <option value="1">⭐</option>                                                <option value="2">⭐⭐</option>                                                <option value="3">⭐⭐⭐</option>                                                <option value="4">⭐⭐⭐⭐</option>                                                <option value="5">⭐⭐⭐⭐⭐</option>                                            </select>                                                <%--                                            <div class="rating-stars text-center">--%>                                                <%--                                                <ul id="stars">--%>                                                <%--                                                    <li class="star" title="Poor" data-value="1">--%>                                                <%--                                                        <i class="fa fa-star fa-fw"></i>--%>                                                <%--                                                    </li>--%>                                                <%--                                                    <li class="star" title="Fair" data-value="2">--%>                                                <%--                                                        <i class="fa fa-star fa-fw"></i>--%>                                                <%--                                                    </li>--%>                                                <%--                                                    <li class="star" title="Good" data-value="3">--%>                                                <%--                                                        <i class="fa fa-star fa-fw"></i>--%>                                                <%--                                                    </li>--%>                                                <%--                                                    <li class="star" title="Excellent" data-value="4">--%>                                                <%--                                                        <i class="fa fa-star fa-fw"></i>--%>                                                <%--                                                    </li>--%>                                                <%--                                                    <li class="star" title="WOW!!!" data-value="5">--%>                                                <%--                                                        <i class="fa fa-star fa-fw"></i>--%>                                                <%--                                                    </li>--%>                                                <%--                                                </ul>--%>                                                <%--                                            </div>--%>                                        </td>                                    </tr>                                    <!-- END TR-->                                </c:forEach>                                </tbody>                            </table>                        </form>                    </div>                </div>            </div>            <div class="row justify-content-end">                <div class="col-lg-4 mt-5 cart-wrap ftco-animate">                    <p><input type="submit" name="action" class="btn btn-black py-3 px-5" value="SendRate"></p>                    <input type="hidden" name="rateStar" id="rateStar1">                </div>            </div>        </div>    </form></section><section class="ftco-section ftco-no-pt ftco-no-pb py-5 bg-light">    <div class="container py-4">        <div class="row d-flex justify-content-center py-5">            <div class="col-md-6">                <h2 style="font-size: 22px;" class="mb-0">Subcribe to our Newsletter</h2>                <span>Get e-mail updates about our latest shops and special offers</span>            </div>            <div class="col-md-6 d-flex align-items-center">                <form action="#" class="subscribe-form">                    <div class="form-group d-flex">                        <input type="text" class="form-control" placeholder="Enter email address">                        <input type="submit" value="Subscribe" class="submit px-3">                    </div>                </form>            </div>        </div>    </div></section><section>    <div class="rating-stars text-center">        <ul id="stars1">            <li class="star" title="Poor" data-value="1">                <i class="fa fa-star fa-fw"></i>            </li>            <li class="star" title="Fair" data-value="2">                <i class="fa fa-star fa-fw"></i>            </li>            <li class="star" title="Good" data-value="3">                <i class="fa fa-star fa-fw"></i>            </li>            <li class="star" title="Excellent" data-value="4">                <i class="fa fa-star fa-fw"></i>            </li>            <li class="star" title="WOW!!!" data-value="5">                <i class="fa fa-star fa-fw"></i>            </li>        </ul>    </div></section><footer class="ftco-footer ftco-section">    <div class="container">        <div class="row">            <div class="mouse">                <a href="#" class="mouse-icon">                    <div class="mouse-wheel"><span class="ion-ios-arrow-up"></span></div>                </a>            </div>        </div>        <div class="row mb-5">            <div class="col-md">                <div class="ftco-footer-widget mb-4">                    <h2 class="ftco-heading-2">Vegefoods</h2>                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>                    <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">                        <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>                        <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>                        <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>                    </ul>                </div>            </div>            <div class="col-md">                <div class="ftco-footer-widget mb-4 ml-md-5">                    <h2 class="ftco-heading-2">Menu</h2>                    <ul class="list-unstyled">                        <li><a href="#" class="py-2 d-block">Shop</a></li>                        <li><a href="#" class="py-2 d-block">About</a></li>                        <li><a href="#" class="py-2 d-block">Journal</a></li>                        <li><a href="#" class="py-2 d-block">Contact Us</a></li>                    </ul>                </div>            </div>            <div class="col-md-4">                <div class="ftco-footer-widget mb-4">                    <h2 class="ftco-heading-2">Help</h2>                    <div class="d-flex">                        <ul class="list-unstyled mr-l-5 pr-l-3 mr-4">                            <li><a href="#" class="py-2 d-block">Shipping Information</a></li>                            <li><a href="#" class="py-2 d-block">Returns &amp; Exchange</a></li>                            <li><a href="#" class="py-2 d-block">Terms &amp; Conditions</a></li>                            <li><a href="#" class="py-2 d-block">Privacy Policy</a></li>                        </ul>                        <ul class="list-unstyled">                            <li><a href="#" class="py-2 d-block">FAQs</a></li>                            <li><a href="#" class="py-2 d-block">Contact</a></li>                        </ul>                    </div>                </div>            </div>            <div class="col-md">                <div class="ftco-footer-widget mb-4">                    <h2 class="ftco-heading-2">Have a Questions?</h2>                    <div class="block-23 mb-3">                        <ul>                            <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span>                            </li>                            <li><a href="#"><span class="icon icon-phone"></span><span                                    class="text">+2 392 3929 210</span></a></li>                            <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@yourdomain.com</span></a>                            </li>                        </ul>                    </div>                </div>            </div>        </div>        <div class="row">            <div class="col-md-12 text-center">                <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->                    Copyright &copy;<script>document.write(new Date().getFullYear());</script>                    All rights reserved | This template is made with <i class="icon-heart color-danger"                                                                        aria-hidden="true"></i> by <a                            href="https://colorlib.com" target="_blank">Colorlib</a>                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->                </p>            </div>        </div>    </div></footer><!-- loader --><div id="ftco-loader" class="show fullscreen">    <svg class="circular" width="48px" height="48px">        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"                stroke="#F96D00"/>    </svg></div><script src="<%=request.getContextPath()%>/View/User/js/jquery.min.js"></script><script src="<%=request.getContextPath()%>/View/User/js/jquery-migrate-3.0.1.min.js"></script><script src="<%=request.getContextPath()%>/View/User/js/popper.min.js"></script><script src="<%=request.getContextPath()%>/View/User/js/bootstrap.min.js"></script><script src="<%=request.getContextPath()%>/View/User/js/jquery.easing.1.3.js"></script><script src="<%=request.getContextPath()%>/View/User/js/jquery.waypoints.min.js"></script><script src="<%=request.getContextPath()%>/View/User/js/jquery.stellar.min.js"></script><script src="<%=request.getContextPath()%>/View/User/js/owl.carousel.min.js"></script><script src="<%=request.getContextPath()%>/View/User/js/jquery.magnific-popup.min.js"></script><script src="<%=request.getContextPath()%>/View/User/js/aos.js"></script><script src="<%=request.getContextPath()%>/View/User/js/jquery.animateNumber.min.js"></script><script src="<%=request.getContextPath()%>/View/User/js/bootstrap-datepicker.js"></script><script src="<%=request.getContextPath()%>/View/User/js/scrollax.min.js"></script><script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script><script src="<%=request.getContextPath()%>/View/User/js/google-map.js"></script><script src="<%=request.getContextPath()%>/View/User/js/main.js"></script><script>    $(document).ready(function () {        var quantitiy = 0;        $('.quantity-right-plus').click(function (e) {            // Stop acting like a button            e.preventDefault();            // Get the field name            var quantity = parseInt($('#quantity').val());            // If is not undefined            $('#quantity').val(quantity + 1);            // Increment        });        $('.quantity-left-minus').click(function (e) {            // Stop acting like a button            e.preventDefault();            // Get the field name            var quantity = parseInt($('#quantity').val());            // If is not undefined            // Increment            if (quantity > 0) {                $('#quantity').val(quantity - 1);            }        });    });</script><script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script><script>    $(document).ready(function () {        /* 1. Visualizing things on Hover - See next part for action on click */        $('#stars li').on('mouseover', function () {            var onStar = parseInt($(this).data('value'), 10); // The star currently mouse on            // Now highlight all the stars that's not after the current hovered star            $(this).parent().children('li.star').each(function (e) {                if (e < onStar) {                    $(this).addClass('hover');                } else {                    $(this).removeClass('hover');                }            });        }).on('mouseout', function () {            $(this).parent().children('li.star').each(function (e) {                $(this).removeClass('hover');            });        });        /* 2. Action to perform on click */        $('#stars li').on('click', function () {            var onStar = parseInt($(this).data('value'), 10); // The star currently selected            var stars = $(this).parent().children('li.star');            for (i = 0; i < stars.length; i++) {                $(stars[i]).removeClass('selected');            }            for (i = 0; i < onStar; i++) {                $(stars[i]).addClass('selected');            }            let ratingValue = parseInt($('#stars li.selected').last().data('value'), 10);            ${'#rateStar'}.            val(ratingValue)            // $.ajax({            //     url:'StarServlet',            //     data:{rateStar:ratingValue},            //     type:'post',            // })            console.log(ratingValue)        });    });</script></body></html>