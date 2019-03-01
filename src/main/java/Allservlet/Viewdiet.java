/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Dietplan;
import com.mycompany.loginmodule.Members;
import com.mycompany.loginmodule.Trainer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
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
public class Viewdiet extends HttpServlet {

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
     
         doPost(request,response);
     }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session=request.getSession(true);  
         int id1=Integer.parseInt(session.getAttribute("gymid").toString());
        DataOperation pko=new DataOperation(scx,id1);
        PrintWriter out=response.getWriter();
      String op=request.getParameter("op");
     // HttpSession session=request.getSession(true);  
      if(op.equals("diet"))
      {
   String name= request.getParameter("id");
 int id=pko.getmemberid1(name);
 if(id!=0)
 {
     Dietplan d= pko.getdiet(id);
   if(d!=null)
   {
   out.println("yess");
   } 
   else
   {
       out.print("nooooo");
   }
 }
      }
      else{
         //int id=Integer.parseInt(session.getAttribute("gymid").toString());
         int branchid= Integer.parseInt(session.getAttribute("branchid").toString());
      
      Trainer tt=(Trainer) session.getAttribute("trainer");
     int tid= tt.getId();
    HashSet<Dietplan> hs=new HashSet<Dietplan>();
    Set<Members> m=  tt.getAdbranch().getAddmember();
 Iterator it=m.iterator();
 while(it.hasNext())
 {
    Members mm=(Members) it.next();
   Dietplan d= pko.getdiet(mm.getId());
    
   if(d!=null)
   {
        System.out.println("---------"+d.getId());
   hs.add(d);
   }
 }
     
          
            session.setAttribute("setdiet",hs);
         response.sendRedirect(scx.getContextPath()+"/gymui/pannel/trainers1.jsp");
      }
}
}
