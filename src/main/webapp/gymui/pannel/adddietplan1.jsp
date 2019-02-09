<%@page import="com.mycompany.loginmodule.Batches"%>
<%@page import="java.util.Set"%>
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

     <%@include file="/gymui/headers/trainerdashboard.jsp" %>

     <div class="content">
        <div class="row">
          <div class="col-md-8">
            <div class="card">
              <div class="card-header">
                   <div id="msg" style="color:green"><h2><%=msg%></h2></div>
                <h5 class="title">Add Diet Plan</h5>
              </div>
              <div class="card-body">
     
     
     
     
      <form action="" method="post">
                  <div class="row">                                  
                      
                 <div class="col-md-6">
                            <div class="form-group">
      <label for="sel1">Select list (select one):</label>
    <select class="form-control" id="bname" name="branchname">
                               <%
             Trainer tt=(Trainer)session.getAttribute("trainer");
             System.out.println("----"+tt.getFirstname());
        System.out.println( tt.getFacility().getName());
         Set<Batches> bb= tt.getFacility().getFaci_batches();
       Iterator it=bb.iterator();
       while(it.hasNext())
       {
           
      Batches b=(Batches) it.next();
      System.out.println(b.getBatch_name());
              %>
              <option value="<%= b.getBatch_name()%>"><%= b.getBatch_name()%></option>
                            <% }%>
    </select>
                        </div>
                       </div>   
                      <div class="col-md-3">
                        <div class="dropdown">
                          <button class="btn btn-primary" type="button" data-toggle="dropdown">Member Name
                          <span class="caret"></span></button>
                          <ul class="dropdown-menu">
                            <li><a href="#">BRANCH 1</a></li>
                            <li><a href="#">BRANCH 2</a></li>
                            <li><a href="#">BRANCH 3</a></li>
                            <li><a href="#">BRANCH 4</a></li>
                          </ul>
                        </div>
                       </div>
                  </div>
                       <div class="row">                      
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Member Start Date</label>
                          <input type="date" name="memberstartdate" class="form-control">
                        </div>
                      </div>                       
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="bmd-label-floating">Member End Date</label>
                          <input type="date"  name="memberenddate" class="form-control">
                        </div>
                      </div> 
                      </div>
                       <div class="row">
                       <div class="col-md-6">
                          <div class="form-group">
                        <label for="comment" class="bmd-label-floating">Description:</label>
                        <textarea class="form-control" rows="4" id="description" name="description"></textarea>
                          </div>
                        </div>
                      </div>
                       <div class="row">
                       <div class="col-md-2">
                            <label for="file-multiple-input" class=" form-control-label">Diet Plan File</label></div>
                            <div  class="col-md-3"><input type="file" id="dietplan" name="dietplan" multiple="" class="form-control-file "></div>
                      </div>
                    </div>
                      <div class="col-md-6"> 
                         <button type="submit" class="btn btn-primary pull-right">Submit</button>
                        </div>
                    </div>
                  </div>
               
              
                </form>
                   
          <div class="col-md-4">
            <div class="card card-user">
              <div class="image">
                <img src="../assets/img/bg5.jpg" alt="...">
              </div>
              <div class="card-body">
                <div class="author">
                  <a href="#">
                    <img class="avatar border-gray" src="../assets/img/mike.jpg" alt="...">
                    <h5 class="title">Mike Andrew</h5>
                  </a>
                  <p class="description">
                    michael24
                  </p>
                </div>
                <p class="description text-center">
                  "Lamborghini Mercy
                  <br> Your chick she so thirsty
                  <br> I'm in that two seat Lambo"
                </p>
              </div>
              <hr>
              <div class="button-container">
                <button href="#" class="btn btn-neutral btn-icon btn-round btn-lg">
                  <i class="fab fa-facebook-f"></i>
                </button>
                <button href="#" class="btn btn-neutral btn-icon btn-round btn-lg">
                  <i class="fab fa-twitter"></i>
                </button>
                <button href="#" class="btn btn-neutral btn-icon btn-round btn-lg">
                  <i class="fab fa-google-plus-g"></i>
                </button>
              </div>
            </div>
          </div>
        </div>
    </div>
</body>
<script>
    $(document).ready(function() {
      $().ready(function() {
            $("#branchname").focusout(function(){
   
   var branchname=$("#branchname").val();
   //alert(packagename);
   $.post("<%=application.getContextPath()%>/Verifygymname",{"branch":branchname},function(data,status){
 
     alert(data);
     $("#branchname").val("");
  
    });
});
});
});
</script>
</html>