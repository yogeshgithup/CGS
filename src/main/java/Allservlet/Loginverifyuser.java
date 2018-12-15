/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Login;
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
public class Loginverifyuser extends HttpServlet {

    
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
        String  name=request.getParameter("email");
        String password=request.getParameter("password");
        System.out.println(name);
        System.out.println(password);
        String savemsg=null;
        
        DataOperation so=new DataOperation(scx);
        Login l=new Login();
        
      l.setLoginid(name);
      l.setPassword(password);
        System.out.println("hhhhhh");
   Login l2=so.verifyusers(l);
        System.out.println("....."+l2);
        System.out.println("lllllll");
        System.out.println(l2.getType());
        String b="branchoperator";
        String t="traineer";
        String m="member";
    if(b.equals(l2.getType()))
    {
       int branchid=so.getbranchid(name);
       int gymid=so.getgymid(branchid);
        System.out.println("-----"+branchid);
        System.out.println("++++"+gymid);
         HttpSession hs=request.getSession(true);
           hs.setAttribute("gymid",gymid);
           hs.setAttribute("branchid",branchid);
         response.sendRedirect(scx.getContextPath()+"/gymui/pannel/branchoperator.jsp");
    }
    else if(t.equals(l2.getType()))
    {
        
         response.sendRedirect(scx.getContextPath()+"/gymui/pannel/trainers.jsp");
    }
       
    else if(m.equals(l2.getType()))
    {
        
         response.sendRedirect(scx.getContextPath()+"/gymui/pannel/members.jsp");
    }
    else
    {
         response.sendRedirect(scx.getContextPath()+"/gymui/pannel/adminlogin.jsp");
    }
       
// response.sendRedirect("index.jsp?msg="+savemsg);
    }


}
