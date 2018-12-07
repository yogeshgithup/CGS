/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Allservlet;

import com.mycompany.loginmodule.addbranchoperator;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import operations.DataOperation;

/**
 *
 * @author Administrator
 */
public class addbranchop extends HttpServlet {

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
        System.out.println("bhgvyhviu");
     String area=request.getParameter("area");
     String street=request.getParameter("street");
     String pcode=request.getParameter("postalcode");
     String email=request.getParameter("email");
     String pass=request.getParameter("password");
     String bname=request.getParameter("branchname");
     addbranchoperator bo=new addbranchoperator();
     bo.setFirstname(fname);
     bo.setMiddlename(mname);
     bo.setLastname(lname);
     bo.setPhoneno(pno);
     bo.setArea(area);
     bo.setStreet(street);
     bo.setPostalcode(pcode);
     bo.setEmail(email);
     bo.setPassword(pass);
     bo.setBranchname(bname);
        System.out.println("value"+bname);
   DataOperation p=new DataOperation(scx);
      p.addbranchoperator(bo);
     response.sendRedirect(scx.getContextPath()+"/gymui/pannel/managebranchoperator.jsp");
    }

}
