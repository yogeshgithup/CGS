<%-- 
    Document   : gymadmin
    Created on : Oct 11, 2018, 11:49:52 AM
    Author     : sneh pael
--%>

<%@page import="com.mycompany.loginmodule.Pack_facility"%>
<%@page import="java.util.Set"%>
<%@page import="com.mycompany.loginmodule.Gympackage"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mycompany.loginmodule.Addbranch"%>
<%@page import="java.util.HashSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control","no-cache");
     response.setHeader("Cache-Control","no-store");
     response.setDateHeader("Expires", 0);
     response.setHeader("Pragma","no-cache");
     System.out.println("{{{{{");
     
    Integer id=(Integer)session.getAttribute("gymid");
    System.out.println("...id...+"+id);
            if(id==null)
            {
                System.out.println("eeee");
                request.setAttribute("msg","Session has ended");
                RequestDispatcher rd=request.getRequestDispatcher("/adminlogin.jsp");
                rd.forward(request, response);
                System.out.println("uuuu");
            }
    %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="<%=application.getContextPath()%>/gymui/images/apple-icon.png">
  <link rel="icon" type="image/png" href="<%=application.getContextPath()%>/gymui/images/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    GYM ADMIN
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
   <link rel="stylesheet" href="<%=application.getContextPath()%>/gymui/css/table.css">
  <!-- CSS Files -->
  <link href="<%=application.getContextPath()%>/gymui/css/material-dashboard.css?v=2.1.0" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="<%=application.getContextPath()%>/gymui/css/demo.css" rel="stylesheet" />
<style>
    .popup{         
  background-color:#913f9e;
  z-index: 10000;
  cursor: pointer;
  margin: auto;
  padding: 0;
  box-shadow: 10px 10px 60px #555;
  display: inline-block;
  border-radius: 8px;
  max-width: 551px;
  min-height:100px;
  text-align: center;
  font-weight: bold;
  color: black;
  vertical-align: middle;
   box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
  -webkit-animation-name: animatetop;
  -webkit-animation-duration: 0.4s;
  animation-name: animatetop;
  animation-duration: 1s        
    }
 @-webkit-keyframes animatetop {
  from {top:-300px; opacity:0} 
  to {top:0; opacity:1}
}

@keyframes animatetop {
  from {top:-300px; opacity:0}
  to {top:0; opacity:1}
}

    </style>

</head>

