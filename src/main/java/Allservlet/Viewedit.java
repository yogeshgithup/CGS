/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Gyminfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
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
public class Viewedit extends HttpServlet {

   
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
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
         doPost(request,response);
     }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
         HttpSession session=request.getSession(true);  
         int id=Integer.parseInt(session.getAttribute("gymid").toString());
        String msg=request.getParameter("msg");
        System.out.println("--------------------------------"+msg);
         //  System.out.println("gymid==="+l2.getId());
         System.out.println("----------");
         System.out.println("view barnch");
           DataOperation pko=new DataOperation(scx,id);
           HashSet<Gyminfo> gym=new HashSet<Gyminfo>();
           gym = pko.getGymEdit(id);
      //  pko.getmembers(id);
            System.out.println("----------");
            session.setAttribute("setedit",gym);
         response.sendRedirect(scx.getContextPath()+"/gymui/pannel/managemainpage.jsp?msg="+msg);
        
}
}
    
    

