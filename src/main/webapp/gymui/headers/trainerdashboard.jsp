<%@page import="com.mycompany.loginmodule.Trainer"%>
<!DOCTYPE html>
<%

 response.setHeader("Cache-Control","no-cache");
     response.setHeader("Cache-Control","no-store");
     response.setDateHeader("Expires", 0);
     response.setHeader("Pragma","no-cache");
     session=request.getSession(false);
     try{
      int id111=Integer.parseInt(session.getAttribute("sessss").toString());
      String id1=String.valueOf(id111);
     System.out.println("...----id"+id1);
        
    if( id1.equals("0"))
    {
      System.out.println("------uuu-----"+application.getContextPath()+"/gymui/pannel/userlogin.jsp?msg=you already logout");
         
                request.setAttribute("Error","Session has ended");
                response.sendRedirect(application.getContextPath()+"/gymui/pannel/userlogin.jsp?msg=you already logout");
             
    }
    else
    {
       
    }
     }
     catch(Exception e)
     {
          request.setAttribute("Error","Session has ended");
         System.out.println("-----------");
         System.out.println(application.getContextPath()+"/adminlogin1.jsp?msg=loggedout");
            response.sendRedirect(application.getContextPath()+"/gymui/pannel/userlogin.jsp?msg=you already logout");
                  
     }
%>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    TRAINER
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
   alert("Hello");
     var href = document.location.href;
var lastPathSegment = href.substr(href.lastIndexOf('/') + 1);  
var newString = lastPathSegment.split('?', 1)[0];
alert(newString);
    <% 
    int n;
    Trainer t = (Trainer) session.getAttribute("trainer");
   if(t!=null)
   {
      n=t.getId();
   }
   else
       n=0;
    %>
            var n='<%=n%>';
            alert(n);
           if(n!==0)
           {
         $.post("<%=application.getContextPath()%>/Hitcounter", {jspname: newString,userid: n,type: "Trainer"}, function(data,status){
   
  });
  }
  });
  </script>
</head>

<body class="dark-edition">
    
    <div class="wrapper ">
    <div class="sidebar" data-color="orange">
<!--  <div class="wrapper ">
    <div class="sidebar" data-color="danger" data-background-color="black" data-image="<%=application.getContextPath()%>/gymui/images/sidebar-2.jpg">
      
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
     <%
             Trainer t=(Trainer)session.getAttribute("trainer");
              
              %>
      <div class="logo">
        <a href="#" class="simple-text logo-normal">
          TRAINER <%= t.getFirstname()%>
        </a>

             
          
      </div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          
         <li>
            <a href="<%=application.getContextPath()%>/Viewdiet?op=msg">
              <i class="now-ui-icons design_app"></i>
              <p>Manage Diet Plan</p>
            </a>
          </li>
 <li class="" id="7">
            <a href="<%=application.getContextPath()%>/gymui/pannel/changepasswordtrainer.jsp">
              <i class="now-ui-icons location_map-big"></i>
              <p>Change Password </p>
            </a>
          </li>
           <li>
            <a href="">
              <i class="now-ui-icons design_app"></i>
              <p>View Graphs</p>
            </a>
          </li>
        
        </ul>
      </div>
    </div>
    <div class="main-panel">
      
        
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
            <a class="navbar-brand" href="#pablo">TRAINER</a>
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
                <a class="nav-link" href="<%=application.getContextPath()%>/Logout?op=user">
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
</body>

</html>