<body class="dark-edition">
  <div class="wrapper ">
    <div class="sidebar" data-color="danger" data-background-color="black" data-image="<%=application.getContextPath()%>/gymui/images/sidebar-2.jpg">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo">
        <a href="#" class="simple-text logo-normal">
           GYM NAME
        </a>
      </div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <!-- <li class="nav-item active  ">
            <a class="nav-link" href="./dashboard.html">
              <i class="material-icons">dashboard</i>
              <p>Dashboard</p>
            </a>
          </li> -->
          <li class="nav-item dropdown">
                <a class="nav-link " href="<%=application.getContextPath()%>/Viewbranch">
                  <i class="material-icons "></i>
                  <span class="notification">Manage Branches</span>
                  <p class="d-lg-none d-md-block">
                    Manage Branches
                  </p>
                </a>
              </li>

          <!-- <li class="nav-item active " >
            <a class="nav-link" href="./user.html">
              <i class="material-icons"></i>
              <p>Manage Branches</p>
            </a>
          </li> -->
         <li class="nav-item ">
            <a class="nav-link" href="<%=application.getContextPath()%>/Viewbranchoperator">
              <i class="material-icons"></i>
              <p>Manage Branch Operator</p>
            </a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="<%=application.getContextPath()%>/Viewfacilities">
              <i class="material-icons"></i>
              <p>Manage Facilities</p>
            </a>
          </li>
           <li class="nav-item active">
            <a class="nav-link" href="<%=application.getContextPath()%>/Viewgympackage">
              <i class="material-icons"></i>
              <p>Manage Package</p>
            </a>
          </li>
          <li class="nav-item dropdown">
                <a class="nav-link " href="" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="material-icons "></i>
                  <span class="notification">Home Page Editing</span>
                  <p class="d-lg-none d-md-block">
                    Home Page Editing
                  </p>
                </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                 <a class="dropdown-item active" href="<%=application.getContextPath()%>/gymui/pannel/mainpageediting.jsp">Main Page Editing</a>
                   <a class="dropdown-item active" href="<%=application.getContextPath()%>/gymui/pannel/aboutusediting.jsp">About Us Editing</a>
                     <a class="dropdown-item active" href="<%=application.getContextPath()%>/gymui/pannel/contactusediting.jsp">Contact Us Editing</a>
                       <a class="dropdown-item active" href="<%=application.getContextPath()%>/gymui/pannel/equipmentediting.jsp">Equipment Editing</a>
                  
                </div>
              </li>
         
          <li class="nav-item ">
            <a class="nav-link" href="./map.html">
              <i class="material-icons"></i>
              <p>View Graphs</p>
            </a>
          </li>
         
          <!-- <li class="nav-item active-pro ">
                <a class="nav-link" href="./upgrade.html">
                    <i class="material-icons">unarchive</i>
                    <p>Upgrade to PRO</p>
                </a>
            </li> -->
        </ul>
      </div>
    </div>
    <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top " id="navigation-example">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <a class="navbar-brand" href="javascript:void(0)">Manage Gym Package</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation" data-target="#navigation-example">
            <span class="sr-only">Toggle navigation</span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end">
            <form class="navbar-form">
              <div class="input-group no-border">
                <input type="text" value="" class="form-control" placeholder="Search...">
                <button type="submit" class="btn btn-default btn-round btn-just-icon">
                  <i class="material-icons">search</i>
                  <div class="ripple-container"></div>
                </button>
             
            </form>
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="javascript:void(0)">
                  <i class="material-icons">dashboard</i>
                  <p class="d-lg-none d-md-block">
                    Stats
                  </p>
                </a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link" href="javscript:void(0)" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="material-icons">notifications</i>
                  <span class="notification">5</span>
                  <p class="d-lg-none d-md-block">
                    Some Actions
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                  <a class="dropdown-item" href="javascript:void(0)">Mike John responded to your email</a>
                  <a class="dropdown-item" href="javascript:void(0)">You have 5 new tasks</a>
                  <a class="dropdown-item" href="javascript:void(0)">You're now friend with Andrew</a>
                  <a class="dropdown-item" href="javascript:void(0)">Another Notification</a>
                  <a class="dropdown-item" href="javascript:void(0)">Another One</a>
                </div>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<%=application.getContextPath()%>/gymui/pannel/logout.jsp">
                  <i class="material-icons">logout</i>
                  <p class="d-lg-none d-md-block">
                    Account
                  </p>
                </a>
                  
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-xl-12 col-lg-12">
                <div class="col-sm-4"> 
                        <a href="<%=application.getContextPath()%>/Facpackage"> <button type="button" class="btn btn-primary pull-right">ADD Package
                        </button></a>
                        </div>
            </div>
              
 <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title" align="Center">PACKAGE LIST</h4>
                  <p class="card-category"></p>
                </div>
                 <table id="gym"  class="display" style="width:100%; color: purple;">
                   <thead>
                      <th>packageID</th>
                      <th>packageName</th>
                      <th>packageamount</th>
                      <th>packagetime</th>
                      <th>facilities</th>

                    </thead>
                    <tbody>
                                          <%!
           HashSet<Gympackage> setbranch=null;
          %>
   
          
              <%
         
          System.out.println("session="+session); 
          
              
             setbranch=(HashSet<Gympackage>)session.getAttribute("viewpackfacility");
            Iterator<Gympackage> it=setbranch.iterator();
            System.out.println("kkkk");
            while(it.hasNext())
            {
                Gympackage adbranch=it.next();
            // Set<Pack_facility> pf= adbranch.getPackfac();
            // Iterator iti=pf.iterator();
             //System.out.println("kkkkkllllll"+iti.toString());
          %>

          <tr id="<%=adbranch.getId()%>">
                          <td id="rowid"><%= adbranch.getId()%></td>
                          <td><%= adbranch.getName()%></td>
                           <td><%= adbranch.getAmount()%></td>
                            <td><%=adbranch.getTime()%></td>
                            <td> <a  href="#"  class="view" id="<%=adbranch.getId()%>" style="color:black">view facilities</a>
                            </td>
                     
    
          
          </tr>
                      <%}%>
                    </tbody>
                  </table>
                </div>
                    

            </div>
                  
            <div class="col-xl-4 col-lg-12">
                <div id="dialog" > 
                    
                        <p id="popid" class="popup" ><b></p></b>
