/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Login;
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
public class Addtrainer extends HttpServlet {

      ServletContext scx;

    @Override
public void init(ServletConfig sc) throws ServletException 
     {        
System.out.println("hiii");
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
     String fname=request.getParameter("firstname");
    System.out.println("rooooooooooooo");
     String mname=request.getParameter("middlename");
     String lname=request.getParameter("lastname");
        System.out.println("nnnnn");
     long pno=Long.parseLong(request.getParameter("phoneno"));
        System.out.println(pno);
        
         DataOperation p=new DataOperation(scx);
     String area=request.getParameter("area");
     String street=request.getParameter("street");
     String pcode=request.getParameter("postal");
     String email=request.getParameter("email");
     //String pass=request.getParameter("password");
     String pass=p.randompassword();
     String role=request.getParameter("role");
     String desc=request.getParameter("desc");
     HttpSession hs=request.getSession(true);
        int branchid= Integer.parseInt(hs.getAttribute("branchid").toString());
        int gymid=Integer.parseInt(hs.getAttribute("gymid").toString());
       
     Trainer t=new Trainer();
     t.setFirstname(fname);
     t.setMiddlename(mname);
     t.setLastname(lname);
     t.setArea(area);
     t.setPostalcode(pcode);
     t.setStreet(street);
     t.setPhoneno(pno);
     t.setEmail(email);
     t.setPassword(pass);
     t.setRole(role);
     t.setDescription(desc);
     Login l=new Login();
     l.setLoginid(email);
     l.setPassword(pass);
     l.setType("traineer");
       Addgym gym = p.getGymID(gymid);
    p.addtrainer(t,branchid,gym,l);
     response.sendRedirect(scx.getContextPath()+"/Viewtrainer");
}
}