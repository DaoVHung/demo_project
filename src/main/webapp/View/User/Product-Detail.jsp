<%--
  Created by IntelliJ IDEA.
  User: GentMaker
  Date: 11/24/2022
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Gent Steak</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">
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

</head>
<body class="goto-here">
<jsp:include page="../header.jsp" />

<!-- END nav -->

<div class="hero-wrap hero-bread"
     style="background-image: url('<%=request.getContextPath()%>/View/User/images/New folder/food-pancakes-tomatoes-bread-Garlic-Pans-Tool-2162243-wallhere.com.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Products</span></p>
                <h1 class="mb-0 bread">Products Detail</h1>
            </div>
        </div>
    </div>
</div>

<%--================================================== Detail ===========================================================--%>
<section class="ftco-section">
    <form action="<%=request.getContextPath()%>/CartServlet?productID=${proDetail.productID}" method="post"
          enctype="multipart/form-data">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 mb-5 ftco-animate">
                    <a href="images/food-closeup-2111749-wallhere.com.jpg" class="image-popup"><img
                            src="<%=request.getContextPath()%>/View/User/images/${proDetail.productImg}"
                            class="img-fluid"
                            alt="Colorlib Template"></a>
                </div>
                <div class="col-lg-6 product-details pl-md-5 ftco-animate">
                    <h3>${proDetail.productName}</h3>
                    <div class="rating d-flex">
                        <p class="text-left mr-4">
                            <a href="#" class="mr-2"> Reviews ${star} <span class="ion-ios-star-outline"></span></a>
                        </p>
                        <p  class="text-left mr-4">
                           Discount ${proDetail.discount} %
                            <input type="hidden" name="discount" value="${proDetail.discount}">
                        </p>
                        <p class="text-left">
                            <a href="#" class="mr-2" style="color: #000;">500 <span style="color: #bbb;">Sold</span></a>
                        </p>
                    </div>
                    <p class="price"><span>${proDetail.price} $</span></p>
                    <p>${proDetail.description}</p>
                    <div class="row mt-4">
                        <div class="col-md-6">
                            <div class="form-group d-flex">
                                <div class="select-wrap">
                                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                </div>
                            </div>
                        </div>
                        <div class="w-100"></div>
                        <div class="input-group col-md-6 d-flex mb-3">
	             	<span class="input-group-btn mr-2">
	                	<button type="button" class="quantity-left-minus btn" data-type="minus" data-field="">
	                   <i class="ion-ios-remove"></i>
	                	</button>
	            		</span>
                            <input type="text" id="quantity" name="quantity" class="form-control input-number" value="1"
                                   min="1" max="100">
                            <span class="input-group-btn ml-2">
	                	<button type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
	                     <i class="ion-ios-add"></i>
	                 </button>
	             	</span>
                        </div>
                        <div class="w-100"></div>
                    </div>
                    <input type="text" name="note" placeholder="Note"> <br> <br>
                    <p>
                        <input type="submit" name="action" class="btn btn-black py-3 px-5" value="Add To Cart">
                    </p>
                </div>
            </div>
        </div>
    </form>
</section>
<jsp:include page="footer.jsp" />


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
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="<%=request.getContextPath()%>/View/User/js/google-map.js"></script>
<script src="<%=request.getContextPath()%>/View/User/js/main.js"></script>

<script>
    $(document).ready(function () {

        var quantitiy = 0;
        $('.quantity-right-plus').click(function (e) {

            // Stop acting like a button
            e.preventDefault();
            // Get the field name
            var quantity = parseInt($('#quantity').val());

            // If is not undefined

            $('#quantity').val(quantity + 1);


            // Increment

        });

        $('.quantity-left-minus').click(function (e) {
            // Stop acting like a button
            e.preventDefault();
            // Get the field name
            var quantity = parseInt($('#quantity').val());

            // If is not undefined

            // Increment
            if (quantity > 0) {
                $('#quantity').val(quantity - 1);
            }
        });

    });
</script>

</body>
</html>