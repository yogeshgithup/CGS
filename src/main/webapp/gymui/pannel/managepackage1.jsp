<%@page import="com.mycompany.loginmodule.Addpackage"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mycompany.loginmodule.Addgym"%>
<%@page import="java.util.HashSet"%>
<!DOCTYPE html>
<html lang="en">
 <!--<link href="https://cdn.datatables.net/1.10.13/css/dataTables.bootstrap.min.css" rel="stylesheet" />-->
        <!--<script src="https://code.jquery.com/jquery-1.12.4.js"></script>-->
        <!--<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>-->
        <!--<script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>-->

        <script src="<%=application.getContextPath()%>/gymui/js/jquery-ui-1.10.4.custom.min.js"></script>        
        <script src="<%=application.getContextPath()%>/gymui/js/jquery.dataTables.editable.js"></script>
        <script src="<%=application.getContextPath()%>/gymui/js/jquery.jeditable.js"></script>
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
  <%@include file="/gymui/headers/systemadmindashboard.jsp" %>
     
      <!-- End Navbar -->
            <script type="text/javascript">

            function editRow(oTable, nRow)
            {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
//                alert(jqTds.length + "-------");
                jqTds[0].innerHTML = '<input type="text" value="' + aData[0] + '" readOnly>';
                jqTds[1].innerHTML = '<input type="text" value="' + aData[1] + '">';
 jqTds[2].innerHTML = '<input type="text" value="' + aData[2] + '">';
 jqTds[3].innerHTML = '<input type="text" value="' + aData[3] + '">';
 jqTds[4].innerHTML = '<input type="text" value="' + aData[4] + '">';

                jqTds[5].innerHTML = '<a class="edit" href="">Save</a>';
            }


            function saveRow(oTable, nRow)
            {
                var jqInputs = $('input', nRow);

//                alert(jqInputs.length)
                var id = jqInputs[0].value;
                var name = jqInputs[1].value;
                var time = jqInputs[2].value;
                var amount = jqInputs[3].value;
                var branch = jqInputs[4].value;

                location.href = "<%=application.getContextPath()%>/Edit?op=pack&id="+id+"&name="+name+"&time="+time+"&amount="+amount+"&branch="+branch;
                oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 1, false);
                oTable.fnDraw();
            }

            function restoreRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);

                for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                    oTable.fnUpdate(aData[i], nRow, i, false);
                }
                oTable.fnDraw();
            }


            $(document).ready(function() {
                oTable = $("#gym").dataTable({
                    "bScrollCollapse": true,
                    "bPaginate": true,
                    "sPaginationType": "full_numbers",
                 
                    "aLengthMenu": [[3, 5, 10, -1], [3, 5, 10, "All"]],
                    "iDisplayLength": 10
                });





                var nEditing = null;

                $(document).on('click', '#gym a.edit', function(e) {
//                    alert("inedit");
                    e.preventDefault();

                    var nRow = $(this).parents('tr')[0];

                    if (nEditing !== null && nEditing != nRow) {
                        /* Currently editing - but not this row - restore the old before continuing to edit mode */
//                        alert("inif");
                        restoreRow(oTable, nEditing);
                        editRow(oTable, nRow);
                        nEditing = nRow;
                    }
                    else if (nEditing == nRow && this.innerHTML == "Save") {
//                        alert(nRow);
                        /* Editing this row and want to save it */
//                        alert("inelseif");
                        saveRow(oTable, nEditing);
                        nEditing = null;
                    }
                    else {
                        /* No edit in progress - let's start one */
//                        alert("inelse");
                        editRow(oTable, nRow);
                        nEditing = nRow;
                    }
                });

            });

        </script>
      
      <div class="content">      
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                  <a href="<%=application.getContextPath()%>/gymui/pannel/addpackage1.jsp"> <button class="btn btn-primary btn-block">ADD PACKAGE</button> </a>    
                <h4 class="card-title">View Package</h4>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="display" id="gym" style="width:100%; color: purple;">
                    <thead>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Time Period</th>
                      <th>Amount</th>
                      <th>No.Of Branches Manage</th>
                      <th>Edit</th>
                      <th>Delete</th>
                    </thead>
                    <tbody>
                          <%!
           HashSet<Addpackage> setpack=null;
          %>
   
          
              <%
         
          System.out.println("session="+session); 
          
              
             setpack=(HashSet<Addpackage>)session.getAttribute("viewpack");
            Iterator<Addpackage> it=setpack.iterator();
            System.out.println("kkkk");
            while(it.hasNext())
            {
                Addpackage adpack=it.next();
            adpack.getId();
            adpack.getName();
            adpack.getTime();
            adpack.getAmount();
            adpack.getNo_of_branches();
          %>


                      <tr>
                          <td><%= adpack.getId()%></td>
                        <td><%= adpack.getName()%></td>
                        <td><%= adpack.getTime()%></td>
                        <td><%= adpack.getAmount()%></td>
                        <td><%=adpack.getNo_of_branches() %></td>
                          <td><a class="edit" href="">Edit</a></td>
                                  <td><a href="<%=application.getContextPath()%>/Delete?op=pack&id=<%=adpack.getId()%>">delete</a></td>
            
                     
                      </tr>
                      <%}%>
            
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
