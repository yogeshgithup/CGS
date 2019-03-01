/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Allservlet;

import com.mycompany.loginmodule.Dietplan;
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
 * @author Administrator
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) 
public class Adddietplan extends HttpServlet {

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
       
          HttpSession hs = request.getSession(true);
        int gymid = Integer.parseInt(hs.getAttribute("gymid").toString());
        DataOperation doo=new DataOperation(scx,gymid);
        DropBoxOperation dbo = new DropBoxOperation(at, scx, gymid);
        String batchname=request.getParameter("op1");
        String membersname=request.getParameter("op2");
        String memberstartdate=request.getParameter("memberstartdate");
        String memberenddate=request.getParameter("memberenddate");
        String description=request.getParameter("description");
        System.out.println("batchNAme:-"+batchname);
        System.out.println("Members Start Date:-"+memberstartdate);
        System.out.println("Members end Date:-"+memberenddate);
        System.out.println("Description:-"+description);
         Part photo=request.getPart("dietplan");
     InputStream is = photo.getInputStream();
            String filen = extractFileName(photo);
                String url = dbo.uploadFile(filen, is);
                
                Dietplan dp=new Dietplan();
                dp.setMemstartdate(memberstartdate);
                        dp.setMemenddate(memberenddate);
                        dp.setDescription(description);
                        dp.setPhoto(url);
                        System.out.println("---"+url);
                      
        Trainer t= (Trainer)hs.getAttribute("trainer");
                        doo.Adddietplan(dp, batchname, membersname,String.valueOf( t.getAdbranch().getId()));
             response.sendRedirect(scx.getContextPath()+"/Viewdiet?op=msg");
 
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
