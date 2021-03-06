<%@page import="com.mycompany.loginmodule.Gympackage"%>
<%@page import="com.mycompany.loginmodule.Facility"%>
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
  <%@include file="/gymui/headers/gymadmindashboard.jsp" %>
     
      <!-- End Navbar -->
    
      
      <div class="content">      
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                  <a href="<%=application.getContextPath()%>/Facpackage"> <button class="btn btn-primary btn-block">ADD GYM PACKAGE</button> </a>    
                <h4 class="card-title">View Gym Package</h4>
              </div>
              <div class="card-body">
                <div class="table-responsive">
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
           if(setbranch!=null)
           {
             Iterator<Gympackage> it=setbranch.iterator();
            if(it!=null)
            {
            while(it.hasNext())
            {
                Gympackage adbranch=it.next();
                if(adbranch!=null){
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
                      <% }} }}%>
                    </tbody>
                  </table>
                </div>
                     <div class="row">
             <div class="col-md-3"></div>
          
               <div class="col-md-4">
              <a href="/CGS/ExcelGympackage?msg=gym" > <button class="btn btn-primary btn-block">Download Excel</button> </a>  
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
