/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Addpackage;
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
public class Viewgym extends HttpServlet {

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
            HashSet<Addgym> listCatagory =pko.getgym();
        /*       Iterator<Addpackage> it=listCatagory.iterator();
            System.out.println("kkkk");
            while(it.hasNext())
            {
                Addpackage adpack=it.next();
                System.out.println("line 61");
                System.out.println(adpack.getName());
          }
*/          //  request.setAttribute("setpackage",listCatagory);
           HttpSession hs=request.getSession(true);
           hs.setAttribute("viewgym",listCatagory);
            
          if(hs!=null)
          {
              
              
                    response.sendRedirect(scx.getContextPath()+"/gymui/pannel/managegym1.jsp");
              
          }
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
}


