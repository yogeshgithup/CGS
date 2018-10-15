/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Login;
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
 * @author Shravan
 */
public class Aaddgym extends HttpServlet {

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
        
        String gymname=request.getParameter("gymname");
        String ownername=request.getParameter("ownername");
        String street=request.getParameter("street");
        String area=request.getParameter("area");
        String postcode=request.getParameter("postcode");
        int phoneno=Integer.parseInt(request.getParameter("phoneno"));
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String packagee=request.getParameter("package");
        Login l=new Login();
        Addgym ag=new Addgym();
        ag.setGymname(gymname);
        ag.setOwnername(ownername);
        ag.setStreet(street);
        ag.setArea(area);
        ag.setPostcode(postcode);
        ag.setPhoneno(phoneno);
        ag.setUsername(username);
        ag.setPassword(password);
        ag.setPackagee(packagee);
        l.setLoginid(username);
        l.setPassword(password);
        l.setType("gymadmin");
       DataOperation doo=new DataOperation(scx);
       doo.addgym(ag);
       doo.addgymowneruser(l);
    }
}
