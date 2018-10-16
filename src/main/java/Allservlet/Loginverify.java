/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





package Allservlet;


import com.mycompany.loginmodule.Login;
import com.mycompany.loginmodule.Logingym;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import operations.DataOperation;



public class Loginverify extends HttpServlet {

ServletContext scx;
@Override
public void init(ServletConfig sc) throws ServletException 
     {        
         super.init(sc);
         scx = getServletContext();

        try {          
            scx = sc.getServletContext();                                 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
        
        boolean check;

        System.out.println("------servlet---51");
        String  name=request.getParameter("email");
        String password=request.getParameter("password");
        System.out.println(name);
        System.out.println(password);
        String savemsg=null;
        
        DataOperation so=new DataOperation(scx);
        Logingym l=new Logingym();
        
      l.setUsername(name);
      l.setPassword(password);
        System.out.println("hhhhhh");
   int retur=so.verify(l);
        System.out.println("....."+retur);
        System.out.println("lllllll");
    if(retur==1)
    {
         response.sendRedirect(scx.getContextPath()+"/gymui/pannel/gymadmin.jsp");
    }
    else if(retur==2)
    {
        response.sendRedirect("adminlogin.jsp");
    }
    else
    {
        response.sendRedirect("adminlogin.jsp");
    }
       
       // response.sendRedirect("index.jsp?msg="+savemsg);
    }
}
        