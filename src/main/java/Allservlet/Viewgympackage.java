/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Facility;
import com.mycompany.loginmodule.Gympackage;
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
public class Viewgympackage extends HttpServlet {

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
        
      
     
 
        try {
            System.out.println("//////////");
             HttpSession session=request.getSession(true);  
         int id=Integer.parseInt(session.getAttribute("gymid").toString());
          DataOperation pko=new DataOperation(scx,id);
            HashSet<Gympackage> listCatagory =pko.getpackfacility(id);
       
           
           session.setAttribute("viewpackfacility",listCatagory);
            
          if(session!=null)
          {
              if(request.getParameter("msg").equals("member"))
              {
                  response.sendRedirect(scx.getContextPath()+"/gymui/pannel/addmembers1.jsp");
              }
              else if(request.getParameter("msg").equals("package"))
              {
                    response.sendRedirect(scx.getContextPath()+"/gymui/pannel/managegympackage1.jsp");
              }
          }
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
}
