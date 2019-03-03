
<%@page import="com.mycompany.loginmodule.Trainer"%>
<%@page import="com.mycompany.loginmodule.Addbranch"%>
<%@page import="com.mycompany.loginmodule.Equipment"%>
<%@page import="com.mycompany.loginmodule.Gallery"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.mycompany.loginmodule.Achievements"%>
<%@page import="com.mycompany.loginmodule.Gyminfo"%>
<%@page import="com.mycompany.loginmodule.Addgym"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Fitness In a Sports Category Bootstrap responsive Website Template | Home :: w3layouts</title>
        <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="utf-8">
        <meta name="keywords" content="Fitness In Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- bootstrap-css -->
        <link href="<%=application.getContextPath()%>/gymui/css/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!--// bootstrap-css -->
        <!-- css -->
        <link rel="stylesheet" href="<%=application.getContextPath()%>/gymui/css/css/style.css" type="text/css" media="all" />
        <!--// css -->
        <link rel="stylesheet" href="<%=application.getContextPath()%>/gymui/css/css/lightbox.css">  
        <!-- font-awesome icons -->
        <link href="<%=application.getContextPath()%>/gymui/css/css/font-awesome.css" rel="stylesheet"> 
        <link rel="stylesheet" href="<%=application.getContextPath()%>/gymui/css/css/hello.css">  
        <!-- //font-awesome icons -->
        <!-- font -->
        <link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
        <!-- //font -->
        <script src="<%=application.getContextPath()%>/gymui/js/js/jquery-1.11.1.min.js"></script>
        <script src="<%=application.getContextPath()%>/gymui/js/js/bootstrap.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function($) {
                $(".scroll").click(function(event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script> 

        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <![endif]-->
    </head>
    <body>
        <%
        Gyminfo ginfo=null;
        Set<Achievements> achive=null;
        Set<Equipment> equi=null;
        Set<Addbranch> branch=null;
            Addgym gym = (Addgym) session.getAttribute("gyminfo");
            if(gym!=null)
            {
        
          // equi =gym.getEqui();
            branch=gym.getAdbarnch();
            }
            
        %>
        <!-- banner -->
        <div class="banner">
            <div class="address-info">
                <div class="container">
                    <div class="address-info-text">
                        <p><i class="fa fa-map-marker" aria-hidden="true"></i> <%=gym.getArea()%>, <%=gym.getStreet()%>, <%=gym.getPostcode()%>, <%=gym.getPhoneno()%></p>
                    </div>
                </div>
            </div>
            <div class="banner-info">
                <div class="banner-info-text">
                    <div class="container">
                        <div class="agileits-logo">
                            <h1><a href="#"><%
                            if(gym!=null)
                            { String g = gym.getGymname();

                                    %> <%= g%></a></h1>
                        </div>
                        <div class="w3-border"> </div>
                        <div class="w3layouts-banner-info">
                            <h2></h2>
                            <% }%>
                            <div class="w3ls-button">
                                <a href="#" data-toggle="modal" data-target="#myModal">Read More</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="header-top">
                    <div class="container">
                        <div class="header-top-info">
                            <nav class="navbar navbar-default">
                                <!-- Brand and toggle get grouped for better mobile display -->
                                <div class="navbar-header">
                                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                        <span class="sr-only">Toggle navigation</span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                    </button>
                                </div>

                                <!-- Collect the nav links, forms, and other content for toggling -->
                                <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
                                    <nav>
                                        <ul class="nav navbar-nav">
                                            <li class="active"><a href="index.html">Home</a></li>
                                            <li><a href="#about" class="scroll">About</a></li>
                                            <li><a href="#services" class="scroll">Services</a></li>
                                            <li><a href="#gallery" class="scroll">Gallery</a></li>
                                            <li><a href="#team" class="scroll">Team</a></li>
                                            <li><a href="#news" class="scroll">News</a></li>
                                            <li><a href="#mail" class="scroll">Mail Us</a></li>
                                        </ul>
                                    </nav>
                                </div>
                                <!-- /.navbar-collapse -->
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- //banner -->
        <!-- modal -->
        <div class="modal about-modal fade" id="myModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header"> 
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
                        <h4 class="modal-title">Fitness <span>In</span></h4>
                    </div> 
                    <div class="modal-body">
                        <div class="agileits-w3layouts-info">
                            <img src="<%=application.getContextPath()%>/gymui/images/images/1.jpg" alt="" />
                            <p>Duis venenatis, turpis eu bibendum porttitor, sapien quam ultricies tellus, ac rhoncus risus odio eget nunc. Pellentesque ac fermentum diam. Integer eu facilisis nunc, a iaculis felis. Pellentesque pellentesque tempor enim, in dapibus turpis porttitor quis. Suspendisse ultrices hendrerit massa. Nam id metus id tellus ultrices ullamcorper.  Cras tempor massa luctus, varius lacus sit amet, blandit lorem. Duis auctor in tortor sed tristique. Proin sed finibus sem</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- //modal -->
        <!-- about -->
        <div class="about" id="about">
            <div class="container">
                <div class="agileits-heading">
                    <h3>About Us</h3>
                </div>
                <div class="w3l-about-grids">
                    <div class="col-md-6 w3ls-about-right">
                        <div class="w3ls-about-right-img">

                        </div>
                    </div>
                    <div class="col-md-6 w3ls-about-left">
<!--                        <div class="agileits-icon-grid">
                            <div class="icon-left hvr-radial-out">
                                <i class="fa fa-cog" aria-hidden="true"></i>
                            </div>
                            						<div class="icon-right">
                                                                                    <h5>Suspendisse consectetur dapibus volutpat.</h5>
                                                                                    <p>Phasellus dapibus felis elit, sed accumsan arcu gravida vitae. Nullam aliquam erat at lectus ullamcorper, nec interdum neque hendrerit.</p>
                                                                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="agileits-icon-grid">
                            <div class="icon-left hvr-radial-out">
                                <i class="fa fa-heart" aria-hidden="true"></i>
                            </div>
                            						<div class="icon-right">
                                                                                    <h5>Lorem ipsum dolor sit amet</h5>
                                                                                    <p>Phasellus dapibus felis elit, sed accumsan arcu gravida vitae. Nullam aliquam erat at lectus ullamcorper, nec interdum neque hendrerit.</p>
                                                                            </div>
                            <div class="clearfix"> </div>
                        </div>-->
                        <div class="agileits-icon-grid">
                            <div class="icon-left hvr-radial-out">
                                <i class="fa fa-paper-plane" aria-hidden="true"></i>
                            </div>
                            <div class="icon-right">
                                <%
                                 if(gym!=null)
            {
            ginfo = gym.getGyinfo();
            if(ginfo!=null)
            {
                                %>
                                <h5><%= ginfo.getAbout_us_title()%></h5>
                                <p><%=ginfo.getAbout_us_desc()%></p>
                                <% } }%>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
        <!-- //about -->
        <!-- services -->
        <div class="services" id="services">
            <div class="container">
                <div class="agileits-heading">
                    <h3>Our Achievement</h3>
                </div>
                <div class="wthree-services-grids">
                    <div class="col-sm-3 wthree-services">
                        <!--					<div class="wthree-services-grid">
                                                                        <div class="wthree-services-info">
                                                                                <i class="fa fa-money" aria-hidden="true"></i>
                                                                                <h4>Phasellus</h4>
                                                                                <div class="w3ls-border"> </div>
                                                                        </div>
                                                                        <div class="wthree-services-captn">
                                                                                <h4>Sed faucibus</h4>
                                                                                <p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
                                                                        </div>
                                                                </div>-->
                    </div>
                    <div class="col-sm-3 wthree-services">
                        <!--					<div class="wthree-services-grid">
                                                                        <div class="wthree-services-info">
                                                                                <i class="fa fa-comment-o" aria-hidden="true"></i>
                                                                                <h4>Vivamus</h4>
                                                                                <div class="w3ls-border"> </div>
                                                                        </div>
                                                                        <div class="wthree-services-captn">
                                                                                <h4>Sed faucibus</h4>
                                                                                <p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
                                                                        </div>
                                                                </div>-->
                    </div>
                    <div class="col-sm-3 wthree-services">
                        <div class="wthree-services-grid">
                            <!--						<div class="wthree-services-info">
                                                                                    <i class="fa fa-user-o" aria-hidden="true"></i>
                                                                                    <h4>Integer</h4>
                                                                                    <div class="w3ls-border"> </div>
                                                                            </div>
                                                                            <div class="wthree-services-captn">
                                                                                    <h4>Sed faucibus</h4>
                                                                                    <p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
                                                                            </div>-->
                        </div>
                    </div>
                    <div class="col-sm-3 wthree-services">
                        <div class="wthree-services-grid">
                            <!--						<div class="wthree-services-info">
                                                                                    <i class="fa fa-thumbs-o-up" aria-hidden="true"></i>
                                                                                    <h4>Faucibus</h4>
                                                                                    <div class="w3ls-border"> </div>
                                                                            </div>
                                                                            <div class="wthree-services-captn">
                                                                                    <h4>Sed faucibus</h4>
                                                                                    <p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
                                                                            </div>-->
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <div class="wthree-services-grids services-grids1">
                    <div class="col-sm-3 wthree-services">
                        <div class="wthree-services-grid">
                            <!--						<div class="wthree-services-info">
                                                                                    <i class="fa fa-bell-o" aria-hidden="true"></i>
                                                                                    <h4>Phasellus</h4>
                                                                                    <div class="w3ls-border"> </div>
                                                                            </div>
                                                                            <div class="wthree-services-captn">
                                                                                    <h4>Sed faucibus</h4>
                                                                                    <p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
                                                                            </div>-->
                        </div>
                    </div>
                    <div class="col-sm-3 wthree-services">
                        <div class="wthree-services-grid">
                            <%
                                  if(gym!=null)
            {
            achive= gym.getAchive();
            if(achive!=null)
            {
                                Iterator it = achive.iterator();
                                if(it!=null)
                                {
                                while (it.hasNext()) {
                                    Achievements ac = (Achievements) it.next();
                                   
                                  if(ac!=null)
                                  {
                                                %>
                            <div class="wthree-services-info">
                                <i class="fa fa-sun-o" aria-hidden="true"></i>
                                <h4><%= ac.getAchievement()%></h4>
                                <div class="w3ls-border"> </div>
                            </div>
                            <div class="wthree-services-captn">
                                <!--<h4>Sed faucibus</h4>-->
                                <p><%= ac.getAchive_descr()%></p>
                            </div>
                            <% }}}} }%>
                        </div>
                    </div>
                    <div class="col-sm-3 wthree-services">
                        <div class="wthree-services-grid">
                          
                                <!--<i class="fa fa-credit-card" aria-hidden="true"></i>-->
                                <!--<h4>Integer</h4>-->
                                <!--<div class="w3ls-border"> </div>-->
                            <!--</div>-->
                            <!--<div class="wthree-services-captn">-->
                                <!--<h4>Sed faucibus</h4>-->
                                <!--<p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>-->
                            <!--</div>-->
                        </div>
                    </div>
                    <div class="col-sm-3 wthree-services">
                        <div class="wthree-services-grid">
<!--                            <div class="wthree-services-info">
                                <i class="fa fa-bullhorn" aria-hidden="true"></i>
                                <h4>Faucibus</h4>
                                <div class="w3ls-border"> </div>
                            </div>
                            <div class="wthree-services-captn">
                                <h4>Sed faucibus</h4>
                                <p>Aenean pulvinar ac enimet posuere tincidunt velit Utin tincidunt</p>
                            </div>-->
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
        <!-- //services -->
        <!-- gallery -->
        <div id="gallery" class="gallery">
            <div class="container"> 
                <div class="agileits-heading">
                    <h3>Our Gallery</h3>
                </div>
                <div class="gallery-w3lsrow">
                     <%
                                   if(gym!=null)
            {
        
           equi =gym.getEqui();
           if(equi!=null)
           {
                                Iterator ite = equi.iterator();
                                if(ite!=null)
                                {
                                while (ite.hasNext()) {
                                    Equipment eq = (Equipment) ite.next();
                              if(eq!=null)
                              {
                                                %>
                    <div class="col-sm-3 col-xs-4 gallery-grids">
                        <div class="w3ls-hover">
                            <a href="<%=eq.getUrl()%>" data-lightbox="example-set" data-title="<%= eq.getDescr()%>">
                                <img src="<%=eq.getUrl()%>" class="img-responsive zoom-img" alt=""/>
                                <div class="view-caption">
                                    <h5>Latest Gallery</h5>
                                    <i class="fa fa-search-plus" aria-hidden="true"></i>
                                </div>
                            </a>
                        </div>
                    </div>
                                <div class="col-sm-1">
                                     
                                     </div>
                                
                                <% } }}}} %>
<!--                    <div class="col-sm-3 col-xs-4 gallery-grids">
                        <div class="w3ls-hover">
                            <a href="<%=application.getContextPath()%>/gymui/images/images/g2.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
                                <img src="<%=application.getContextPath()%>/gymui/images/images/g2.jpg" class="img-responsive zoom-img" alt=""/>
                                <div class="view-caption">
                                    <h5>Latest Gallery</h5>
                                    <i class="fa fa-search-plus" aria-hidden="true"></i>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-3 col-xs-4 gallery-grids">
                        <div class="w3ls-hover">
                            <a href="<%=application.getContextPath()%>/gymui/images/images/g3.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
                                <img src="<%=application.getContextPath()%>/gymui/images/images/g3.jpg" class="img-responsive zoom-img" alt=""/>
                                <div class="view-caption">
                                    <h5>Latest Gallery</h5>
                                    <i class="fa fa-search-plus" aria-hidden="true"></i>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-3 col-xs-4 gallery-grids">
                        <div class="w3ls-hover">
                            <a href="<%=application.getContextPath()%>/gymui/images/images/g4.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
                                <img src="<%=application.getContextPath()%>/gymui/images/images/g4.jpg" class="img-responsive zoom-img" alt=""/>
                                <div class="view-caption">
                                    <h5>Latest Gallery</h5>
                                    <i class="fa fa-search-plus" aria-hidden="true"></i>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-3 col-xs-4 gallery-grids">
                        <div class="w3ls-hover">
                            <a href="<%=application.getContextPath()%>/gymui/images/images/g5.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
                                <img src="<%=application.getContextPath()%>/gymui/images/images/g5.jpg" class="img-responsive zoom-img" alt=""/>
                                <div class="view-caption">
                                    <h5>Latest Gallery</h5>
                                    <i class="fa fa-search-plus" aria-hidden="true"></i>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-3 col-xs-4 gallery-grids">
                        <div class="w3ls-hover">
                            <a href="<%=application.getContextPath()%>/gymui/images/images/g6.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
                                <img src="<%=application.getContextPath()%>/gymui/images/images/g6.jpg" class="img-responsive zoom-img" alt=""/>
                                <div class="view-caption">
                                    <h5>Latest Gallery</h5>
                                    <i class="fa fa-search-plus" aria-hidden="true"></i>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-3 col-xs-4 gallery-grids">
                        <div class="w3ls-hover">
                            <a href="<%=application.getContextPath()%>/gymui/images/images/g7.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
                                <img src="<%=application.getContextPath()%>/gymui/images/images/g7.jpg" class="img-responsive zoom-img" alt=""/>
                                <div class="view-caption">
                                    <h5>Latest Gallery</h5>
                                    <i class="fa fa-search" aria-hidden="true"></i>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-sm-3 col-xs-4 gallery-grids">
                        <div class="w3ls-hover">
                            <a href="<%=application.getContextPath()%>/gymui/images/images/g8.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
                                <img src="<%=application.getContextPath()%>/gymui/images/images/g8.jpg" class="img-responsive zoom-img" alt=""/>
                                <div class="view-caption">
                                    <h5>Latest Gallery</h5>
                                    <i class="fa fa-search-plus" aria-hidden="true"></i>
                                </div>
                            </a>
                        </div>
                    </div>  -->
                    <div class="clearfix"> </div> 
                </div>
                <!--  light box js -->
                <script src="<%=application.getContextPath()%>/gymui/js/js/lightbox-plus-jquery.min.js"></script> 
                <!-- //light box js--> 
            </div> 
        </div>
        <!-- //gallery -->
        <!-- stats -->
        <div class="stats jarallax">
            <div class="container">
                <div class="col-md-3 w3_counter_grid">
                    <div class="w3_agileits_counter_grid">
                        <i class="fa fa-umbrella" aria-hidden="true"></i>
                    </div>
                    <%
                    
                     int mint=0 ;
                       int tint=0;
                       int baint=0;
                       int bint =0;
                       int fint=0;
                       int eint=0;
                    if(gym!=null)
                    {
                        Set<Addbranch> ab=  gym.getAdbarnch();
                       fint=  gym.getFacility().size();
                      eint = gym.getEqui().size();
                     if(ab!=null)
                     {
                        bint=ab.size();
                      
                    Iterator it1= ab.iterator();
                    
                    while(it1.hasNext())
                    {
                       
                    if(it1!=null)
                    {
                        Addbranch bb=(Addbranch)it1.next();
                        if(bb!=null)
                        {
                       mint = mint + bb.getAddmember().size();
                    tint = tint +  bb.getAddtrainer().size();
                      baint= baint + bb.getBatches().size();
                        }
                    }
                    }
                    }
                    }
                    %>
                    <p class="counter"><%= mint %></p>
                    <h3>Total Members</h3>
                </div>
                <div class="col-md-3 w3_counter_grid">
                    <div class="w3_agileits_counter_grid">
                        <i class="fa fa-users" aria-hidden="true"></i>
                    </div>
                    <p class="counter"><%= tint%></p>
                    <h3>Total Trainers</h3>
                </div>
                <div class="col-md-3 w3_counter_grid">
                    <div class="w3_agileits_counter_grid">
                        <i class="fa fa-comments" aria-hidden="true"></i>
                    </div>
                    <p class="counter"><%= bint %></p>
                    <h3>Total Branches</h3>
                </div>
                <div class="col-md-3 w3_counter_grid">
                    <div class="w3_agileits_counter_grid">
                        <i class="fa fa-book" aria-hidden="true"></i>
                    </div>
                    <p class="counter"><%= fint%></p>
                    <h3>Total Facilities</h3>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
        <!-- //stats -->
        <!-- team -->
        <div id="team" class="team">
            <div class="container">	
                <div class="agileits-heading">
                    <h3>Our Trainers</h3>
                </div>			
                <div class="teamw3-agileinfo">
                    <%
                      if(gym!=null)
                      {
                          
                        branch=gym.getAdbarnch();
                        if(branch!=null)
                        {
                                Iterator itb = branch.iterator();
                                if(itb!=null)
                                {
                                while (itb.hasNext()) {
                                    Addbranch ab1 = (Addbranch) itb.next();
                                    if(ab1!=null)
                                    {
                                 Set<Trainer> trainer= ab1.getAddtrainer();
                                   Iterator itt = trainer.iterator();
                                while (itt.hasNext()) {
                                   Trainer tt = (Trainer) itt.next();
                                    
                    %>
                    <div class="col-md-3 col-xs-6 team-wthree-grid">
                        <div class="btm-right">
                            <div class="w3ls-hover">
                             <a href="<%=tt.getUrl()%>" data-lightbox="example-set" data-title="<%= tt.getDescription()%>">
                                <img src="<%=tt.getUrl()%>" class="img-responsive zoom-img" alt=""/>
                                <div class="view-caption">
                                    <h5>Latest Gallery</h5>
                                    <i class="fa fa-search-plus" aria-hidden="true"></i>
                                </div>
                            </a>
                                </div>
<!--                            <img src="<%=tt.getUrl()%>" alt=" ">-->
                            <div class="captn">
                                <h4><%=tt.getFirstname()%> <%=tt.getMiddlename()%> <%=tt.getLastname()%></h4>	
                            </div>
                            
                        </div>
                    </div>
                            <%  }
                                } 
                                }
                                }
                        }
                      }
                            %>
<!--                    <div class="col-md-3 col-xs-6 team-wthree-grid">
                        <div class="btm-right">
                            <img src="<%=application.getContextPath()%>/gymui/images/images/t2.jpg" alt=" ">
                            <div class="w3social-icons captn-icon"> 
                                <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li> 
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li> 
                                </ul>
                            </div>
                            <div class="captn">
                                <h4>Williams Allen</h4>	
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-xs-6 team-wthree-grid">
                        <div class="btm-right">
                            <img src="<%=application.getContextPath()%>/gymui/images/images/t3.jpg" alt=" ">
                            <div class="w3social-icons captn-icon"> 
                                <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li> 
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li> 
                                </ul>
                            </div>
                            <div class="captn">
                                <h4>Richard</h4>	
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-xs-6 team-wthree-grid">
                        <div class="btm-right">
                            <img src="<%=application.getContextPath()%>/gymui/images/images/t4.jpg" alt=" ">
                            <div class="w3social-icons captn-icon"> 
                                <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li> 
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li> 
                                </ul>
                            </div>
                            <div class="captn">
                                <h4>John Doel</h4>	
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>-->
            </div>
        </div>
        <!-- //team -->
        <!-- news -->
        <div class="news" id="news">
            <div class="container">  
                <div class="agileits-heading">
                    <h3>News & Events</h3>
                </div>
                <div class="news-agileinfo"> 
                    <div class="col-md-4 news-right agileits-w3layouts">
                        <h4>Our Branches</h4>
                        <div class="achievesw3-agile">
                            <ul> 
                                <%  
                                 if(gym!=null)
                      {
                          
                        branch=gym.getAdbarnch();
                        if(branch!=null)
                        {
                                Iterator itbb = branch.iterator();
                                if(itbb!=null){
                                while (itbb.hasNext()) {
                                    Addbranch ab2 = (Addbranch) itbb.next();
                            if(ab2!=null)
                            {
                              
                                       
                                %>
                                
                                <li><a href="#" data-toggle="popover" title="<%=ab2.getBranchname()%>" data-content="<%= ab2.getArea()%> </br> <%=  ab2.getStreet()%>  <%= ab2.getPostalcode()%>"><i class="fa fa-arrow-circle-right" aria-hidden="true"></i> <%=ab2.getBranchname()%></a></li>
                             
                                <% }}}}}%>
                                    </ul>  
                        </div>
                    </div>
                    <div class="col-md-8 news-w3row"> 
                        <div class="wthree-news-grids">
                            <div class="col-md-3 col-xs-3 datew3-agileits">
                                <img src="<%=application.getContextPath()%>/gymui/images/images/ts1.jpg" class="img-responsive" alt=""/>
                            </div>
                            <div class="col-md-9 col-xs-9 datew3-agileits-info ">
                                <h5><a href="#" data-toggle="modal" data-target="#myModal">Fusce scelerisque sit amet justo vitae</a></h5>
                                <h6>20/12/2016</h6>
                                <p>Proin euismod vehicula vestibulum. Fusce ullamcorper aliquet dolor id egestas. Nulla leo purus, facilisis non cursus ut, egestas sed ipsum.</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="wthree-news-grids news-grids-mdl">
                            <div class="col-md-3 col-xs-3 datew3-agileits datew3-agileits-fltrt">
                                <img src="<%=application.getContextPath()%>/gymui/images/images/ts2.jpg" class="img-responsive" alt=""/>
                            </div>
                            <div class="col-md-9 col-xs-9 datew3-agileits-info datew3-agileits-info-fltlft">
                                <h5><a href="#" data-toggle="modal" data-target="#myModal">Fusce scelerisque sit amet justo vitae</a></h5>
                                <h6>10/11/2016</h6>
                                <p>Proin euismod vehicula vestibulum. Fusce ullamcorper aliquet dolor id egestas. Nulla leo purus, facilisis non cursus ut, egestas sed ipsum.</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div> 
                        <div class="wthree-news-grids">
                            <div class="col-md-3 col-xs-3 datew3-agileits">
                                <img src="<%=application.getContextPath()%>/gymui/images/images/ts3.jpg" class="img-responsive" alt=""/>
                            </div>
                            <div class="col-md-9 col-xs-9 datew3-agileits-info ">
                                <h5><a href="#" data-toggle="modal" data-target="#myModal">Fusce scelerisque sit amet justo vitae</a></h5>
                                <h6>25/10/2016</h6>
                                <p>Proin euismod vehicula vestibulum. Fusce ullamcorper aliquet dolor id egestas. Nulla leo purus, facilisis non cursus ut, egestas sed ipsum.</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
        <!-- //news -->
        <!-- contact -->
        <div class="contact" id="mail">
            <div class="container"> 
                <div class="agileits-heading">
                    <h3>Contact Us</h3>
                </div>
                <div class="contact-w3ls-row">
                    <div class="w3agile-map">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m10!1m8!1m3!1d86258.20905457705!2d-82.56985214706441!3d36.53988771087049!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sin!4v1463030942772" allowfullscreen=""></iframe>
                    </div>
                    <div class="wthree-contact-form">
                        <form action="#" method="post">
                            <div class="col-md-5 col-sm-5 agileits-contact-right">
                                <textarea name="Message" placeholder="Message" required=""></textarea>
                            </div>
                            <div class="col-md-7 col-sm-7 agileits-contact-left">
                                <input type="text" name="First Name" placeholder="First Name" required="">
                                <input type="text" class="email" name="Last Name" placeholder="Last Name" required="">
                                <input type="text" name="Number" placeholder="Mobile Number" required="">
                                <input type="email"  class="email" name="Email" placeholder="Email" required="">
                                <input type="submit" value="SUBMIT">
                            </div> 
                            <div class="clearfix"> </div> 
                        </form>
                    </div>
                </div>  
            </div> 
        </div>
        <!-- contact -->
        <!-- footer -->
        <div class="footer">
            <div class="container">
                <h4>Newsletter</h4>
                <form action="#" method="post">
                    <input type="email" name="Email" placeholder="Enter Your Email..." required="">
                    <input type="submit" value="Send">
                </form>
                <div class="agile_footer_copy">
                    <div class="w3agile_footer_grids">
                        <div class="col-md-4 w3agile_footer_grid">
                            <h3>About Us</h3>
                            <p>Proin ultrices hendrerit massa, vitae convallis diam aliquam sit amet. Sed sit amet nulla vestibulum,<span>accumsan erat sed, aliquet arcu. Quisque aliquam nunc a orci aliquam, nec rhoncus eros blandit. Pellentesque blandit quis nunc porta luctus. </span></p>
                        </div>
                        <div class="col-md-4 w3agile_footer_grid">
                            <h3>Contact Info</h3>
                            <ul>
                                <li><i class="fa fa-map" aria-hidden="true"></i> 1234k Avenue, 4th block, <span>Kingsport City.</span></li>
                                <li><i class="fa fa-envelope" aria-hidden="true"></i> <a href="mailto:info@example.com">info@example.com</a></li>
                                <li><i class="fa fa-volume-control-phone" aria-hidden="true"></i> +1234 567 567</li>
                            </ul>
                        </div>
                        <div class="col-md-4 w3agile_footer_grid w3agile_footer_grid1">
                            <h3>Navigation</h3>
                            <ul>
                                <li><i class="fa fa-angle-right" aria-hidden="true"></i> <a href="#about" class="scroll">About</a></li>
                                <li><i class="fa fa-angle-right" aria-hidden="true"></i> <a href="#services" class="scroll">Services</a></li>
                                <li><i class="fa fa-angle-right" aria-hidden="true"></i> <a href="#Gallery" class="scroll">Gallery</a></li>
                                <li><i class="fa fa-angle-right" aria-hidden="true"></i> <a href="#team" class="scroll">Team</a></li>
                                <li><i class="fa fa-angle-right" aria-hidden="true"></i> <a href="#news" class="scroll">News</a></li>
                                <li><i class="fa fa-angle-right" aria-hidden="true"></i> <a href="#mail" class="scroll">Contact</a></li>
                            </ul>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
                <div class="w3_agileits_copy_right_social">
                    <div class="agileits_w3layouts_copy_right">
                        <p>&copy; 2017 Fitness In. All rights reserved | Design by <a href="http://w3layouts.com/">W3layouts</a></p>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
        <!-- //footer -->
        <script src="<%=application.getContextPath()%>/gymui/js/js/jarallax.js"></script>
        <script src="<%=application.getContextPath()%>/gymui/js/js/SmoothScroll.min.js"></script>
        <script type="text/javascript">
            /* init Jarallax */
            $('.jarallax').jarallax({
                speed: 0.5,
                imgWidth: 1366,
                imgHeight: 768
            })
        </script>
        <script src="<%=application.getContextPath()%>/gymui/js/js/responsiveslides.min.js"></script>
        <script type="text/javascript" src="<%=application.getContextPath()%>/gymui/js/js/move-top.js"></script>
        <script type="text/javascript" src="<%=application.getContextPath()%>/gymui/js/js/easing.js"></script>
        <!-- here stars scrolling icon -->
        <script type="text/javascript">
            $(document).ready(function() {
                /*
                 var defaults = {
                 containerID: 'toTop', // fading element id
                 containerHoverID: 'toTopHover', // fading element hover id
                 scrollSpeed: 1200,
                 easingType: 'linear' 
                 };
                 */

                $().UItoTop({easingType: 'easeOutQuart'});
   $('[data-toggle="popover"]').popover();  
            });
        </script>
       
        <!-- //here ends scrolling icon -->
        <!-- Tabs-JavaScript -->
        <!-- stats -->
        <script src="<%=application.getContextPath()%>/gymui/js/js/jquery.waypoints.min.js"></script>
        <script src="<%=application.getContextPath()%>/gymui/js/js/jquery.countup.js"></script>
        <script>
            $('.counter').countUp();
        </script>
        <!-- //stats -->
    </body>	
</html>