<%--
  Created by IntelliJ IDEA.
  User: GentMaker
  Date: 11/22/2022
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Vegefoods - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/css/font1.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/css/font2.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/css/font3.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/animate.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/owl.carousel.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/magnific-popup.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/aos.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/ionicons.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/jquery.timepicker.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/flaticon.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/icomoon.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/style.css">
    <style>
        .py-1 {
            background-color: black;
        }

        .bg-primary {
            background-color: black;
        }
    </style>
</head>
<body class="goto-here">
<jsp:include page="../Header.jsp"/>

<section id="home-section" class="hero">

    <div class="home-slider owl-carousel">

        <div class="slider-item"
             style="background-image:url(<%=request.getContextPath()%>/View/User/images/meat-rosemary-steak-988011-wallhere.com.jpg) ;">
            <div class="overlay"></div>
            <div class="container">
                <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

                    <div class="col-sm-12 ftco-animate text-center">
                        <h1 class="mb-2">100% Fresh &amp; Organic Foods</h1>
                        <h2 class="subheading mb-4">We deliver organic vegetables &amp; fruits</h2>
                        <p><a href="<%=request.getContextPath()%>/ProductServlet?action=GetAllFood"
                              class="btn btn-primary">View Details</a></p>
                    </div>

                </div>
            </div>
        </div>
        <div class="slider-item"
             style="background-image:url(<%=request.getContextPath()%>/View/User/images/food-fork-knife-dark-fruit-berries-1936935-wallhere.com.jpg) ;">
            <div class="overlay"></div>
            <div class="container">
                <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

                    <div class="col-md-12 ftco-animate text-center">
                        <h1 class="mb-2">Gent Steak</h1>
                        ${Notify}
                        <h2 class="subheading mb-4">British Flavored Steak</h2>
                        <p><a href="<%=request.getContextPath()%>/ProductServlet?action=GetAllFood"
                              class="btn btn-primary">View Details</a></p>
                    </div>

                </div>
            </div>
        </div>


    </div>
</section>

