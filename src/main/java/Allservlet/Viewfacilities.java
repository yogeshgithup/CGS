/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Facility;
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
public class Viewfacilities extends HttpServlet {
  ServletContext scx;
public void init(ServletConfig sc) throws ServletException 
     {        
         super.init(sc);
         scx = getServletContext();
         System.out.println("sssss");
        try {          
            scx = sc.getServletContext();
            System.out.println("..."+scx);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
        
       DataOperation pko=new DataOperation(scx);
     
 
        try {
            System.out.println("//////////");
             HttpSession session=request.getSession(true);  
         int id=Integer.parseInt(session.getAttribute("gymid").toString());
            HashSet<Facility> listCatagory =pko.getfacility(id);
       
           
           session.setAttribute("viewfacility",listCatagory);
            
          if(session!=null)
          {
              System.out.println("00o0o0o00");
              if(request.getParameter("msg").equals("trainer"))
              {
                  response.sendRedirect(scx.getContextPath()+"/gymui/pannel/addtrainer.jsp");
              }
              else if(request.getParameter("msg").equals("facility")){
                  System.out.println("------");
                    response.sendRedirect(scx.getContextPath()+"/gymui/pannel/managefacilities1.jsp");
              }
              System.out.println("jnjnknnnj");
          }
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
}
