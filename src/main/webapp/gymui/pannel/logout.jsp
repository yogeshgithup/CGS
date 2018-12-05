<%-- 
    Document   : logout
    Created on : 23 Oct, 2018, 7:14:22 PM
    Author     : Shravan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     response.setHeader("Cache-Control","no-cache");
     response.setHeader("Cache-Control","no-store");
     response.setDateHeader("Expires", 0);
     response.setHeader("Pragma","no-cache");
 
    int id=Integer.parseInt(session.getAttribute("gymid").toString());
    System.out.println("...id..."+id);
            if(id==0)
            {
                request.setAttribute("Error","Session has ended");
                RequestDispatcher rd=request.getRequestDispatcher(request.getContextPath()+"/adminlogin.jsp");
                rd.forward(request, response);
            }
    
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
            <%
            System.out.println("-----");
            session.invalidate();
            System.out.println("-0-0-");
          response.sendRedirect("http://localhost:8080/CGS/adminlogin.jsp"+"?msg=logged_out");
            
        %>
    </body>
</html>
