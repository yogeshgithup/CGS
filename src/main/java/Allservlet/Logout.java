/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Logingym;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import operations.DataOperation;

/**
 *
 * @author Shravan
 */
public class Logout extends HttpServlet {

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
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request,response);
   }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
     String op=   request.getParameter("op");
       try{
    response.setHeader("Cache-Control","no-cache");
     response.setHeader("Cache-Control","no-store");
     response.setDateHeader("Expires", 0);
     response.setHeader("Pragma","no-cache");
     HttpSession session=request.getSession(false);
     //int gymid=Integer.parseInt(session.getAttribute("gymid").toString());
    //int id=Integer.parseInt(session.getAttribute("sessss").toString());
    //System.out.println("...id"+id);
//            if(id==0)
//            {
//                request.setAttribute("Error","Session has ended");
//                RequestDispatcher rd=request.getRequestDispatcher("adminlogin1.jsp?msg=loggedout");
//                rd.forward(request, response);
//            }
    
     //   HttpSession session=request.getSession(true);  
           //session.invalidate(); 
            System.out.println("--------------------");
           System.out.println("op=="+op);
           if(op.equals("admin"))
           {
                session.removeAttribute("gymid");
           System.out.println("_____________________admin");
        response.sendRedirect("adminlogin1.jsp?msg=logged_out");
           }
           else if(op.equals("user"))
           {
               System.out.println( session.getAttribute("sessss").toString());
                session.removeAttribute("sessss");
              System.out.println("_____________________user");
        response.sendRedirect(scx.getContextPath()+"/gymui/pannel/userlogin.jsp?msg=loggeduser_out"); 
           }
       }catch(Exception e)
       {
           System.out.println("=="+e.getMessage());
       }
    }

}
