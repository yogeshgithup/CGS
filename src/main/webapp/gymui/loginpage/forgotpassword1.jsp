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
	<title>Forgot Password</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="<%=application.getContextPath()%>/gymui/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/gymui/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
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
	<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/gymui/css/util2.css">
	<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/gymui/css/main2.css">
<!--===============================================================================================-->
</head>
<body>
	
	
	<div class="container-login100" style="background-image: url('<%=application.getContextPath()%>/gymui/images/bg-01.jpg');">
		<div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
		 <div id="msg" style="color:green"><h2><%=msg%></h2></div>	
                   <form class="contact100-form validate-form" action="<%=application.getContextPath()%>/Forgotpassword" method="post">
				<span class="login100-form-title p-b-37">
					FORGOT PASSWORD
				</span>

				<div class="wrap-input100 validate-input m-b-20" data-validate="Enter email">
					<input class="input100" type="text" id="email" name="email" placeholder="EMAIL">
					<span class="focus-input100"></span>
				</div>
				<div class="container-login100-form-btn">
					<button class="login100-form-btn">
						SUBMIT
					</button>
				</div>
			</form>
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
//   alert(gymname);
   $.post("<%=application.getContextPath()%>/Verifygymname",{"email":email},function(data,status){
 
     alert(data);
  $("#email").val("");
    });
});
    
    });
    });
    </script>
		
	
	
	

	


</body>
</html>