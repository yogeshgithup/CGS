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
import operations.DataOperation;
import operations.SMSOperation;

/**
 *
 * @author Shravan
 */
public class Forgotpassword extends HttpServlet {

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
         String n=null;
        PrintWriter out=response.getWriter();
        try
        {
        String username=request.getParameter("email");
        
        DataOperation doo=new DataOperation(scx);
    n=doo.forgotpassword(username);
    n="message sent";
            System.out.println("");
        response.sendRedirect(scx.getContextPath()+"/adminlogin.jsp?msg="+n);
            System.out.println("iiiii");
        }
        catch(Exception e)
        {
            n="failed to send message";
        }
    }
}

