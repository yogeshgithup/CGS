/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addbranch;
import com.mycompany.loginmodule.addbranchoperator;
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
public class Viewbranchoperator extends HttpServlet {

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
         HttpSession session=request.getSession(true);  
         int id=Integer.parseInt(session.getAttribute("gymid").toString());
        
         //  System.out.println("gymid==="+l2.getId());
         System.out.println("view barnch");
           DataOperation pko=new DataOperation(scx);
           HashSet<addbranchoperator> listCatagory =pko.getbranchoperator(id);
            session.setAttribute("setbranchop",listCatagory);
         response.sendRedirect(scx.getContextPath()+"/gymui/pannel/managebranchoperator.jsp");
        
}
}