<section class="ftco-section">
    <div class="container">
        <div class="row no-gutters ftco-services">
            <div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
                <div class="media block-6 services mb-md-0 mb-4">
                    <div class="icon bg-color-1 active d-flex justify-content-center align-items-center mb-2">
                        <span class="flaticon-shipped"></span>
                    </div>
                    <div class="media-body">
                        <h3 class="heading">Free Shipping</h3>
                        <span>On order over $100</span>
                    </div>
                </div>
            </div>
            <div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
                <div class="media block-6 services mb-md-0 mb-4">
                    <div class="icon bg-color-2 d-flex justify-content-center align-items-center mb-2">
                        <span class="flaticon-diet"></span>
                    </div>
                    <div class="media-body">
                        <h3 class="heading">Always Fresh</h3>
                        <span>Product well package</span>
                    </div>
                </div>
            </div>
            <div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
                <div class="media block-6 services mb-md-0 mb-4">
                    <div class="icon bg-color-3 d-flex justify-content-center align-items-center mb-2">
                        <span class="flaticon-award"></span>
                    </div>
                    <div class="media-body">
                        <h3 class="heading">Superior Quality</h3>
                        <span>Quality Products</span>
                    </div>
                </div>
            </div>
            <div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
                <div class="media block-6 services mb-md-0 mb-4">
                    <div class="icon bg-color-4 d-flex justify-content-center align-items-center mb-2">
                        <span class="flaticon-customer-service"></span>
                    </div>
                    <div class="media-body">
                        <h3 class="heading">Support</h3>
                        <span>24/7 Support</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section ftco-category ftco-no-pt">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="row">
                    <div class="col-md-6 order-md-last align-items-stretch d-flex">
                        <div class="category-wrap-2 ftco-animate img align-self-stretch d-flex"
                             style="background-image: url(<%=request.getContextPath()%>/View/User/images/View_14.jpg);">
                            <div style="color:antiquewhite" class="text text-center">
                                <h2 style="color:antiquewhite">Book a table</h2>
                                <p style="color:antiquewhite">Ready to prepare a beautiful location for you</p>
                                <p><a href="<%=request.getContextPath()%>/View/User/Booking.jsp"
                                      class="btn btn-primary">Book now</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="category-wrap ftco-animate img mb-4 d-flex align-items-end"
                             style="background-image: url(<%=request.getContextPath()%>/images/food-closeup-2111749-wallhere.com.jpg);">
                            <div class="text px-3 py-1">
                                <h2 class="mb-0"><a
                                        href="<%=request.getContextPath()%>/ProductServlet?action=GetAllMainFood">Main
                                    Food</a></h2>
                            </div>
                        </div>
                        <div class="category-wrap ftco-animate img d-flex align-items-end"
                             style="background-image: url(<%=request.getContextPath()%>/View/User/images/salad-vegetables-olives-cucumbers-cheese-Greek-685508-wallhere.com.jpg);">
                            <div class="text px-3 py-1">
                                <h2 class="mb-0"><a
                                        href="<%=request.getContextPath()%>/ProductServlet?action=GetAllSalad">Salad</a>
                                </h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="category-wrap ftco-animate img mb-4 d-flex align-items-end"
                     style="background-image: url(<%=request.getContextPath()%>/View/User/images/wine-8.jpg);">
                    <div class="text px-3 py-1">
                        <h2 class="mb-0"><a href="<%=request.getContextPath()%>/ProductServlet?action=GetAllDrinks">Drinks</a>
                        </h2>
                    </div>
                </div>
                <div class="category-wrap ftco-animate img d-flex align-items-end"
                     style="background-image: url(<%=request.getContextPath()%>/View/User/images/dessert-3.jpg);">
                    <div class="text px-3 py-1">
                        <h2 class="mb-0"><a href="<%=request.getContextPath()%>/ProductServlet?action=GetAllDesserts">Desserts</a>
                        </h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center mb-3 pb-3">
            <div class="col-md-12 heading-section text-center ftco-animate">
                <span class="subheading">Featured Products</span>
                <h2 class="mb-4">Our Products</h2>
                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>
            </div>
        </div>
    </div>
    <div class="container">

        <%--==========================================  Product  =========================================================--%>

        <div class="row">
            <c:forEach items="${detail}" var="d">
                <div class="col-md-6 col-lg-3 ftco-animate">
                    <div class="product">
                        <a href="<%=request.getContextPath()%>/ProductServlet?productID=${d.productID}&&action=productDetail"
                           class="img-prod"><img class="img-fluid"
                                                 src="<%=request.getContextPath()%>/View/User/images/${d.productImg}"
                                                 alt="Colorlib Template">
                            <span class="status">${d.discount}%</span>
                            <div class="overlay"></div>
                        </a>
                        <div class="text py-3 pb-4 px-3 text-center">
                            <h3>
                                <a href="<%=request.getContextPath()%>/View/User/Product-Detail.jsp">${d.productName}</a>
                            </h3>
                            <div class="d-flex">
                                <div class="pricing">
                                    <p class="price"><span class="mr-2 price-dc">${d.price} VNĐ</span> <span
                                            class="price-sale">${d.price*(100-d.discount)/100} VNĐ</span></p>
                                </div>
                            </div>
                            <div class="bottom-area d-flex px-3">
                                <div class="m-auto d-flex">
                                    <a href="<%=request.getContextPath()%>/ProductServlet?productID=${d.productID}&&action=productDetail"
                                       class="add-to-cart d-flex justify-content-center align-items-center text-center">
                                        <span><i class="ion-ios-menu"></i></span>
                                    </a>
                                    <a href="<%=request.getContextPath()%>/CartServlet?action=addCart&&discount=${d.discount}&&productID=${d.productID}" class="buy-now d-flex justify-content-center align-items-center mx-1">
                                        <span><i class="ion-ios-cart"></i></span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>


<section class="ftco-section testimony-section">
    <div class="container">
        <div class="row justify-content-center mb-5 pb-3">
            <div class="col-md-7 heading-section ftco-animate text-center">
                <span class="subheading">Testimony</span>
                <h2 class="mb-4">Our satisfied customer says</h2>
                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live
                    the blind texts. Separated they live in</p>
            </div>
        </div>
        <div class="row ftco-animate">
            <div class="col-md-12">
                <div class="carousel-testimony owl-carousel">
                    <div class="item">
                        <div class="testimony-wrap p-4 pb-5">
                            <div class="user-img mb-5"
                                 style="background-image: url(<%=request.getContextPath()%>/View/User/images/person_3.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                            </div>
                            <div class="text text-center">
                                <p class="mb-5 pl-4 line">Far far away, behind the word mountains, far from the
                                    countries Vokalia and Consonantia, there live the blind texts.</p>
                                <p class="name">Garreth Smith</p>
                                <span class="position">UI Designer</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<hr>


