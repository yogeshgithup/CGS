/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addbranch;
import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Members;
import com.mycompany.loginmodule.Trainer;
import com.mycompany.loginmodule.addbranchoperator;
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
public class VerifyPassword extends HttpServlet {

  ServletContext scx;

    @Override
    public void init(ServletConfig sc) throws ServletException {

        super.init(sc);
        scx = getServletContext();

        try {
            scx = sc.getServletContext();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     doPost(request,response);
 }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try
        {
        PrintWriter out = response.getWriter();
            System.out.println(" ppppp   ");
        HttpSession hs=request.getSession(true);
            DataOperation doo=new DataOperation(scx);
            if(request.getParameter("msg").equals("gymadmin"))
            {
                System.out.println("-----------");
             String pass= request.getParameter("pass");
           Addgym g=(Addgym)hs.getAttribute("gym");
                System.out.println("ooooooo");
         String password=g.getPassword();
         if(pass.equals(password))
         {
             System.out.println("+++++++++");
             out.println("yesss");
         }
         else
         {
              out.println("nooo");
         }
            }
            if(request.getParameter("msg").equals("branchop"))
            {
                System.out.println("-----------");
             String pass= request.getParameter("pass");
          Addbranch g=(Addbranch)hs.getAttribute("branchobj");
                System.out.println("ooooooo");
         String password=g.getAbo().getPassword();
         if(pass.equals(password))
         {
             System.out.println("+++++++++");
             out.println("yesss");
         }
         else
         {
              out.println("nooo");
         }
            }
             if(request.getParameter("msg").equals("trainer"))
            {
                System.out.println("-----------");
             String pass= request.getParameter("pass");
          Trainer g=(Trainer)hs.getAttribute("trainer");
                System.out.println("ooooooo");
         String password=g.getPassword();
         if(pass.equals(password))
         {
             System.out.println("+++++++++");
             out.println("yesss");
         }
         else
         {
              out.println("nooo");
         }
            }
              if(request.getParameter("msg").equals("member"))
            {
                System.out.println("-----------");
             String pass= request.getParameter("pass");
          Members g=(Members)hs.getAttribute("member");
                System.out.println("ooooooo");
         String password=g.getPassword();
         if(pass.equals(password))
         {
             System.out.println("+++++++++");
             out.println("yesss");
         }
         else
         {
              out.println("nooo");
         }
            }
        }
        catch(Exception e)
        {
            System.out.println("---"+e.getMessage());
        }
}
}
