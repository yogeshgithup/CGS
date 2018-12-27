/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addpackage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
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
public class Viewpackage extends HttpServlet {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
        
       DataOperation pko=new DataOperation(scx);
     
 
        try {
            System.out.println("//////////");
            HashSet<Addpackage> listCatagory =pko.getpackage();
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
           hs.setAttribute("setpack",listCatagory);
          if(hs!=null)
          {
              response.sendRedirect(scx.getContextPath()+"/gymui/pannel/addgym1.jsp");
          }
           /*HashSet<Addpackage> setpack=(HashSet<Addpackage>)hs.getAttribute("setpack");
            Iterator<Addpackage> it=setpack.iterator();
            System.out.println("kkkk");
            while(it.hasNext())
            {
                Addpackage adpack=it.next();
                System.out.println("....");
                System.out.println(adpack.getName());
            }
           hs.setAttribute("www","www");
             //RequestDispatcher dispatcher = request.getRequestDispatcher("addgym.jsp");
            //dispatcher.forward(request, response);
 */
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
}
