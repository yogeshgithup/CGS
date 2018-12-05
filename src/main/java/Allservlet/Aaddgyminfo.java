/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Achievements;
import com.mycompany.loginmodule.Gallery;
import com.mycompany.loginmodule.Gyminfo;
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
 *///@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class Aaddgyminfo extends HttpServlet {

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
        String image_url=null;
        String logo_url=null;
        System.out.println("--------");
         Part logo= request.getPart("logo");
          try{
     
        InputStream is=logo.getInputStream();
            System.out.println("geturl------"+is);
        String at=scx.getInitParameter("accesstoken");
            System.out.println("accesstoken---------"+at);
        DropBoxOperation dbo=new DropBoxOperation(at);
          String filename=extractFileName(logo);
            System.out.println("filename--------"+filename);
          logo_url=dbo.uploadFile(filename, is); 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
         Part image=request.getPart("image");
             try{
     
        InputStream is=image.getInputStream();
            System.out.println("geturl------");
        String at=scx.getInitParameter("accesstoken");
            System.out.println("accesstoken---------"+at);
        DropBoxOperation dbo=new DropBoxOperation(at);
          String filename=extractFileName(image);
            System.out.println("filename--------"+filename);
         image_url=dbo.uploadFile(filename, is); 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
         String img_desc=request.getParameter("imagedesc");
         String title=request.getParameter("title");
         String ach_desc=request.getParameter("descr");
         String qual_msg=request.getParameter("qualitymsg");
         System.out.println("2-------------");
         DataOperation doo=new DataOperation(scx);
          
       // String logo_url= geturl(logo);
         // String image_url=geturl(image);
        
           HttpSession hs=request.getSession(true);
        int gymid= Integer.parseInt(hs.getAttribute("gymid").toString());
         Achievements  achi=new Achievements();
         
       achi.setAchievement(title);
       achi.setAchive_descr(ach_desc);
       doo.addachievements(achi,gymid);
         
         Gallery g=new Gallery();
         
         g.setPhoto(image_url);
         g.setDescription(img_desc);
         doo.addgallery(g,gymid);
         
         Gyminfo gi=new Gyminfo();
         
         gi.setLogo_url(logo_url);
         gi.setQuality_msg(qual_msg);
         doo.addgyminfo(gi,gymid);
         
     response.sendRedirect(scx.getContextPath()+"/gymui/pannel/mainpagewditing.jsp");
    }
    
    private String extractFileName(Part part) {
        System.out.println("[[[[[[[[");
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
            System.out.println("]]]]]]]]]]]");
        }
        return "";
    }
}