</div>
                    

            </div>
            <div class="col-xl-4 col-lg-12">
              


            </div>
          </div>
          <div class="row">
            <div class="col-xl-3 col-lg-6 col-md-6 col-sm-6">
              

            </div>
            <div class="col-xl-3 col-lg-6 col-md-6 col-sm-6">
              


            </div>
            <div class="col-xl-3 col-lg-6 col-md-6 col-sm-6">
              


            </div>
            <div class="col-xl-3 col-lg-6 col-md-6 col-sm-6">
              

          </div>
          <div class="row">
            <div class="col-lg-6 col-md-12">
              


            </div>
            <div class="col-lg-6 col-md-12">
              
        </div>
               
      </div>
      
      
      <script>
        const x = new Date().getFullYear();
        let date = document.getElementById('date');
        date.innerHTML = '&copy; ' + x + date.innerHTML;
      </script>
    </div>
  </div>
                   
  <div class="fixed-plugin">
    <div class="dropdown show-dropdown">
      <a href="#" data-toggle="dropdown">
        <i class="fa fa-cog fa-2x"> </i>
      </a>
      <ul class="dropdown-menu">
        <li class="header-title"> Sidebar Filters</li>
        <li class="adjustments-line">
          <a href="javascript:void(0)" class="switch-trigger active-color">
            <div class="badge-colors ml-auto mr-auto">
              <span class="badge filter badge-purple active" data-color="purple"></span>
              <span class="badge filter badge-azure" data-color="azure"></span>
              <span class="badge filter badge-green" data-color="green"></span>
              <span class="badge filter badge-warning" data-color="orange"></span>
              <span class="badge filter badge-danger" data-color="danger"></span>
            </div>
            <div class="clearfix"></div>
          </a>
        </li>
        <li class="header-title">Images</li>
        <li>
          <a class="img-holder switch-trigger" href="javascript:void(0)">
            <img src="<%=application.getContextPath()%>/gymui/images/sidebar-1.jpg" alt="">
          </a>
        </li>
        <li class="active">
          <a class="img-holder switch-trigger" href="javascript:void(0)">
            <img src="<%=application.getContextPath()%>/gymui/images/sidebar-2.jpg" alt="">
          </a>
        </li>
       
       
      </ul>
    </div>
  </div>
  <!--   Core JS Files   -->
  <script src="<%=application.getContextPath()%>/gymui/js/jquery.min.js"></script>
  <script src="<%=application.getContextPath()%>/gymui/js/popper.min.js"></script>
  <script src="<%=application.getContextPath()%>/gymui/js/bootstrap-material-design.min.js"></script>
  <script src="https://unpkg.com/default-passive-events"></script>
  <script src="<%=application.getContextPath()%>/gymui/js/perfect-scrollbar.jquery.min.js"></script>
  <!-- Place this tag in your head or just before your close body tag. -->
  <script async defer src="https://buttons.github.io/buttons.js"></script>
  <!--  Google Maps Plugin    -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Chartist JS -->
  <script src="<%=application.getContextPath()%>/gymui/js/chartist.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="<%=application.getContextPath()%>/gymui/js/bootstrap-notify.js"></script>
  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="<%=application.getContextPath()%>/gymui/js/material-dashboard.js?v=2.1.0"></script>
  <!-- Material Dashboard DEMO methods, don't include it in your project! -->
  <script src="<%=application.getContextPath()%>/gymui/js/demo.js"></script>
      <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
  <script>
  $(function(){
    $("#gym").dataTable();
  });
  
  </script>
<!--  <script>
      
    $('.hover_bkgr_fricc').click(function(){
        $('.hover_bkgr_fricc').hide();
    });
    $('.popupCloseButton').click(function(){
        $('.hover_bkgr_fricc').hide();
  $('.hover_bkgr_fricc').click(function(){
      $('.hover_bkgr_fricc').hide();
    });   });

      
      
      </script>-->
