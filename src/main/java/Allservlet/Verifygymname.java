/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Allservlet;

import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Logingym;
import com.mycompany.loginmodule.Pack_facility;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
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
public class Verifygymname extends HttpServlet {

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        DataOperation doo = new DataOperation(scx);
        if (request.getParameter("id") != null) {
            String gymname = request.getParameter("id");
       // System.out.println(gymname);

            String answer = doo.verifygymname(gymname);
            if (answer.equals("already exists")) {
                out.println(answer);
            }

        }

        if (request.getParameter("package") != null) {
            String packagename = request.getParameter("package");
       // System.out.println(gymname);

            String answer = doo.verifypackagename(packagename);
            if (answer.equals("already exists")) {
                out.println(answer);
            }
        }

    if (request.getParameter("email") != null) {
            String email = request.getParameter("email");
       // System.out.println(gymname);

            String answer = doo.verifyemail(email);
            String ans=answer;
            System.out.println("mmm"+answer);
            if (answer.equals(ans)) {
                System.out.println("lllll"+answer);
                out.println(answer);
            }
          
        }
     if (request.getParameter("emailuser") != null) {
            String email = request.getParameter("emailuser");
       // System.out.println(gymname);
System.out.println("---"+email);
            String answer = doo.verifyemailuser(email);
            String ans=answer;
            System.out.println("mmm"+answer);
            if (answer.equals(ans)) {
                System.out.println("lllll"+answer);
                out.println(answer);
            }
          
        }
       if (request.getParameter("useremail") != null) {
            String email = request.getParameter("useremail");
       // System.out.println(gymname);
System.out.println("---"+email);
            String answer = doo.verifyuseremail(email);
           
            System.out.println("mmm"+answer);
            if (answer.equals("enter another email")) {
                System.out.println("lllll"+answer);
                out.println(answer);
            }
            else{
                out.println("noo");
            }
        }
    
    
       if (request.getParameter("branch") != null) {
           HttpSession hs = request.getSession(true);
        int gymid = Integer.parseInt(hs.getAttribute("gymid").toString());
        Addgym gym = doo.getGymID(gymid);
            String branchname = request.getParameter("branch");
       // System.out.println(gymname);

            String answer = doo.verifybranchname(branchname,gym.getId());
            if (answer.equals("already exists")) {
                out.println(answer);
            }
        }
    
        if (request.getParameter("bname") != null) {
         
        
            String branchname = request.getParameter("bname");
       // System.out.println(gymname);

            String answer = doo.verifybranch(branchname);
            if (answer.equals("already exists")) {
                out.println(answer);
            }
        }
        
          if (request.getParameter("gympackage") != null) {
         
        
            String packageid = request.getParameter("gympackage");
       System.out.println(packageid);

           //HashSet<Pack_facility> pf=new HashSet();
        String pf=doo.getpacfacility(Integer.parseInt(packageid));
          if(pf!=null)
          {
              out.println(pf);
          }
        }
    }
    
    }


