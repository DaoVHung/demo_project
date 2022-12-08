<%--
  Created by IntelliJ IDEA.
  User: GentMaker
  Date: 11/22/2022
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <title>Login Gent Steak</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
        rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,800">
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
  <link rel="stylesheet" href="<%=request.getContextPath()%>/View/User/css/Login.css">
  <style>

    img {
      position: absolute;
      max-width: 100%;

    }
    input[type=submit] {
      width: 150px;
      height: 50px;
      border-radius: 20px;
      border: 1px solid #FF4B2B;
      background-color: #FF4B2B;
      color: #FFFFFF;
      font-size: 12px;
      font-weight: bold;
      padding: 12px 45px;
      letter-spacing: 1px;
      text-transform: uppercase;
      transition: transform 80ms ease-in;

    }

  </style>
</head>
<img src="<%=request.getContextPath()%>/View/User/images/Fotoram.io%20(2).jpg" alt="">
<div class="container" id="container">
  <div class="form-container sign-up-container">
    <form action="<%=request.getContextPath()%>/UserServlet" method="post">
      <h3>Create Account</h3>
      <input type="text" name="fullName" placeholder="Full name"/>
      <input type="text" name="userName" placeholder="Username">
      <input type="password" name="passwords" placeholder="Password"/>
      <input type="password" name="confrimPass" placeholder="Confirm Password">
      <input type="email" name="email" placeholder="Email"/>
      <input type="text" name="phoneNumber" placeholder="Phone number">
      <input type="text" name="address" placeholder="address">
      <input type="submit" value="Create" name="action">
    </form>
  </div>
  <div class="form-container sign-in-container">

    <form action="<%=request.getContextPath()%>/UserServlet" method="get">
      <h1>Sign in</h1>
      <span>or use your account</span>
      <input type="username" name="username" placeholder="UserName"/>
      <input type="password" name="passwords" placeholder="Passwords"/>
      ${wrong}
      ${success}
      <input type="submit" value="Login" name="action">
      <a href="<%=request.getContextPath()%>/ProductServlet?action=GetAll">Visit the site without an account</a>
    </form>
  </div>
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-left">
        <h1>Welcome Back!</h1>
        <p>To keep connected with us please login with your personal info</p>
        <button class="ghost" id="signIn">Sign In</button>
        <a href="index.html">Visit the site without an account</a>
      </div>
      <div class="overlay-panel overlay-right">
        <h1>Hello, Friend!</h1>
        <p>Enter your personal details and start journey with us</p>
        <button class="ghost" id="signUp">Sign Up</button>
        <a href="<%=request.getContextPath()%>/View/User/Admin.jsp">😍</a>
      </div>
    </div>
  </div>
</div>


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
  const signUpButton = document.getElementById('signUp');
  const signInButton = document.getElementById('signIn');
  const container = document.getElementById('container');

  signUpButton.addEventListener('click', () => {
    container.classList.add('right-panel-active');
  });
  signInButton.addEventListener('click', () => {
    container.classList.remove('right-panel-active');
  });
</script>

</body>

</html>