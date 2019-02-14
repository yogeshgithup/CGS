<!DOCTYPE html>

<html lang="en">
    
<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    GYM ADMIN
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
  <!-- CSS Files -->
  <link href="<%=application.getContextPath()%>/gymui/assets/css/bootstrap.min.css" rel="stylesheet" />
  <link href="<%=application.getContextPath()%>/gymui/assets/css/now-ui-dashboard.css?v=1.2.0" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="<%=application.getContextPath()%>/gymui/assets/demo/demo.css" rel="stylesheet" />
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script>
      $(document).ready(function(){
          
          
          var name = "first" + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(';');
  for(var i = 0; i <ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      first=c.substring(name.length, c.length);
//      alert(first);
    }
  }
  
   var name = "next" + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(';');
  for(var i = 0; i <ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
     next=c.substring(name.length, c.length);
//     alert(next);
    }
  }
//             var c= document.cookie.split(';');
//             if(c.length!=0){
//                 alert(c);
//               
//                 for(var i = 0; i < ca.length; i++) {
//    var c1 = c[i];
//            alert(c1);
//        }   
//             }
          
//      alert("hello");
     
    // alert(x);
          //$( "li.active" ).removeClass( "active" ).addClass( "" );
//      alert("hello...."); 
//     var x= $( "li" ).each(function() {
//     //    alert(x);
//     var xn=x.length;
//     alert(xn);
//          $( "li" ).click(function(){

 
$("li").click(function(){
//   alert("Hello World"); 
  var n= $(this).parent();
  var x=$(this).parent().children();
 len=x.length;
 index=-1;
 thisid=$(this).attr('id');
 var oldli=null;
 var newli=null;
 for(i=0;i<len;i++)
 {
    if($(x[i]).attr('id')===thisid)
     {
         
 document.cookie = "next="+i;
            }
            
     
     if($(x[i]).attr('class')==='active')
     {
         
           document.cookie = "first="+i;
     }
 }
 
});
//   var column1RelArray = [];
//$('#ul li').each(function(){
//    column1RelArray.push($(this).attr('id'));
//    alert(column1RelArray);
//});
    
//      alert("hello....");
     
    
     
//           $( this ).addClass( "active" );
//           $( "li.active" ).prev().removeClass( "active" ).addClass( "" );
//          }); 
//$( "li.active" ).removeClass( "active" ).addClass( "" );
});
  </script>
  
</head>

<body class="">
  <div class="wrapper ">
    <div class="sidebar" data-color="orange">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
    -->
      <div class="logo">
        <a href="#" class="simple-text logo-mini">
          
        </a>
        <a href="#" class="simple-text logo-normal">
            <%
            String name=(String)session.getAttribute("gymname");
            %>
            <%=name%>
        </a>
      </div>
      <div class="sidebar-wrapper" id="myDIV">
        <ul class="nav" id="ul">
          <li class="active" id="1">
            <a href="<%=application.getContextPath()%>/Viewbranch">
              <i class="now-ui-icons design_app "></i>
              <p>Manage Branches</p>
            </a>
          </li>
          <li class="" id="2">
            <a href="<%=application.getContextPath()%>/Viewbranchoperator">
              <i class="now-ui-icons education_atom"></i>
              <p>Manage Branch Operator</p>
            </a>
          </li>
          <li class="" id="3">
            <a href="<%=application.getContextPath()%>/Viewfacilities?msg=facility">
              <i class="now-ui-icons location_map-big"></i>
              <p>Manage Facilities </p>
            </a>
          </li>
          <li class="" id="4">
            <a href="<%=application.getContextPath()%>/Viewgympackage?msg=package">
              <i class="now-ui-icons location_map-big"></i>
              <p>Manage Package </p>
            </a>
          </li>
          
          <li class="" id="5">
            <a href="<%=application.getContextPath()%>/gymui/pannel/mainpageediting1.jsp">
              <i class="now-ui-icons location_map-big"></i>
              <p>Main Page Editing </p>
            </a>
          </li>
          <li class="" id="6">
            <a href="<%=application.getContextPath()%>/gymui/pannel/aboutusediting1.jsp">
              <i class="now-ui-icons location_map-big"></i>
              <p>About Us Editing</p>
            </a>
          </li>
          <li class="" id="7">
            <a href="<%=application.getContextPath()%>/gymui/pannel/equipmentediting1.jsp">
              <i class="now-ui-icons location_map-big"></i>
              <p>Equipment Editing </p>
            </a>
          </li>
          <li class="" id="8">
            <a href="./map.html">
              <i class="now-ui-icons location_map-big"></i>
              <p>View Graphs</p>
            </a>
          </li>
        </ul>
      </div>
    </div>
    <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg fixed-top navbar-transparent  bg-primary  navbar-absolute">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <div class="navbar-toggle">
              <button type="button" class="navbar-toggler">
                <span class="navbar-toggler-bar bar1"></span>
                <span class="navbar-toggler-bar bar2"></span>
                <span class="navbar-toggler-bar bar3"></span>
              </button>
            </div>
            <a class="navbar-brand" href="#pablo">GYM ADMIN</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end" id="navigation">
            <form>
              <div class="input-group no-border">
                <input type="text" value="" class="form-control" placeholder="Search...">
                <div class="input-group-append">
                  <div class="input-group-text">
                    <i class="now-ui-icons ui-1_zoom-bold"></i>
                  </div>
                </div>
              </div>
            </form>
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="#pablo">
                  <i class="now-ui-icons media-2_sound-wave"></i>
                  <p>
                    <span class="d-lg-none d-md-block">Stats</span>
                  </p>
                </a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="now-ui-icons location_world"></i>
                  <p>
                    <span class="d-lg-none d-md-block">Some Actions</span>
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                  <a class="dropdown-item" href="#">Action</a>
                  <a class="dropdown-item" href="#">Another action</a>
                  <a class="dropdown-item" href="#">Something else here</a>
                </div>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<%=application.getContextPath()%>/Logout">
                  <i class="now-ui-icons users_single-02"></i>
                  <p>
                    <span class="d-lg-none d-md-block">Account</span>
                  </p>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
     
      <!-- End Navbar -->
      <div class="panel-header panel-header-sm">
      </div>
      
   
  
  
  <!--   Core JS Files   -->
  <script src="<%=application.getContextPath()%>/gymui/assets/js/core/jquery.min.js"></script>
  <script src="<%=application.getContextPath()%>/gymui/assets/js/core/popper.min.js"></script>
  <script src="<%=application.getContextPath()%>/gymui/assets/js/core/bootstrap.min.js"></script>
  <script src="<%=application.getContextPath()%>/gymui/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!--  Google Maps Plugin    -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Chart JS -->
  <script src="<%=application.getContextPath()%>/gymui/assets/js/plugins/chartjs.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="<%=application.getContextPath()%>/gymui/assets/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="<%=application.getContextPath()%>/gymui/assets/js/now-ui-dashboard.min.js?v=1.2.0" type="text/javascript"></script>
  <!-- Now Ui Dashboard DEMO methods, don't include it in your project! -->
  <script src="<%=application.getContextPath()%>/gymui/assets/demo/demo.js"></script>
    <script src="<%=application.getContextPath()%>/gymui/js/mycontrol.js"></script>
</body>

</html>