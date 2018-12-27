/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Gympackage;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Addgympackage extends HttpServlet {

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
        
        String packname=request.getParameter("packagename");
        String time=request.getParameter("timeperiod");
        int amount=Integer.parseInt(request.getParameter("amount"));
        
       Gympackage gp=new Gympackage();
       gp.setName(packname);
       gp.setAmount(amount);
       gp.setTime(time);
       
         HttpSession hs=request.getSession(true);
        int gymid= Integer.parseInt(hs.getAttribute("gymid").toString());
        System.out.println(gymid);
        
        DataOperation doo=new DataOperation(scx);
      int id= doo.addgympackage(gymid, gp);
        System.out.println("----"+id);
        String facility[]=request.getParameterValues("facility");
        doo.addpackfacility(id, facility);
           response.sendRedirect(scx.getContextPath()+"/Viewgympackage?msg=package");
    }
}
