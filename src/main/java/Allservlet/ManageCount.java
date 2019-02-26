/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Allservlet;

import com.mycompany.loginmodule.Addgym;
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
 * @author Administrator
 */
public class ManageCount extends HttpServlet {

    ServletContext scx;
@Override
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
         HttpSession session=request.getSession(true);  
         int id=Integer.parseInt(session.getAttribute("gymid").toString());
       DataOperation pko=new DataOperation(scx,id);
       
       String op=request.getParameter("op");
        HttpSession hs=request.getSession(true);
       Addgym gym= (Addgym)hs.getAttribute("gym");
       // System.out.println(gym.getGymname());
       if(op.equals("branch"))
       {
           System.out.println("-----");
         String msg= pko.Countbranch(gym);
          System.out.println("---"+msg);
         out.println(msg);
       }
    }
     

}
