/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addpackage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import operations.DataOperation;

/**
 *
 * @author Shravan
 */
public class Edit extends HttpServlet {

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
           String  name=request.getParameter("name");
        String time=request.getParameter("time");
        int amount=Integer.parseInt(request.getParameter("amount"));
        int branch =Integer.parseInt(request.getParameter("branch"));
        System.out.println(".........");
       Addpackage p1=new Addpackage();
       p1.setId(id);
        p1.setName(name);
        p1.setAmount(amount);
        p1.setTime(time);
        p1.setNo_of_branches(branch);
        doo.UpdatePackage(p1);
            
           response.sendRedirect(scx.getContextPath()+"/Viewpackage_all"); 
      }
       
       // response.sendRedirect("index.jsp?msg="+savemsg);
    }
}
