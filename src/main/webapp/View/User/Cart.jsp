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
</head>
<body class="goto-here">
<jsp:include page="../header.jsp"/>
<div class="hero-wrap hero-bread"
     style="background-image: url('<%=request.getContextPath()%>/View/User/images/still-life-vegetables-Avocado-zucchini-Broccoli-basil-2191895-wallhere.com.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Cart</span></p>
                <h1 class="mb-0 bread">My Cart</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section ftco-cart">
    <form action="<%=request.getContextPath()%>/CartServlet" method="post">
        <div class="container">
            <div class="row">
                <div class="col-md-12 ftco-animate">
                    <div class="cart-list">
                        <form action="<%=request.getContextPath()%>/CartServlet" method="post">
                            <p>${notify}</p>
                            <table class="table">
                                <thead class="thead-primary">
                                <tr class="text-center, pro">
                                    <th>&nbsp;</th>
                                    <th>&nbsp;</th>
                                    <th id="poduct-name">Product name</th>
                                    <th>Price</th>
                                    <th>Discount</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Update</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${listCart}" var="c">

                                    <tr class="text-center">

                                        <td class="product-remove"><a href="<%=request.getContextPath()%>/CartServlet?action=Delete&&productID=${c.product.productID}"><span class="ion-ios-close"></span></a>
                                        </td>

                                        <td class="image-prod">
                                            <div class="img"
                                                 style="background-image:url(<%=request.getContextPath()%>/View/User/images/${c.product.productImg});"></div>
                                        </td>

                                        <td class="product-name">
                                            <h3>${c.product.productName}</h3>
                                            <p>${c.note}</p>
                                        </td>

                                        <td class="price"> ${c.product.price} $</td>
                                        <td class="discount"> ${c.product.discount} %</td>
                                        <td class="quantity">
                                            <div style="border-color: #0a0a0a " class="input-group mb-3">
                                                <input type="text" name="quantity"
                                                       class="quantity form-control input-number"
                                                       value="${c.quantity}" min="1" max="100">
                                            </div>
                                        </td>
                                        <td class="total">${c.quantity*c.product.price*(100-c.product.discount)/100} $</td>
                                        <td>
                                            <input type="submit" name="action" value="Update">
                                        </td>
                                    </tr>
                                    <!-- END TR-->
                                </c:forEach>

                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
            <p><a href="<%=request.getContextPath()%>/ProductServlet?action=GetAllFood" class="btn btn-black py-3 px-5">Continue
                shopping</a></p>

            <div class="row justify-content-end">
                <div class="col-lg-4 mt-5 cart-wrap ftco-animate">
                    <div class="cart-total mb-3">
                        <h3>Coupon Code</h3>
                        <p>Enter your coupon code if you have one</p>
                        <form action="<%=request.getContextPath()%>/CartServlet" method="post" class="info">
                            <div class="form-group">
                                <input id="coupon" type="text" name="coupon" class="form-control text-left px-3" placeholder="Enter Coupon code">
                                <p><input type="submit" name="action" class="btn btn-black py-3 px-5" value="Apply coupon"></p>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="col-lg-4 mt-5 cart-wrap ftco-animate">
                    <div class="cart-total mb-3">
                        <h3>Cart Totals</h3>
                        <p class="d-flex">
                            <span>Subtotal</span>
                            <span>${totalAmount} $</span>
                        </p>
                        <p class="d-flex">
                            <span>Delivery</span>
                            <span>Free</span>
                        </p>
                        <p class="d-flex">
                            <span>Discount</span>
                            <span>${coupon=(coupon==null)?0:coupon} %</span>
                            ${motify}
                            <input type="hidden" name="coupon" value="${coupon=(coupon==null)?0:coupon}">
                        </p>
                        <hr>
                        <p class="d-flex total-price">
                            <span>Total</span>
                            <span>${totalAmount*(100-coupon)/100} $</span>

                        </p>
                    </div>

                    <p><input type="submit" name="action" class="btn btn-black py-3 px-5" value="CheckOut"></p>
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
<script>

    let value = document.getElementById("coupon").value
    console.log(value)

</script>

</body>
</html>