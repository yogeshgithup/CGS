/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Login;
import com.mycompany.loginmodule.Logingym;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import operation.EmailOperation;
import operations.DataOperation;
import operations.SMSOperation;

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
        String n=null;
        PrintWriter out=response.getWriter();
        try
        {
        String gymname=request.getParameter("gymname");
        String ownername=request.getParameter("ownername");
        String street=request.getParameter("street");
        String area=request.getParameter("area");
        String postcode=request.getParameter("postalcode");
        long phoneno=Long.parseLong(request.getParameter("phoneno"));
        String username=request.getParameter("username");
        //String password=request.getParameter("password");
        String packagee=request.getParameter("package");
     String ui=request.getParameter("theme");
         DataOperation doo=new DataOperation(scx);
         String phno=String.valueOf(phoneno);
        Logingym l=new Logingym();
        Addgym ag=new Addgym();
        ag.setGymname(gymname);
        ag.setOwnername(ownername);
        ag.setStreet(street);
        ag.setArea(area);
        ag.setPostcode(postcode);
        ag.setPhoneno(String.valueOf(phoneno));
        ag.setUsername(username);
        ag.setUI(ui);
          String pass=doo.randompassword();
        ag.setPassword(pass);
        ag.setPackagee(packagee);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now();
        
	System.out.println(dtf.format(localDate));
        ag.setDate(dtf.format(localDate).toString());
        l.setUsername(username);
      
        l.setPassword(pass);
        l.setType("gymadmin");
        ag.setL(l);
        l.setA(ag);
     
       n=doo.addgym(ag);
        }
        catch(Exception e)
        {
            n="failed to add gym";
        }
         //  hs.setAttribute("msg",s);
          // System.out.println(hs.getAttribute("msg").toString());
           
       response.sendRedirect(scx.getContextPath()+"/gymui/pannel/addgym1.jsp?msg="+n);
        
    }
}
