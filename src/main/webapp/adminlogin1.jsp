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
	<title>Admin Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/gymui/css/util2.css">
	<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/gymui/css/main2.css">
<!--===============================================================================================-->
</head>
<body>
	
	
	<div class="container-login100" style="background-image: url('<%=application.getContextPath()%>/gymui/images/bg-01.jpg');">
		<div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
		 <div id="msg" style="color:green"><h2><%=msg%></h2></div>	
                    <form class="login100-form validate-form" action ="Loginverify" method="post">
				<span class="login100-form-title p-b-37">
					Sign In
				</span>

				<div class="wrap-input100 validate-input m-b-20" data-validate="Enter email">
					<input class="input100" type="text" id="email" name="email" placeholder="email">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input m-b-25" data-validate = "Enter password">
					<input class="input100" type="text" name="password" placeholder="password">
					<span class="focus-input100"></span>
				</div>

				<div class="container-login100-form-btn">
					<button class="login100-form-btn">
						Sign In
					</button>
				</div>
			</form>

			 <form action ="<%=application.getContextPath()%>/gymui/loginpage/forgotpassword1.jsp" method="post">
          <button class="contact100-form-btn" style="padding:20px;">
              
            <span>
              <i class="fa fa-paper-plane-o m-r-4" aria-hidden="true"></i>
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