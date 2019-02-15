/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Logingym;
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
public class Delete extends HttpServlet {

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
        
        PrintWriter out=response.getWriter();
        DataOperation doo=new DataOperation(scx);
      String op= request.getParameter("op");
      if(op.equals("gym"))
      {
          int id=Integer.parseInt(request.getParameter("id"));
          doo.Deletegym(id);
           response.sendRedirect(scx.getContextPath()+"/Viewgym"); 
      }
       if(op.equals("pack"))
      {
          int id=Integer.parseInt(request.getParameter("id"));
          doo.Deletepack(id);
            
           response.sendRedirect(scx.getContextPath()+"/Viewpackage_all"); 
      }
       
       // response.sendRedirect("index.jsp?msg="+savemsg);
    }
}
