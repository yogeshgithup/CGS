<%@page import="com.mycompany.loginmodule.Trainer"%>
<%@page import="com.mycompany.loginmodule.addbranchoperator"%>
<%@page import="com.mycompany.loginmodule.Addbranch"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mycompany.loginmodule.Addgym"%>
<%@page import="java.util.HashSet"%>
<!DOCTYPE html>

<html lang="en">

<!--<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Now UI Dashboard by Creative Tim
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
       Fonts and icons     
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
   CSS Files 
  <link href="<%=application.getContextPath()%>/gymui/assets/css/bootstrap.min.css" rel="stylesheet" />
  <link href="<%=application.getContextPath()%>/gymui/assets/css/now-ui-dashboard.css?v=1.2.0" rel="stylesheet" />
   CSS Just for demo purpose, don't include it in your project 
  <link href="<%=application.getContextPath()%>/gymui/assets/demo/demo.css" rel="stylesheet" />
</head>-->
  <link rel="stylesheet" href="<%=application.getContextPath()%>/gymui/css/table.css">
<body class="">
 <!--  <div class="wrapper "> -->
  <%@include file="/gymui/headers/branchoperatordashboard.jsp" %>
     
      <!-- End Navbar -->
    
      
      <div class="content">      
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                  <a href="<%=application.getContextPath()%>/Viewfacilities?msg=trainer"> <button class="btn btn-primary btn-block">ADD TRAINER</button> </a>    
                <h4 class="card-title">View Trainers</h4>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                 <table class="display" id="gym" style="width:100%; color: purple;">
                    <thead>
                      <th>Firstname</th>
                      <th>Middlename</th>
                      <th>lastname</th>
                      <th>email</th>
                      <th>role</th>
                    </thead>
                    <tbody>
                          <%!
           HashSet<Trainer> setpack=null;
          %>
   
          
              <%
         
          System.out.println("session="+session); 
          
              
             setpack=(HashSet<Trainer>)session.getAttribute("settrainer");
             if(setpack!=null)
             {
            Iterator<Trainer> it=setpack.iterator();
            if(it!=null)
            {
            System.out.println("kkkk");
            while(it.hasNext())
            {
                Trainer adpack=it.next();
             
             
             
             if(adpack!=null)
             {
             
          %>


                      <tr>
                          <td><%= adpack.getFirstname()%></td>
                        <td><%=adpack.getMiddlename()%></td>
                        <td><%=adpack.getLastname()%></td>
                        <td><%=adpack.getEmail()%></td>
                        <td><%=adpack.getRole()%></td>
                     
                      </tr>
                      <% }}}}%>
            
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
       
            </div>
          </div>
        </div>
      </div> 
   
    </div>
  </div>
  <!--   Core JS Files   -->
<!--  <script src="<%=application.getContextPath()%>/gymui/assets/js/core/jquery.min.js"></script>
  <script src="<%=application.getContextPath()%>/gymui/assets/js/core/popper.min.js"></script>
  <script src="<%=application.getContextPath()%>/gymui/assets/js/core/bootstrap.min.js"></script>
  <script src="<%=application.getContextPath()%>/gymui/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
    Google Maps Plugin    
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
   Chart JS 
  <script src="<%=application.getContextPath()%>/gymui/assets/js/plugins/chartjs.min.js"></script>
    Notifications Plugin    
  <script src="<%=application.getContextPath()%>/gymui/assets/js/plugins/bootstrap-notify.js"></script>
   Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc 
  <script src="<%=application.getContextPath()%>/gymui/assets/js/now-ui-dashboard.min.js?v=1.2.0" type="text/javascript"></script>
   Now Ui Dashboard DEMO methods, don't include it in your project! 
  <a href="managegym.jsp"></a>
  <script src="<%=application.getContextPath()%>/gymui/assets/demo/demo.js"></script>-->
  
</body>
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
  <script>
  $(function(){
    $("#gym").dataTable();
  })
  </script>
</html>

