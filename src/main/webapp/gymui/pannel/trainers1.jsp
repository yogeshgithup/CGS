<%@page import="com.mycompany.loginmodule.Dietplan"%>
<%@page import="com.mycompany.loginmodule.Members"%>
<%@page import="java.util.Set"%>
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
                RequestDispatcher rd=request.getRequestDispatcher("/userlogin.jsp");
                rd.forward(request, response);
                System.out.println("uuuu");
            }
    %>
    <html lang="en">

 <link rel="stylesheet" href="<%=application.getContextPath()%>/gymui/css/table.css">
<body class="">

     <%@include file="/gymui/headers/trainerdashboard.jsp" %>
     <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-xl-12 col-lg-12">
              
                 <div class="card">
                <div class="card-header card-header-primary">
                    <a href="<%=application.getContextPath()%>/gymui/pannel/adddietplan1.jsp"> <button class="btn btn-primary btn-block">ADD DIET PLAN</button></a>
                  <h4 class="card-title">View Diet Plan</h4>
                  <p class="card-category"></p>
                </div>
                   <div class="card-body">
                <div class="table-responsive">
                  <table class="display" style="width:100%; color: purple;">
                    <thead >
                      <th>ID</th>
                      <th>MEMBER NAME</th>
                      <th>Role</th>
                      <th>BATCH NAME</th>
                      <th>DIET PLAN</th>
                    </thead>
                    <tbody>
                        <% 
                        Trainer tt=(Trainer)session.getAttribute("trainer");
                     Set<Members> m=tt.getAdbranch().getAddmember();
                    
                   Iterator it=m.iterator();
                   while(it.hasNext())
                   {
                      Members mm= (Members) it.next();
                      System.out.println(mm.getFirstname());
                Dietplan dp=mm.getDp();
              System.out.println("---"+dp);
                //  System.out.println(dp.);
                   if(dp!=null)
                   {
                  // dp.getBatchhh().getFacility_batches().getName();
                        %>
                      <tr>
                        <td><%= dp.getId()%></td>
                        <td><%= dp.getA().getFirstname() %></td>
                        <td><%=  dp.getBatchhh().getFacility_batches().getName()%></td>
                        <td><%= dp.getBatchhh().getBatch_name() %></td>
                        <td><%= dp.getDescription()%></td>
                     
                      </tr>   
                      <%
                   }
                   }
                      %>
                    </tbody>
                  </table>
                </div>
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
