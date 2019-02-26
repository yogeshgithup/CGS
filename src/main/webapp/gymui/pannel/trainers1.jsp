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
                  HashSet<Dietplan> hd=( HashSet<Dietplan> )session.getAttribute("setdiet");
                  // dp.getBatchhh().getFacility_batches().getName();
                  if(hd!=null)
                  {
                 Iterator it= hd.iterator();
                 if(it!=null){
                 while(it.hasNext())
                 {
                    Dietplan dp=( Dietplan ) it.next();
                    System.out.println("iiiii"+dp.getId());
                    if(dp!=null)
                    {
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
                 }}
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
