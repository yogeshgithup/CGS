<%-- 
    Document   : adminlogin
    Created on : Sep 9, 2018, 10:37:43 AM
    Author     : sneh pael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  
    String msg=request.getParameter("msg");
      if(msg==null)
      {
          msg="";
      }
        %>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin Login</title>
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
    <link href="<%=application.getContextPath()%>/gymui/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=application.getContextPath()%>/gymui/css/modern-business.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!--<body>
<div w3-include-html="header.html"></div> 
<%--<%@include file="../ui/header.jsp"%>--%>
</body>-->
  </head>
  
 <body>
  <div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">Login
        <small>Admin</small>
      </h1>

      <ol class="breadcrumb">
<!--        <li class="breadcrumb-item">
          <a href="index.html">Home</a>
        </li>-->
        <li class="breadcrumb-item active">Login Admin</li>
      </ol>


      <h1 align="center">Admin</h1>
<div  align="center">
                   <div id="msg" style="color:green"><h2><%=msg%></h2></div>
      <form class="contact100-form validate-form" action ="Loginverify" method="post">
        
        <div class="wrap-input100 validate-input" data-validate = "Please enter your email: e@a.x" >
            <input class="input100" type="email" id="email" name="email" placeholder="E-mail"style="background-color:#d7dbe2;" required>
          <span class="focus-input100"></span>
        </div>

        <div class="wrap-input100 validate-input" data-validate = "Please enter the correct password" >
            <input class="input100" type="text" name="password" type="password" placeholder="password"style="background-color:#d7dbe2;" required>
          <span class="focus-input100"></span>
        </div>
        <div class="container-contact100-form-btn" style="padding: 20px;">
          <button class="contact100-form-btn" name="submit" >
            <span>
              <i class="fa fa-paper-plane-o m-r-6" aria-hidden="true"></i>
              login
            </span>
          </button>
        </div>
          </form>
    <form action ="<%=application.getContextPath()%>/gymui/loginpage/forgotpassword.jsp" method="post">
          <button class="contact100-form-btn" style="padding:20px; ">
            <span>
              <i class="fa fa-paper-plane-o m-r-6" aria-hidden="true"></i>
              Forgot Password
            </span>
          </button>
      
</body>
</div>
      </div>
 <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <!--<script src="<%=application.getContextPath()%>/gymui/vendor/jquery/jquery.min.js"></script>-->
    <script src="<%=application.getContextPath()%>/gymui/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    $(document).ready(function() {
       $().ready(function() {
       $("#email").focusout(function(){
  
   var email=$("#email").val();
//   alert(gymname)
if(email!=="")
{
   $.post("<%=application.getContextPath()%>/Verifygymname",{"email":email},function(data,status){
 alert("hello");
     alert(data);
  $("#email").val("");
    });
}
});

$("#msg").fadeOut(3000);
        $sidebar = $('.sidebar');
    });
    });
</script>
  </body>

</html>