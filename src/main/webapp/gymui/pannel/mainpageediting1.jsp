
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
                <h5 class="title">MAIN PAGE EDITING</h5>
              </div>
              <div class="card-body">
                   <form action="<%=application.getContextPath()%>/Aaddgyminfo" method="post" enctype="multipart/form-data">
                  <div class="row">
                    
                   
                 <div class="col-md-2">
                        <label for="file-multiple-input" class=" form-control-label">Logo</label></div>
                            <div  class="col-md-5"><input type="file" id="file-multiple-input" name="logo" class="form-control-file "></div>
                      </div>
                  <div id="slide">
                  <div class="row">
                   
                  
                     <div class="col-md-2">
                        <label for="file-multiple-input" class=" form-control-label">Slider Image</label></div>
                            <div  class="col-md-5"><input type="file" id="file-multiple-input" name="image" class="form-control-file "></div>

                      <div class="col-md-3 px-1">
                      <div class="form-group">
                          <button id="button1" class="btn btn-primary btn-block">ADD MORE</button>   
                      </div>
                           
                       </div>
                  </div>
                 <div class="row">
                  <div class="col-md-6">
                            <div class="form-group">
                          <label class="bmd-label-floating">Imageslider Description</label>
                          <input type="text" name="imagedesc" placeholder="Image Slider Description" class="form-control">
                        </div>
                            </div>                    
                 
                 </div>
                  </div>
                    <div class="row">
                      <div class="col-md-6">
                        <h4 align="center">ACHIEVEMENT</h4>
                            </div>
                  
                    </div>
                         <div id="achievement">
                  <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Achievement Title</label>
                          <input type="text" placeholder="Achievement Title" class="form-control" name="title">
                        </div>
                      </div>                           
                     <div class="col-md-3 px-1">
                      <div class="form-group">
                          <button id="button2" class="btn btn-primary btn-block">ADD MORE</button>   
                      </div>
                           
                       </div>
                  
                  </div>
                    <div class="row">
                     <div class="col-md-6">
                          <div class="form-group">
                        <label for="comment" class="bmd-label-floating">Achievement Description:</label>
                       <input type="text" name="descr" placeholder="Achievement Description" class="form-control" name="title">
                          </div>
                        </div>
                      </div>
                         </div>
                        <div class="row">                      
                      <div class="col-md-6">
                           <h4 align="center">QUALITY MESSAGE</h4>
                        <div class="form-group">
                          <label class="bmd-label-floating">Quality Message</label>
                          <input type="text" placeholder="Quality Message" class="form-control" name="qualitymsg">
                        </div>
                      </div>
                        </div>
                    <div class="row">
                        <div class="col-md-4 pl-1" >
                            
                        </div>
                   <div class="col-md-4 pl-1" >
                      <div class="form-group">
                          <button type="submit" id="s1" class="btn btn-primary btn-block">SUBMIT</button>   
                      </div>
                   </div>
                    </div>
                  
                
                </form>
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
           var ctrld=1;
    $('#button1').click(function(evt){
        evt.preventDefault();
        alert(ctrld);
        mydiv=createDiv('d'+ctrld);
        alert(mydiv);
        fctrl=createFile('f'+ctrld);
        alert(fctrl);
         sctrl=createTextbox1('s'+ctrld);
        alert(sctrl);
        btnctrl=createButton("b"+ctrld);
        $(btnctrl).click(function()
        {
            alert("remove me");
            var par=$(this).parent();
            par.remove();
        });
        mydiv.append('<div class="row"><div  class="col-md-2">').append('<label class=" form-control-label">Slider Image</label>');
        mydiv.append('<div  class="col-md-3">').append(fctrl).append('<div class="col-md-3>');
        mydiv.append(btnctrl).append('</div></div>');
        mydiv.append('<div class="row"><div  class="col-md-6">').append(sctrl).append('</div></div></div>');
        mydiv.append('');
        
        alert( $("#slide"));
        $("#slide").append(mydiv);
        ctrld++;
        });
});
});
 var ctrld1=1;
    $('#button2').click(function(evt){
        evt.preventDefault();
        alert(ctrld1);
        mydiv1=createDiv2('d'+ctrld1);
        alert(mydiv1);
        fctrl=createTextbox2('f'+ctrld1);
        alert(fctrl);
         sctrl=createTextarea2('s'+ctrld1);
        alert(sctrl);
        btnctrl=createButton2("b"+ctrld1);
        $(btnctrl).click(function()
        {
            alert("remove me");
            var par=$(this).parent();
            par.remove();
        });
      //  mydiv1.append('<div  class="col-md-2">');
        mydiv1.append('<div  class="col-md-6">');
      //  mydiv1.append(fctrl).append('</div>');
        mydiv1.append(fctrl);
      
        mydiv1.append('<div  class="col-md-6">').append(sctrl).append('</div></div>');
          mydiv1.append(btnctrl).append('</div>');
        mydiv1.append('');
        
        alert( $("#achievement"));
        $("#achievement").append(mydiv1);
        ctrld1++;
        });
</script>
</html>