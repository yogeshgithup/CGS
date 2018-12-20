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
public class Aaddpackage extends HttpServlet {

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
        String  name=request.getParameter("name");
        String time=request.getParameter("time");
        int amount=Integer.parseInt(request.getParameter("amount"));
        int branch =Integer.parseInt(request.getParameter("branch"));
        System.out.println(".........");
       Addpackage p1=new Addpackage();
        p1.setName(name);
        p1.setAmount(amount);
        p1.setTime(time);
        p1.setNo_of_branches(branch);
        System.out.println("line 60");
        
        DataOperation p2=new DataOperation(scx);
        System.out.println("line 62");
        p2.addpackage(p1);
        response.sendRedirect("Viewpackage_all");
     
}
}