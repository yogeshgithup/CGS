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
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import operations.DataOperation;
import operations.DropBoxOperation;

/**
 *
 * @author Shravan
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
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
        String at = scx.getInitParameter("accesstoken");
       
     String fname=request.getParameter("firstname");
    System.out.println("rooooooooooooo");
     String mname=request.getParameter("middlename");
     String lname=request.getParameter("lastname");
        System.out.println("nnnnn");
     long pno=Long.parseLong(request.getParameter("phoneno"));
        System.out.println(pno);
        
        
     String area=request.getParameter("area");
     String street=request.getParameter("street");
     String pcode=request.getParameter("postal");
     String email=request.getParameter("email");
      HttpSession hs=request.getSession(true);
        int branchid= Integer.parseInt(hs.getAttribute("branchid").toString());
        int gymid=Integer.parseInt(hs.getAttribute("gymid").toString());
         DataOperation p=new DataOperation(scx,gymid);
      DropBoxOperation dbo = new DropBoxOperation(at, scx, gymid);
            
     //String pass=request.getParameter("password");
     String pass=p.randompassword();
     String role=request.getParameter("role");
     String desc=request.getParameter("desc");
     Part photo=request.getPart("photo");
     InputStream is = photo.getInputStream();
            String filen = extractFileName(photo);
                String url = dbo.uploadFile(filen, is);
                
    
        System.out.println("--------"+url);
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
    // t.setRole(role);
     t.setDescription(desc);
     t.setUrl(url);
     Login l=new Login();
     l.setLoginid(email);
     l.setPassword(pass);
     l.setType("traineer");
       Addgym gym = p.getGymID(gymid);
    p.addtrainer(t,branchid,gym,l,role);
     response.sendRedirect(scx.getContextPath()+"/Viewtrainer");
}
     private String extractFileName(Part part) {

        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }

        }
        return "";
    }
}