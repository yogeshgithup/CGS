/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addbranch;
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
import javax.servlet.http.HttpSession;
import operations.DataOperation;
import operations.SMSOperation;

/**
 *
 * @author Shravan
 */
public class Aaddbranch extends HttpServlet {

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
        
        String branchname=request.getParameter("branchname");
        String street=request.getParameter("street");
       
        String area=request.getParameter("area");
        String postcode=request.getParameter("postalcode");
       
         DataOperation doo=new DataOperation(scx);
         Addbranch ab=new Addbranch();
         System.out.println(".............");
         ab.setBranchname(branchname);
         ab.setStreet(street);
         ab.setArea(area);
         ab.setPostalcode(postcode);
         
          HttpSession hs=request.getSession(true);
        int gymid= Integer.parseInt(hs.getAttribute("gymid").toString());
        System.out.println(gymid);
         doo.addbranch(ab, gymid);
      
    }
}
