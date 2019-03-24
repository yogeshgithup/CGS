<%@page session="false" %>
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
	<title>User Login</title>
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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
</head>
<body>
	
	
	<div class="container-login100" style="background-image: url('<%=application.getContextPath()%>/gymui/images/bg-01.jpg');">
		<div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
		 <div id="msg" style="color:green"><h2><%=msg%></h2></div>	
                    <form class="contact100-form validate-form" action ="<%=application.getContextPath()%>/Loginverifyuser" method="post">
				<span class="login100-form-title p-b-37">
					Sign In
				</span>

				<div class="wrap-input100 validate-input m-b-20" data-validate="Enter email">
					<input class="input100" type="text" id="email" name="email" placeholder="email">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input m-b-25" data-validate = "Enter password">
					<input class="input100" type="text"id="password" name="password" placeholder="password">
					<span class="focus-input100"></span>
				</div>
                                <input type="hidden" id="email1" name="email1">
                                <input type="hidden" id="password1" name="password1">
				<div class="container-login100-form-btn">
					<button class="login100-form-btn" id="submit">
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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="<%=application.getContextPath()%>/gymui/crypto-js/core-min.js"></script>
<script src="<%=application.getContextPath()%>/gymui/crypto-js/enc-utf16-min.js"></script>
<script src="<%=application.getContextPath()%>/gymui/crypto-js/enc-base64-min.js"></script>
<script src="<%=application.getContextPath()%>/gymui/crypto-js/aes.js"></script>
   
    <script>
    $(document).ready(function() {
       $().ready(function() {
         
       $("#email").focusout(function(){
  
   var email=$("#email").val();
//   alert(gymname)
if(email!=="")
{
    var y;
   $.post("<%=application.getContextPath()%>/Verifygymname",{"emailuser":email},function(data,status){
 alert("hello");
   alert(data);
    y=data;
  $("#email").val("");
    });
    
}
});
$("#submit").click(function(){
//alert("hello");
var key = CryptoJS.lib.WordArray.random(16);
        alert(key);
        var iv= CryptoJS.lib.WordArray.random(16);
var email=$("#email").val();
var password=$("#password").val();
//alert(email);
//alert(password);

var pass = CryptoJS.AES.encrypt(password, key, { iv: iv });
var encrypted =CryptoJS.AES.encrypt(email, key, { iv: iv });
encrypted=encrypted.ciphertext.toString();
       encrypted = CryptoJS.AES.encrypt( encrypted, key, { iv: iv });
        var cipherData = iv.toString(CryptoJS.enc.Base64)+":"+encrypted.ciphertext.toString()+":"+key.toString(CryptoJS.enc.Base64);
   
   pass=pass.ciphertext.toString();
       pass = CryptoJS.AES.encrypt( pass, key, { iv: iv });
        var cipherDatapass = iv.toString(CryptoJS.enc.Base64)+":"+pass.ciphertext.toString()+":"+key.toString(CryptoJS.enc.Base64);
   
$("#email1").val(cipherData);
$("#password1").val(cipherDatapass);
$("#key").val(key);
alert("encrypted email= "+cipherData);
alert("encrypted password= "+cipherDatapass);
//location.href="Loginverify?email="+encrypted+"&password="+encryptedpass+"&key="+key;
                    //$("#output").prepend("<br/>Encrypted: " + encrypted);
//                    var decrypted = CryptoJS.AES.decrypt(encrypted, secret);
//                    $("#output").prepend("<br/><br/> Original From Encrypted: " + decrypted.toString(CryptoJS.enc.Utf8));

});
 
$("#msg").fadeOut(3000);
        $sidebar = $('.sidebar');
    });
    });
</script>
		
	
	
	

	


</body>
</html>