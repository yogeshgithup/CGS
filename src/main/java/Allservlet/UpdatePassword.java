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
public class UpdatePassword extends HttpServlet {

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
            System.out.println(" ppppp11111111111   ");
        HttpSession hs=request.getSession(true);
            DataOperation doo=new DataOperation(scx);
            if(request.getParameter("msg").equals("gymadmin"))
            {
                System.out.println("-----------111111111");
             String pass= request.getParameter("new");
                System.out.println("+++++++"+pass);
           Addgym g=(Addgym)hs.getAttribute("gym");
           
         String msg=  doo.UpdatePasswordGym(g, pass);
                System.out.println("---"+msg);
                response.sendRedirect(scx.getContextPath()+"/gymui/pannel/changepasswordgymadmin.jsp?msg="+msg);
        
            }
              if(request.getParameter("msg").equals("branchoperator"))
            {
                System.out.println("-----------1111++++++11111");
             String pass= request.getParameter("new");
                System.out.println("+++++++"+pass);
          // Addgym g=(Addgym)hs.getAttribute("gym");
            Addbranch g=(Addbranch)hs.getAttribute("branchobj");
                System.out.println("ooooooo");
         String password=g.getAbo().getPassword();
         String msg=  doo.UpdatePasswordBranchop(g, pass);
                System.out.println("---"+msg);
                response.sendRedirect(scx.getContextPath()+"/gymui/pannel/changepasswordgymadmin.jsp?msg="+msg);
        
            }
              if(request.getParameter("msg").equals("trainer"))
            {
                System.out.println("-----------1111++11");
             String pass= request.getParameter("new");
                System.out.println("+++++++"+pass);
          // Addgym g=(Addgym)hs.getAttribute("gym");
            Trainer g=(Trainer)hs.getAttribute("trainer");
                System.out.println("ooooooo");
         String password=g.getPassword();
         String msg=  doo.UpdatePasswordTrainer(g, pass);
                System.out.println("---"+msg);
                response.sendRedirect(scx.getContextPath()+"/gymui/pannel/changepasswordtrainer.jsp?msg="+msg);
        
            }
              if(request.getParameter("msg").equals("member"))
            {
                System.out.println("-----------1111++11");
             String pass= request.getParameter("new");
                System.out.println("+++++++"+pass);
          // Addgym g=(Addgym)hs.getAttribute("gym");
            Members g=(Members)hs.getAttribute("member");
                System.out.println("ooooooo");
         String password=g.getPassword();
         String msg=  doo.UpdatePasswordMember(g, pass);
                System.out.println("---"+msg);
                response.sendRedirect(scx.getContextPath()+"/gymui/pannel/changepasswordmember.jsp?msg="+msg);
        
            }
        }
        catch(Exception e)
        {
            System.out.println("---"+e.getMessage());
        }
}
}
