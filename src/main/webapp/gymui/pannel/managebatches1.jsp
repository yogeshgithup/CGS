<%@page import="com.mycompany.loginmodule.Members"%>
<%@page import="com.mycompany.loginmodule.Batch_member"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mycompany.loginmodule.Batches"%>
<%@page import="java.util.Set"%>
<%@page import="com.mycompany.loginmodule.Addbranch"%>
<!DOCTYPE html>
<html lang="en">

  <link rel="stylesheet" href="<%=application.getContextPath()%>/gymui/css/table.css">
<body class="">
 <!--  <div class="wrapper "> -->
  <%@include file="/gymui/headers/branchoperatordashboard.jsp" %>
     
      <!-- End Navbar -->
    
      
      <div class="content">      
        <div class="row">
          <div class="col-md-10">
            <div class="card">
              <div class="card-header">
                  <a href="<%=application.getContextPath()%>/Viewmembers?op=view"> <button class="btn btn-primary btn-block">ADD BATCHES</button> </a>    
                <h4 class="card-title">View Batches</h4>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                      <table class="display" id="gym" style="width:100%; color: purple;">
                    <thead>
                      <th>ID</th>
                      <th>Batch Name</th>
                      <th>Batch Timings</th>
                      <th>Role</th>
                    </thead>                  
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
</body>
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
   <script>
  $(function(){
    $("#gym").dataTable();
  });
  </script>
</html>