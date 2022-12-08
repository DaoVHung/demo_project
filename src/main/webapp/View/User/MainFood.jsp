<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GentMaker
  Date: 11/22/2022
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
     style="background-image: url('<%=request.getContextPath()%>/View/User/images/food-closeup-2111719-wallhere.com.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Products</span></p>
                <h1 class="mb-0 bread">Products</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-10 mb-5 text-center">
                <ul class="product-category">
                    <li><a href="<%=request.getContextPath()%>/ProductServlet?action=GetAllFood">All</a></li>
                    <li><a href="<%=request.getContextPath()%>/ProductServlet?action=GetAllMainFood" class="active">Main
                        Food</a></li>
                    <li><a href="<%=request.getContextPath()%>/ProductServlet?action=GetAllDrinks">Drinks</a></li>
                    <li><a href="<%=request.getContextPath()%>/ProductServlet?action=GetAllSalad">Salad</a></li>
                    <li><a href="<%=request.getContextPath()%>/ProductServlet?action=GetAllDesserts">Desserts</a></li>
                </ul>
            </div>
        </div>

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
                                    <p class="price"><span class="mr-2 price-dc">${d.price} $</span> <span
                                            class="price-sale">${d.price*(100-d.discount)/100} $</span></p>
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
        <div class="row mt-5">
            <div class="col text-center">
                <div class="block-27">
                    <ul>
                        <li><a href="#">&lt;</a></li>
                        <li class="active"><span>1</span></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">&gt;</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
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


</body>
</html>