<%--=======================================================  footer  =====================================================--%>
<section class="ftco-section ftco-partner">
    <div class="container">
        <div class="row">
            <div class="col-sm ftco-animate">
                <a href="#" class="partner"><img src="<%=request.getContextPath()%>/View/User/images/partner-1.png"
                                                 class="img-fluid" alt="Colorlib Template"></a>
            </div>
            <div class="col-sm ftco-animate">
                <a href="#" class="partner"><img src="<%=request.getContextPath()%>/View/User/images/partner-2.png"
                                                 class="img-fluid" alt="Colorlib Template"></a>
            </div>
            <div class="col-sm ftco-animate">
                <a href="#" class="partner"><img src="<%=request.getContextPath()%>/View/User/images/partner-3.png"
                                                 class="img-fluid" alt="Colorlib Template"></a>
            </div>
            <div class="col-sm ftco-animate">
                <a href="#" class="partner"><img src="<%=request.getContextPath()%>/View/User/images/partner-4.png"
                                                 class="img-fluid" alt="Colorlib Template"></a>
            </div>
            <div class="col-sm ftco-animate">
                <a href="#" class="partner"><img src="<%=request.getContextPath()%>/View/User/images/partner-5.png"
                                                 class="img-fluid" alt="Colorlib Template"></a>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section ftco-no-pt ftco-no-pb py-5 bg-light">
    <div class="container py-4">

        <div class="row d-flex justify-content-center py-5">
            <div class="col-md-6">
                <img style="position:fixed;" src="<%=request.getContextPath()%>/View/User/images/wine-7.jpg" alt="">
                <h2 style="font-size: 22px;" class="mb-0">Subcribe to our Newsletter</h2>
                <span>Get e-mail updates about our latest shops and special offers</span>
            </div>
            <div class="col-md-6 d-flex align-items-center">
                <form action="#" class="subscribe-form">
                    <div class="form-group d-flex">
                        <input type="text" class="form-control" placeholder="Enter email address">
                        <input type="submit" value="Subscribe" class="submit px-3">
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<footer class="ftco-footer ftco-section">
    <div class="container">
        <div class="row">
            <div class="mouse">
                <a href="#" class="mouse-icon">
                    <div class="mouse-wheel"><span class="ion-ios-arrow-up"></span></div>
                </a>
            </div>
        </div>
        <div class="row mb-5">
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Gent Steak</h2>
                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>
                    <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                        <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                        <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                        <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4 ml-md-5">
                    <h2 class="ftco-heading-2">Menu</h2>
                    <ul class="list-unstyled">
                        <li><a href="shop.html" class="py-2 d-block">Shop</a></li>
                        <li><a href="about.html" class="py-2 d-block">About</a></li>
                        <li><a href="blog.html" class="py-2 d-block">Journal</a></li>
                        <li><a href="contact.html" class="py-2 d-block">Contact Us</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-4">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Help</h2>
                    <div class="d-flex">
                        <ul class="list-unstyled mr-l-5 pr-l-3 mr-4">
                            <li><a href="#" class="py-2 d-block">Shipping Information</a></li>
                            <li><a href="#" class="py-2 d-block">Returns &amp; Exchange</a></li>
                            <li><a href="#" class="py-2 d-block">Terms &amp; Conditions</a></li>
                            <li><a href="#" class="py-2 d-block">Privacy Policy</a></li>
                        </ul>
                        <ul class="list-unstyled">
                            <li><a href="#" class="py-2 d-block">FAQs</a></li>
                            <li><a href="#" class="py-2 d-block">Contact</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Have a Questions?</h2>
                    <div class="block-23 mb-3">
                        <ul>
                            <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span>
                            </li>
                            <li><a href="#"><span class="icon icon-phone"></span><span
                                    class="text">+2 392 3929 210</span></a></li>
                            <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@yourdomain.com</span></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-center">

                <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    Copyright &copy;<script>document.write(new Date().getFullYear());</script>
                    All rights reserved | This template is made with <i class="icon-heart color-danger"
                                                                        aria-hidden="true"></i> by <a
                            href="https://colorlib.com" target="_blank">Colorlib</a>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                </p>
            </div>
        </div>
    </div>
</footer>


<!-- loader -->
<div id="ftco-loader" class="show fullscreen">
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                stroke="#F96D00"/>
    </svg>
</div>


<script src="<%=request.getContextPath()%>/View/User/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/View/User/js/jquery-migrate-3.0.1.min.js"></script>
<script src="<%=request.getContextPath()%>/View/User/js/popper.min.js"></script>
<script src="<%=request.getContextPath()%>/View/User/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/View/User/js/jquery.easing.1.3.js"></script>
<script src="<%=request.getContextPath()%>/View/User/js/jquery.waypoints.min.js"></script>
<script src="<%=request.getContextPath()%>/View/User/js/jquery.stellar.min.js"></script>
<script src="<%=request.getContextPath()%>/View/User/js/owl.carousel.min.js"></script>
<script src="<%=request.getContextPath()%>/View/User/js/jquery.magnific-popup.min.js"></script>
<script src="<%=request.getContextPath()%>/View/User/js/aos.js"></script>
<script src="<%=request.getContextPath()%>/View/User/js/jquery.animateNumber.min.js"></script>
<script src="<%=request.getContextPath()%>/View/User/js/bootstrap-datepicker.js"></script>
<script src="<%=request.getContextPath()%>/View/User/js/scrollax.min.js"></script>
<script src="<%=request.getContextPath()%>/View/User/css/css/font4.js"></script>

<%--<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>--%>
<script src="<%=request.getContextPath()%>/View/User/js/google-map.js"></script>
<script src="<%=request.getContextPath()%>/View/User/js/main.js"></script>


</body>
</html>