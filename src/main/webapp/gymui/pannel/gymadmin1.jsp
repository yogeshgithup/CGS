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
                  <a > <button class="btn btn-primary btn-block" id="count">ADD BRANCH</button> </a>    
                <h4 class="card-title">View Branch</h4>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                 <table id="gym"  class="display" style="width:100%; color: purple;">
                   <thead>
                      <th>branchID</th>
                      <th>branchName</th>
                      <th>branchstreet</th>
                      <th>brancharea</th>
                      <th>branchpostalcode</th>
                      
                    </thead>
                    <tbody>
                                          <%!
           HashSet<Addbranch> setbranch=null;
          %>
   
          
              <%
         
          System.out.println("session="+session); 
          
              
             setbranch=(HashSet<Addbranch>)session.getAttribute("setbranch");
             if(setbranch!=null)
             {
            Iterator<Addbranch> it=setbranch.iterator();
            System.out.println("kkkk");
            if(it!=null)
            {
            while(it.hasNext())
            {
                Addbranch adbranch=it.next();
               
                if(adbranch!=null)
                {
              
            
          %>

          <tr id="<%=adbranch.getId()%>">
                          <td><%= adbranch.getId()%></td>
                          <td><%= adbranch.getBranchname()%></td>
                           <td><%= adbranch.getStreet()%></td>
                            <td><%=adbranch.getArea()%></td>
                              <td><%=adbranch.getPostalcode()%></td>
                                  </tr>
                      <% } 
            } } } %>
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
//  $(function(){
//    
////      $("#count").click(Function(){
////             
////            alert("ok");
////          });
//  });
  $(document).ready(function() {
      alert("heloo");
    $("#gym").dataTable();
//          
$("#count").click(function(){
 $.post("<%=application.getContextPath()%>/ManageCount?op=branch",function(data,status){
   // alert(data.toString());
    var y=data;
    alert(y);
     
                       if(y.match("yes"))
                       {
                           alert("hello");
                           location.href="<%=application.getContextPath()%>/gymui/pannel/addbranches1.jsp";
                       }
                       else
                       {
                           alert("reached maximum count");
                          // location.href="<%=application.getContextPath()%>/gymui/pannel/gymadmin1.jsp";
                       }
                    });
});
});
  </script>
</html>