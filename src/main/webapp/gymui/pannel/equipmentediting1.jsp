
<%@page import="com.mycompany.loginmodule.Addpackage"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%
  
    String msg=request.getParameter("msg");
      if(msg==null)
      {
          msg="";
      }
        %>
<html lang="en">

 <script language = "Javascript">
    function validateEmail()  
{  
var x=document.frmSample.username.value;  
var atposition=x.indexOf("@");  
var dotposition=x.lastIndexOf(".");  
if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
  alert("Please enter a valid e-mail address");  
  return false;  
  }  
}  
/**
 * DHTML phone number validation script. Courtesy of SmartWebby.com (http://www.smartwebby.com/dhtml/)
 */

// Declaring required variables
var digits = "0123456789";
// non-digit characters which are allowed in phone numbers
var phoneNumberDelimiters = "()- ";
// characters which are allowed in international phone numbers
// (a leading + is OK)
var validWorldPhoneChars = phoneNumberDelimiters + "+";
// Minimum no of digits in an international phone no.
var minDigitsInIPhoneNumber = 10;

function isInteger(s)
{   var i;
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}
function trim(s)
{   var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not a whitespace, append to returnString.
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character isn't whitespace.
        var c = s.charAt(i);
        if (c != " ") returnString += c;
    }
    return returnString;
}
function stripCharsInBag(s, bag)
{   var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character isn't whitespace.
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function checkInternationalPhone(strPhone){
var bracket=3
strPhone=trim(strPhone)
if(strPhone.indexOf("+")>1) return false
if(strPhone.indexOf("-")!=-1)bracket=bracket+1
if(strPhone.indexOf("(")!=-1 && strPhone.indexOf("(")>bracket)return false
var brchr=strPhone.indexOf("(")
if(strPhone.indexOf("(")!=-1 && strPhone.charAt(brchr+2)!=")")return false
if(strPhone.indexOf("(")==-1 && strPhone.indexOf(")")!=-1)return false
s=stripCharsInBag(strPhone,validWorldPhoneChars);
return (isInteger(s) && s.length >= minDigitsInIPhoneNumber);
}

function ValidateForm(){
	var Phone=document.frmSample.phoneno
	
	if ((Phone.value==null)||(Phone.value=="")){
		alert("Please Enter your Phone Number")
		Phone.focus()
		return false
	}
	if (checkInternationalPhone(Phone.value)==false){
		alert("Please Enter a Valid Phone Number")
		Phone.value=""
		Phone.focus()
		return false
	}
	return true
 }
</script>
<body class="user-profile">
   <%@include file="/gymui/headers/gymadmindashboard.jsp" %>
      <div class="content">
        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header">
                   <div id="msg" style="color:green"><h2><%=msg%></h2></div>
                <h5 class="title">EQUIPMENT DETAIL</h5>
              </div>
              <div class="card-body">
                  <form action="<%=application.getContextPath()%>/Addequipment" method="post" enctype="multipart/form-data">
                      <div id="equid">
                  <div class="row">
                    <div class="col-md-6 px-1">
                      <div class="form-group">
                        <label>Equipment Name</label>
                        <input type="text" class="form-control" name="title" required="Equipment Name Required" placeholder="Equipment Name">
                      </div>
                    </div>
                      <div class="col-md-3 px-1">
                      <div class="form-group">
                          <button id="btn2" class="btn btn-primary btn-block">ADD MORE</button>   
                      </div>
                           
                       </div>
                  </div>
                                <div class="row">
                                <div class="col-md-3">
                        <label for="file-multiple-input" class=" form-control-label">Equipment Image</label></div>
                            <div  class="col-md-4"><input type="file" id="file-multiple-input" name="equimage" multiple="" class="form-control-file "></div>
                      </div>
                      <div class="row">
                    <div class="col-md-12 px-1">
                      <div class="form-group">
                        <label>Equipment Description</label>
                        <input type="text" class="form-control" name="desc" required="Equipment Description Required" placeholder="Equipment Description">
                      </div>
                    </div>
                      </div>
                                     </div>
          
              </div>
                               
                      
                      
<!--                    <div class="col-md-6 pl-1">
                      <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="email" class="form-control" placeholder="Email">
                      </div>
                    </div>-->
                
                  <div class="row">
                   
                    <div class="col-md-6 px-1">
                     
                    </div>
                      <div class="col-md-6 px-1">
                     
                    </div>
                  </div>
                
                    <div class="row">
                        <div class="col-md-4 pl-1" >
                            
                        </div>
                   <div class="col-md-4 pl-1" >
                      <div class="form-group">
                          <button type="submit" class="btn btn-primary btn-block">SUBMIT</button>   
                      </div>
                   </div>
                    </div>
          
            </div>
          </div>
          <div class="col-md-4">
            <div class="card card-user">
              <div class="image">
                <img src="../assets/img/bg5.jpg" alt="...">
              </div>
              <div class="card-body">
                <div class="author">
                  <a href="#">
                    <img class="avatar border-gray" src="../assets/img/mike.jpg" alt="...">
                    <h5 class="title">Mike Andrew</h5>
                  </a>
                  <p class="description">
                    michael24
                  </p>
                </div>
                <p class="description text-center">
                  "Lamborghini Mercy
                  <br> Your chick she so thirsty
                  <br> I'm in that two seat Lambo"
                </p>
              </div>
              <hr>
              <div class="button-container">
                <button href="#" class="btn btn-neutral btn-icon btn-round btn-lg">
                  <i class="fab fa-facebook-f"></i>
                </button>
                <button href="#" class="btn btn-neutral btn-icon btn-round btn-lg">
                  <i class="fab fa-twitter"></i>
                </button>
                <button href="#" class="btn btn-neutral btn-icon btn-round btn-lg">
                  <i class="fab fa-google-plus-g"></i>
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div>
</body>
<script>
    $(document).ready(function() {
      $().ready(function() {
var ctrld1=1;
    $('#btn2').click(function(evt){
        evt.preventDefault();
        alert(ctrld1);
        mydiv1=hello('d'+ctrld1);
        alert(mydiv1);
        fctrl=createTextbox4('f'+ctrld1);
        alert(fctrl);
        fctrl1= createFile1('f'+ctrld1);
        alert(fctrl1);
         sctrl=createTextarea3('s'+ctrld1);
        alert(sctrl);
        btnctrl=createButton1("b"+ctrld1);
        $(btnctrl).click(function()
        {
            alert("remove me");
            var par=$(this).parent();
            par.remove();
        });
      //  mydiv1.append('<div  class="col-md-2">');
     //   mydiv1.append('<div  class="col-md-4">');
        mydiv1.append('<label class=" form-control-label">Equipment Image</label>').append(fctrl1);
        mydiv1.append(fctrl).append('</div>');
       
        mydiv1.append('').append(sctrl).append('</div>');
          mydiv1.append(btnctrl).append('</div></div>');
        mydiv1.append('');
    
        alert( $("#equid"));
        $("#equid").append(mydiv1);
        ctrld1++;
        });

});
});
</script>
</html>