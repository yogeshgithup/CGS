<%@page import="com.mycompany.loginmodule.Trainer"%>
<%@page import="com.mycompany.loginmodule.addbranchoperator"%>
<%@page import="com.mycompany.loginmodule.Addbranch"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mycompany.loginmodule.Addgym"%>
<%@page import="java.util.HashSet"%>
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
                  <h4 class="card-title" >View Diet Plan</h4>
                  <p class="card-category"></p>
                </div>
                <div class="table-responsive">
                  <table class="table table-hover"  style="width:100%; color: purple;">
                    <thead>
                      <th>ID</th>
                      <th>Role</th>
                      <th>BATCH NAME</th>
                      <th>DIET PLAN</th>
                    </thead>
                    <tbody>
                      <tr>
                        <td>1</td>
                        <td>$36,738</td>
                        <td>Branch 1</td>
                        <td>Branch 1</td>
                      </tr>
                      <tr>
                        <td>2</td>
                        <td>$23,789</td>
                        <td>Branch 2</td>
                        <td>Branch 1</td>
                      </tr>
                      <tr>
                        <td>3</td>
                        <td>$56,142</td>
                        <td>Branch 3</td>
                        <td>Branch 1</td>
                      </tr>
                      <tr>
                        <td>4</td>
                        <td>$38,735</td>
                        <td>Branch 4</td>
                        <td>Branch 1</td>
                      </tr>
                    </tbody>
                  </table>
                </div>


            </div>
            </body>
            <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
  <script>
  $(function(){
    $("#gym").dataTable();
  });
  </script>
  </html>