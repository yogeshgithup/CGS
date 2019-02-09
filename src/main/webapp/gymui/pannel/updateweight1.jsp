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
<!DOCTYPE html>
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
    <html lang="en">

  <link rel="stylesheet" href="<%=application.getContextPath()%>/gymui/css/table.css">
<body class="">
     <%@include file="/gymui/headers/memberdashboard.jsp" %>
   
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-xl-12 col-lg-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">UPDATE WEIGHT</h4>
                  <p class="card-category"></p>
                </div>
                <div class="card-body">
                    <form action="<%=application.getContextPath()%>/Updateweight" method="post">
                    <div class="row">                      
                      <div class="col-md-4">
                        <div class="form-group">
                          <label class="bmd-label-floating">Updated Weight</label>
                          <input type="text" name="updateweight" class="form-control">
                        </div>
                      </div>
                    </div>
                      <div class="col-md-6"> 
                         <button type="submit" class="btn btn-primary pull-right">Submit</button>
                        </div>
                         </form>
                    </div>
  

            </div>


            </div>
            
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
      // Javascript method's body can be found in assets/js/demos.js
      md.initDashboardPageCharts();

    });
  </script>
     
     
     
     
     
     
     

</body>
    </html>