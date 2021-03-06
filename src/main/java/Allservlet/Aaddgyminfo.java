/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Allservlet;

import com.mycompany.loginmodule.Achievements;
import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Gallery;
import com.mycompany.loginmodule.Gyminfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
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
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class Aaddgyminfo extends HttpServlet {

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
        Collection<Part> colpart = request.getParts();
        Iterator<Part> itp = colpart.iterator();
        //ArrayList<Gallery> gal = new ArrayList<>();
        String at = scx.getInitParameter("accesstoken");
        
      
        HttpSession hs = request.getSession(true);
        int gymid = Integer.parseInt(hs.getAttribute("gymid").toString());
        DropBoxOperation dbo = new DropBoxOperation(at, scx, gymid);
          DataOperation doo = new DataOperation(scx,gymid);
        Addgym gym = doo.getGymID(gymid);
        System.out.println("gymid"+gym.getId()+"gym nme-"+gym.getGymname());
        Set<Gallery> ab = new HashSet<Gallery>();
       ab = gym.getGallery();
        //int i=0;
        Set<Achievements> av = new HashSet<Achievements>();
        av = gym.getAchive();
      
       
       
         
        String desc[]=request.getParameterValues("descr");
         String title[]=request.getParameterValues("title");
         for(int i=0;i<desc.length;i++)
         {
             Achievements ac = new Achievements();
             ac.setAchievement(title[i]);
             ac.setAchive_descr(desc[i]);
             System.out.println("83"+desc[i]+"   "+title[i]);
           //  ac.setAdgym(gym);
             av.add(ac);
         }
         ArrayList<String> logo=new ArrayList<>();
           ArrayList<String> photo=new ArrayList<>();
           int k=0;
         while (itp.hasNext()) {
            Part p = itp.next();
            String ctrln = p.getName();
           

            if (ctrln.equals("logo")) {
 InputStream is = p.getInputStream();
            String filen = extractFileName(p);
                String url = dbo.uploadFile(filen, is);
                System.out.println("pop"+url);
                if(url!=null)
                {
               logo.add(url);
                }
                else
                {
                   k++; 
                }
            }
            if (ctrln.equals("image")) {
InputStream is = p.getInputStream();
            String filen = extractFileName(p);
                String url = dbo.uploadFile(filen, is);
                System.out.println("image-" + url);
                if(url!=null)
                {
                photo.add(url);
                }
                else
                {
                    k++;
                }
            }
        }
        Gyminfo gi = new Gyminfo();
         String quality[]=request.getParameterValues("qualitymsg");
           for(int i=0;i<logo.size();i++)
         {
             
             System.out.println("---"+logo.get(i)+"++"+quality[i]);
            gi.setLogo_url(logo.get(i));
           
            gi.setQuality_msg(quality[i]);
           // gi.setA(gym);
             
         }
           System.out.println("line 114");
    

 String image[]=request.getParameterValues("imagedesc");
           for(int i=0;i<photo.size();i++)
         {
             System.out.println("134-"+image[i]);
              Gallery g = new Gallery();
            g.setDescription(image[i]);
            g.setPhoto(photo.get(i));
           // g.setAdgym(gym);
            ab.add(g);
            
         }
        System.out.println("00000000000");
       if(k==0)
       {
           System.out.println("k==0");
       
       
      doo.addgyminfo(av,ab,gi,gymid);
      //hs.setAttribute("gym",gym);
       response.sendRedirect(scx.getContextPath()+"/Viewedit?msg=added");
       }
       else
       {
          response.sendRedirect(scx.getContextPath()+"/Viewedit?msg=not added --- error in drop box");  
       }
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
