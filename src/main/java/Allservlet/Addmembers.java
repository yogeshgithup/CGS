/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Login;
import com.mycompany.loginmodule.Members;
import com.mycompany.loginmodule.Trainer;
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
import operations.DataOperation;

/**
 *
 * @author Shravan
 */
public class Addmembers extends HttpServlet {

    
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
        HttpSession hs=request.getSession(true);
        int branchid= Integer.parseInt(hs.getAttribute("branchid").toString());
        int gymid=Integer.parseInt(hs.getAttribute("gymid").toString());
         DataOperation p=new DataOperation(scx,gymid);
       
     String area=request.getParameter("area");
     String street=request.getParameter("street");
     String pcode=request.getParameter("postal");
     String email=request.getParameter("email");
     //String pass=request.getParameter("password");
     String pass=p.randompassword();
     String dob=request.getParameter("dob");
     String health =request.getParameter("healthissue");
     String bloodgroup=request.getParameter("bloodgroup");
     String packagee=request.getParameter("package");
     float height=Float.parseFloat(request.getParameter("height"));
     float weight=Float.parseFloat(request.getParameter("weight"));
     
     
     
        Members m=new Members();
        m.setArea(area);
        m.setBlood(bloodgroup);
        m.setDob(dob);
        m.setEmail(email);
        m.setFirstname(fname);
        m.setHealth(health);
        m.setHeight(height);
        m.setLastname(lname);
        m.setMiddlename(mname);
      //  m.setPackagee(packagee);
        m.setPassword(pass);
        m.setPhoneno(pno);
        m.setPostalcode(pcode);
        m.setStreet(street);
        m.setWeight(weight);
     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));
        m.setDate(dtf.format(localDate).toString());
     Login l=new Login();
     l.setLoginid(email);
     l.setPassword(pass);
     l.setType("member");
       Addgym gym = p.getGymID(gymid);
    p.addmember(m,branchid,gym,l,packagee);
     response.sendRedirect(scx.getContextPath()+"/Viewmembers?op=mem");
}
}
