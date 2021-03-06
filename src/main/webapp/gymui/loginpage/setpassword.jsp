<%-- 
    Document   : setpassword
    Created on : Sep 8, 2018, 4:08:12 PM
    Author     : sneh pael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Set Password</title>
<!--===============================================================================================-->
  <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/gymui/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/gymui/vendor/animate/animate.css">
<!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/gymui/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/gymui/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/gymui/vendor/select2/select2.min.css">
<!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/gymui/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/gymui/css/util.css">
  <link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/gymui/css/main.css">
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=application.getContextPath()%>/gymui/css/modern-business.css" rel="stylesheet">
<body>
<div w3-include-html="header.html"></div> 
<%@include file="../ui/header.jsp"%>
</body>
  </head>
  
 <body>
  <div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">Set 
        <small>Password</small>
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="index.html">Home</a>
        </li>
        <li class="breadcrumb-item active">Set Password</li>
      </ol>


      <h1 align="center">Set Password</h1>
<div  align="center">
      <form class="contact100-form validate-form">
        

        <div class="wrap-input100 validate-input" data-validate = "Please enter the valid password" >
          <input class="input100" type="text" name="npass" placeholder="New Password"style="background-color:#d7dbe2;">
          <span class="focus-input100"></span>
        </div>
        <div class="wrap-input100 validate-input" data-validate = "Please enter the valid password" >
          <input class="input100" type="text" name="repass" placeholder="Re-Enter Password"style="background-color:#d7dbe2;">
          <span class="focus-input100"></span>
        </div>
        <div class="wrap-input100 validate-input" data-validate = "Please enter the correct OTP" >
          <input class="input100" type="text" name="otp" placeholder="Enter OTP"style="background-color:#d7dbe2;">
          <span class="focus-input100"></span>
        </div>
        <div class="container-contact100-form-btn" style="padding: 20px;">
        <a href="setpassword.html">  <button class="contact100-form-btn">
            <span>
              <i class="fa fa-paper-plane-o m-r-6" aria-hidden="true"></i>
              Submit
            </span>
          </button></a>
        </div>
      </form>
     </div>
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
      </div>
</div>
      <!-- /.container -->
    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="<%=application.getContextPath()%>/gymui/vendor/jquery/jquery.min.js"></script>
    <script src="<%=application.getContextPath()%>/gymui/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>