<script src="https://code.jquery.com/jquery/1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

  <script>
    $(document).ready(function() {
      $().ready(function() {
           $('a.view').click(function(){
   alert("hello");
   var trid=$(this).attr('id');
  alert(trid);
$.post("<%=application.getContextPath()%>/Verifygymname",{"gympackage":trid},function(data,status){
      alert(data+"--"+$("#popid")+"  "+ document.getElementById("popid").innerHTML);
      $("#popid").html(data);
      $("#dialog").dialog();
      
            $("#dialog").click(function()
            {               
                    $("#dialog").hide();
                
    }); 
               
        
                
//      document.getElementById("popid").innerHTML=data;
//         $('.hover_bkgr_fricc').show();
//        data.classList.toggle("show");
    // $("#popid").ht
   // alert( document.getElementById("popid"));
    // document.getElementById("popid").innerHTML=data;
 
     });
});

         $sidebar = $('.sidebar');

        $sidebar_img_container = $sidebar.find('.sidebar-background');

        $full_page = $('.full-page');

        $sidebar_responsive = $('body > .navbar-collapse');

        window_width = $(window).width();

        $('.fixed-plugin a').click(function(event) {
          // Alex if we click on switch, stop propagation of the event, so the dropdown will not be hide, otherwise we set the  section active
          if ($(this).hasClass('switch-trigger')) {
            if (event.stopPropagation) {
              event.stopPropagation();
            } else if (window.event) {
              window.event.cancelBubble = true;
            }
          }
        });

        $('.fixed-plugin .active-color span').click(function() {
          $full_page_background = $('.full-page-background');

          $(this).siblings().removeClass('active');
          $(this).addClass('active');

          var new_color = $(this).data('color');

          if ($sidebar.length != 0) {
            $sidebar.attr('data-color', new_color);
          }

          if ($full_page.length != 0) {
            $full_page.attr('filter-color', new_color);
          }

          if ($sidebar_responsive.length != 0) {
            $sidebar_responsive.attr('data-color', new_color);
          }
        });

        $('.fixed-plugin .background-color .badge').click(function() {
          $(this).siblings().removeClass('active');
          $(this).addClass('active');

          var new_color = $(this).data('background-color');

          if ($sidebar.length != 0) {
            $sidebar.attr('data-background-color', new_color);
          }
        });

        $('.fixed-plugin .img-holder').click(function() {
          $full_page_background = $('.full-page-background');

          $(this).parent('li').siblings().removeClass('active');
          $(this).parent('li').addClass('active');


          var new_image = $(this).find("img").attr('src');

          if ($sidebar_img_container.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
            $sidebar_img_container.fadeOut('fast', function() {
              $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
              $sidebar_img_container.fadeIn('fast');
            });
          }

          if ($full_page_background.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
            var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

            $full_page_background.fadeOut('fast', function() {
              $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
              $full_page_background.fadeIn('fast');
            });
          }

          if ($('.switch-sidebar-image input:checked').length == 0) {
            var new_image = $('.fixed-plugin li.active .img-holder').find("img").attr('src');
            var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

            $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
            $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
          }

          if ($sidebar_responsive.length != 0) {
            $sidebar_responsive.css('background-image', 'url("' + new_image + '")');
          }
        });

        $('.switch-sidebar-image input').change(function() {
          $full_page_background = $('.full-page-background');

          $input = $(this);

          if ($input.is(':checked')) {
            if ($sidebar_img_container.length != 0) {
              $sidebar_img_container.fadeIn('fast');
              $sidebar.attr('data-image', '#');
            }

            if ($full_page_background.length != 0) {
              $full_page_background.fadeIn('fast');
              $full_page.attr('data-image', '#');
            }

            background_image = true;
          } else {
            if ($sidebar_img_container.length != 0) {
              $sidebar.removeAttr('data-image');
              $sidebar_img_container.fadeOut('fast');
            }

            if ($full_page_background.length != 0) {
              $full_page.removeAttr('data-image', '#');
              $full_page_background.fadeOut('fast');
            }

            background_image = false;
          }
        });

        $('.switch-sidebar-mini input').change(function() {
          $body = $('body');

          $input = $(this);

          if (md.misc.sidebar_mini_active == true) {
            $('body').removeClass('sidebar-mini');
            md.misc.sidebar_mini_active = false;

            $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar();

          } else {

            $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar('destroy');

            setTimeout(function() {
              $('body').addClass('sidebar-mini');

              md.misc.sidebar_mini_active = true;
            }, 300);
          }

          // we simulate the window Resize so the charts will get updated in realtime.
          var simulateWindowResize = setInterval(function() {
            window.dispatchEvent(new Event('resize'));
          }, 180);

          // we stop the simulation of Window Resize after the animations are completed
          setTimeout(function() {
            clearInterval(simulateWindowResize);
          }, 1000);

        });
      });
    });
  </script>
  <script>
    $(document).ready(function() {
      // Javascript method's body can be found in assets/js/demos.js
      md.initDashboardPageCharts();

    });
  </script>
</body>

</html>