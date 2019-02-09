/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Allservlet;

import com.mycompany.loginmodule.Facility;
import com.mycompany.loginmodule.Members;
import com.mycompany.loginmodule.Trainer;
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
import org.json.JSONArray;

/**
 *
 * @author Administrator
 */
public class Viewmembers extends HttpServlet {

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
             HttpSession hs=request.getSession(true);
        int branchid= Integer.parseInt(hs.getAttribute("branchid").toString());
            HashSet<Members> listCatagory =pko.getmembers(branchid);
       
          String op=request.getParameter("op");
            System.out.println("8999"+op);
           hs.setAttribute("setmember",listCatagory);
          if(hs!=null)
          {
              if(op.equals("view"))
              {
                   int id=Integer.parseInt(hs.getAttribute("gymid").toString());
            HashSet<Facility> listCat =pko.getfacility(id);
       
           
           hs.setAttribute("viewfacility",listCat);
                  System.out.println("op---"+op);
                response.sendRedirect(scx.getContextPath()+"/gymui/pannel/addbatches1.jsp");   
              }
              else if(op.equals("mem"))
              {
              response.sendRedirect(scx.getContextPath()+"/gymui/pannel/managemembers1.jsp");
              }
          }
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out=response.getWriter();
        
       DataOperation pko=new DataOperation(scx);
     
 
        try {
          String id=request.getParameter("id");
            System.out.println("===="+id);
       JSONArray ja=pko.getMembersname(id);
            System.out.println("----"+ja);
        out.println(ja);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
    
}
