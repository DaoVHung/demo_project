<%--
  Created by IntelliJ IDEA.
  User: GentMaker
  Date: 11/27/2022
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Gent Steak</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>View/User/css/SuccesCss.css">
</head>
<body>
<img src="<%=request.getContextPath()%>/View/User/images/Fotoram.io (2).jpg" alt="">
<div id="container">
  <div id="success-box">
    <div class="dot"></div>
    <div class="dot two"></div>
    <div class="face">
      <div class="eye"></div>
      <div class="eye right"></div>
      <div class="mouth happy"></div>
    </div>
    <div class="shadow scale"></div>
    <div class="message"><h1 class="alert">Success!</h1><p>Your order is successful, the order will be shipped to you as soon as possible</p></div>
    <button class="button-box"><a href="<%=request.getContextPath()%>/ProductServlet?action=GetAll">continue</a></button>
  </div>

</div>

<footer>
  <p>made by <a href="https://codepen.io/juliepark"> julie</a> ♡
</footer>


</body>
</html>
