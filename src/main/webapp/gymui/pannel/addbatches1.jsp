<%-- 
    Document   : addbatches1
    Created on : 7 Feb, 2019, 3:13:43 PM
    Author     : Administrator
--%>

<%@page import="com.mycompany.loginmodule.Facility"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mycompany.loginmodule.Members"%>
<%@page import="java.util.HashSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
   <link rel="stylesheet" href="<%=application.getContextPath()%>/gymui/css/table.css">   
<body class="dark-edition">
      <%@include file="/gymui/headers/branchoperatordashboard.jsp" %>

      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-xl-12 col-lg-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">ADD BATCHES</h4>
                  <p class="card-category"></p>
                </div>
                <div class="card-body">
                    <form action="<%=application.getContextPath()%>/Addbatches" method="post">
                    <div class="row">
                   <div class="col-md-4">
                      
                   <label for="sel1">Select list (select one):</label>
      <select class="form-control" id="facility" name="facility">
              <%
         
              
            HashSet<Facility> listCat=(HashSet<Facility>)session.getAttribute("viewfacility");
              
            Iterator<Facility> it1=listCat.iterator();
            System.out.println("kkkk");
            while(it1.hasNext())
            {
                Facility fc=(Facility)it1.next();
         
          %>
       <option value="<%=fc.getId()%>"><%= fc.getName()%></option>
<%}%>
      </select>
                     
                   </div>
                    
     
<!--                      <div class="row" id="check"> -->
 <label class="bmd-label-floating">Members Name:</label>  
                           <div class="col-md-6" id="checkbox">
                             
                          <!--<input type="checkbox" name="membername" id="checkbox">-->
                    </div>
                    
<!--                           </div>-->
                         
                      </div>
                        <div class="row">                      
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Batch Name</label>
                          <input type="text" name="batchname" class="form-control">
                        </div>
                      </div>
                    </div>
                       <div class="row">                      
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Batch Timings(From)</label>
                          <input type="time" name="batchtimefrom"class="form-control">
                        </div>
                      </div> 
                            <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Batch Timings(To)</label>
                          <input type="time" name="batchtimeto"class="form-control">
                        </div>
                      </div> 
                      </div>
                     
                                                        
<!--                      <div class="col-md-2">
                        <div class="dropdown">
                          <button class="btn btn-primary" type="button" data-toggle="dropdown">Role
                          <span class="caret"></span></button>
                          <ul class="dropdown-menu">
                            <li><a href="#">YOGA</a></li>
                            <li><a href="#">UTHAK BETHAK</a></li>
                            <li><a href="#">ZUMBA</a></li>
                            <li><a href="#">VAJAN UCHAKVANU</a></li>
                          </ul>
                        </div>
                       </div>-->
                     
                       
      <div class="col-md-6"> 
                          <button type="submit" id="s" class="btn btn-primary pull-right">Submit</button>
                        </div>
                    </div>
                   </form> 
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
      $("#facility").focusout(function(){
        
        var n= $("#facility option:selected").val(); 
        $('#checkbox').empty(); 
     $.post("<%=application.getContextPath()%>/Viewmembers?op=batch&id="+n,function(data,status){
                     obj=JSON.parse(data);
                      for(i=0;i<obj.length;i++)
                      {
                     
                          $('#checkbox')
         .append($("<input>")
                    .attr({value:obj[i],name:'membername',type:'checkbox',id:'membername'}).text(obj[i])).append(obj[i]);
//            var n=obj[i];
                     
//                    $('#myselect1')
//         .append($("<option></option>")
//                    .attr("value",obj[i])
//                    .text(obj[i]));
                    
                    
                   }
                  
   });       

    });
    });
  </script>
</body>
</html>
