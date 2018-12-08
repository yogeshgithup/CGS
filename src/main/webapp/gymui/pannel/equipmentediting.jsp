<%-- 
    Document   : equipmentediting
    Created on : Oct 17, 2018, 1:13:22 PM
    Author     : sneh pael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="<%=application.getContextPath()%>/gymui/images/apple-icon.png">
  <link rel="icon" type="image/png" href="<%=application.getContextPath()%>/gymui/images/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    EQUIPMENT EDITING
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="<%=application.getContextPath()%>/gymui/css/material-dashboard.css?v=2.1.0" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="<%=application.getContextPath()%>/gymui/css/demo.css" rel="stylesheet" />
   <link rel="stylesheet" href="<%=application.getContextPath()%>/gymui/vendor/bootstrap/awesome-bootstrap-checkbox.css"/>
    <link rel="stylesheet" href="<%=application.getContextPath()%>/gymui/vendor/bootstrap/bootstrap.css"/>
    <link rel="stylesheet" href="<%=application.getContextPath()%>/gymui/vendor/bootstrap/bootstrap.min.css"/>
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
                <a class="nav-link " href="<%=application.getContextPath()%>/Viewbranch" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
          <li class="nav-item dropdown active">
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
            <a class="navbar-brand" href="javascript:void(0)">MAIN PAGE EDITING</a>
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
              </div>
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
                <a class="nav-link" href="javascript:void(0)">
                  <i class="material-icons">person</i>
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
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title" align="Center">EQUIPMENT EDITING</h4>
                  <p class="card-category"></p>
                </div>
                <div class="card-body">
                  <form>
                      <div class="row">                                  
                      <div class="col-md-2">
                        <label for="file-multiple-input" class=" form-control-label">Equipment Image</label></div>
                            <div  class="col-md-3"><input type="file" id="file-multiple-input" name="file-multiple-input" multiple="" class="form-control-file "></div>
                      </div>
                       <div class="row">                      
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Equipment Title</label>
                          <input type="text" class="form-control">
                        </div>
                      </div>
                       </div>
                   <div class="row">  
                            <div class="col-md-6">
                        <h2 align="center">Equipment Description</h2>
                  
                      <!--   <div class="form-group">
                          <label class="bmd-label-floating">Aechievemet Title</label>
                          <input type="text" class="form-control">
                        </div>
                      </div>
                    </div>-->
                                             
                    <div class="col-md-6">
                          <div class="form-group">
                        <label for="comment" class="bmd-label-floating">Equipment Description:</label>
                        <textarea class="form-control" rows="5" id="comment"></textarea>
                          </div>
                        </div>
                      </div>
                               
<!--                       <div class="row">
                       <div class="col-md-8">
                          <div class="form-group">
                        <label for="comment" class="bmd-label-floating">Description:</label>
                        <textarea class="form-control" rows="5" id="comment"></textarea>
                          </div>
                        </div>
                      </div>-->
                       
                   </div>
                   </div>
                   </div>
                      <div class="col-md-6"> 
                         <button type="submit" class="btn btn-primary pull-right">Submit</button>
                        </div>
                    </div>
                  </div>
                </div>
              </div>
      
                </form>
                    

            </div>


            </div>
            <div class="col-xl-4 col-lg-12">
              


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
  <script>
    $(document).ready(function() {
      $().ready(function() {
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

