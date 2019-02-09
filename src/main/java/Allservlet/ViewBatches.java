/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addbranch;
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
public class ViewBatches extends HttpServlet {

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
       String branchid= session.getAttribute("branchid").toString();
         //  System.out.println("gymid==="+l2.getId());
         System.out.println("view batches");
           DataOperation pko=new DataOperation(scx);
            //Addgym gym = pko.getGymID(id);
           Addbranch ab=pko.getBranch(branchid);
            session.setAttribute("getbranch",ab);
         response.sendRedirect(scx.getContextPath()+"/gymui/pannel/managebatches1.jsp");
        
}
}
