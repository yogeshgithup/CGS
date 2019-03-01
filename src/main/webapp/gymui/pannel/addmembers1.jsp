
<%@page import="com.mycompany.loginmodule.Gympackage"%>
<%@page import="com.mycompany.loginmodule.Addbranch"%>
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
   <%@include file="/gymui/headers/branchoperatordashboard.jsp" %>
      <div class="content">
        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header">
                   <div id="msg" style="color:green"><h2><%=msg%></h2></div>
                <h5 class="title">ADD MEMBERS</h5>
              </div>
              <div class="card-body">
                  <form action="<%=application.getContextPath()%>/Addmembers" method="post">
                  <div class="row">
                    
                   
                    <div class="col-md-6 px-1">
                      <div class="form-group">
                        <label>First Name</label>
                        <input type="text" class="form-control" name="firstname" required="First Name Required" placeholder="First Name">
                      </div>
                    </div>
                      <div class="col-md-6 px-1">
                      <div class="form-group">
                        <label>Middle Name</label>
                        <input type="text" class="form-control" name="middlename" required="Middle Name Required" placeholder="Middle Name">
                      </div>
                    </div>
<!--                    <div class="col-md-6 pl-1">
                      <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="email" class="form-control" placeholder="Email">
                      </div>
                    </div>-->
                  </div>
                  <div class="row">
                   <div class="col-md-6 px-1">
                      <div class="form-group">
                        <label>Last Name</label>
                        <input type="text" class="form-control" name="lastname" required="Last Name Required" placeholder="Last Name">
                      </div>
                    </div>
                    
                   <div class="col-md-6 px-1">
                      <div class="form-group">
                        <label>Phone No</label>
                        <input type="number" class="form-control" name="phoneno" required="Gym Owner Enter Phone Number" placeholder="Phone Number">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                   <div class="col-md-4 px-1">
                      <div class="form-group">
                        <label>Area</label>
                        <input type="text" class="form-control" name="area" id="area" required="Area Name Required" placeholder="Area">
                      </div>
                    </div>
                  
                        <div class="col-md-4 px-1">
                      <div class="form-group">
                        <label>Street</label>
                        <input type="text" class="form-control" name="street" id="street" required="Street name required" placeholder="Street Name">
                      </div>
                    </div>
                       <div class="col-md-4 px-1">
                      <div class="form-group">
                        <label>Postal Code</label>
                        <input type="number" class="form-control" name="postal" required="Postal code required" placeholder="Postal Code">
                      </div>
                    </div>
                     
                  </div>
                  <div class="row">
                   <div class="col-md-4 pl-1">
                      <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="email" name="email" id="email" class="form-control" placeholder="Email" required>
                      </div>
                    </div>
                      <div class="col-md-4 pl-1">
                      <div class="form-group">
                          <label >Date Of Birth</label>
                        <input type="date" name="dob"class="form-control">
                      </div>
                    </div>
                      <div class="col-md-4 pl-1">
                      <div class="form-group">
                          <label >Health issues</label>
                          <input type="text" name="healthissue"class="form-control" placeholder="health issue" required>
                      </div>
                    </div>
                      </div>
                    <div class="row">
                        <div class="col-md-4 pl-1" >
                          <div class="form-group">
                          <label >Blood Group</label>
                          <input type="text" name="bloodgroup"class="form-control"placeholder="blood group" required>
                      </div>  
                        </div>
                   <div class="col-md-4 pl-1" >
                      <div class="form-group">
                          <label >Height in CM</label>
                          <input type="text" name="height"class="form-control" placeholder="height" required>
                      </div>  
                   </div>
                         <div class="col-md-4 pl-1" >
                      <div class="form-group">
                          <label >Weight</label>
                          <input type="text" name="weight" class="form-control" placeholder="weight" required>
                      </div>  
                   </div>
                    </div>
                    <div class="row">
                   <div class="col-md-4 pl-1">
                      <div class="form-group">
                   <label for="sel1">Select list (select one):</label>
      <select class="form-control" id="pack" name="package">
          <%!
           HashSet<Gympackage> packagee=null;
          %>
   
          
              <%
         
          System.out.println("session="+session); 
          System.out.println("setbranch...="+packagee);
              
             packagee=(HashSet<Gympackage>)session.getAttribute("viewpackfacility");
             if(packagee!=null)
             {
              System.out.println("setbranch...="+packagee);
            Iterator<Gympackage> it=packagee.iterator();
            System.out.println("kkkk");
            if(it!=null)
            {
            while(it.hasNext())
            {
                Gympackage se=it.next();
                if(se!=null)
                {
           
          %>
       <option value="<%=se.getName()%>"><%=se.getName()%></option>
<% }}}}%>
      </select>
                      </div>
                   </div>
                    </div>
                  </div>
                    <div class="row">
                        <div class="col-md-4 pl-1" >
                            
                        </div>
                   <div class="col-md-4 pl-1" >
                      <div class="form-group">
                          <button type="submit" id="s1" class="btn btn-primary btn-block">ADD MEMBER</button>   
                      </div>
                   </div>
                    </div>
                </form>
              
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
          $("#email").focusout(function(){
  
   var email=$("#email").val();

//   alert(gymname)
if(email!=="")
{
   $.post("<%=application.getContextPath()%>/Verifygymname",{"useremail":email},function(data,status){
     var y=data;
     
     if(y.match("noo"))
     {
    
        }
        else
        {
          alert("Already Exist");
  $("#email").val("");
        }
        });
}
});
          
          
          
           $("#bname").focusout(function(){
  // alert("hello");
   var branchname=$("#bname option:selected").val();
//   alert(gymname);
   $.post("<%=application.getContextPath()%>/Verifygymname",{"bname":branchname},function(data,status){
 
     alert(data);
  $("#bname").val("");
    });
});
});
});
</script>
</html>