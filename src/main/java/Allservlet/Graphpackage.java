/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Addpackage;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import operations.DataOperation;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Shravan
 */
public class Graphpackage extends HttpServlet {

    
         ServletContext scx;
public void init(ServletConfig sc) throws ServletException 
     {        
         super.init(sc);
         scx = getServletContext();
         System.out.println("sssss");
        try {          
            scx = sc.getServletContext();
            System.out.println("..."+scx);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      //  PrintWriter out=response.getWriter();
        
       DataOperation pko=new DataOperation(scx);
       HashSet<Addpackage> pack =pko.getpackage();
        DefaultCategoryDataset ds=new DefaultCategoryDataset();
       Iterator it= pack.iterator();
       while(it.hasNext())
       {
           Addpackage p=(Addpackage)it.next();
           int l=0;
             Set<Addgym> ab=new HashSet<Addgym>();
           if(p!=null)
           {
               System.out.println("name="+p.getName());
               System.out.println("---------"+p.getTime());
               Iterator it1=null;
               try{
           ab= p.getAdgym();
           if(ab!=null)
           {
                  // System.out.println("size="+ ab.size());
           }
               }catch(Exception e)
               {
                   System.out.println(e.toString());
               }
            while(it1!=null)
            {
             Addgym ad=(Addgym) it1.next();
             if(ad!=null)
             {
                 l++;
                System.out.println("name="+ad.getGymname()); 
             }
            }
              // System.out.println("-------"+ab.size());
           ds.setValue(ab.size(),"No. of Gym",p.getName());
           }
       }
       
        JFreeChart chart=ChartFactory.createBarChart("Comparison Chart","Package","No. of Gym", ds, PlotOrientation.VERTICAL,false, true,false);
        chart.setBackgroundPaint(Color.GREEN);
        chart.getTitle().setPaint(Color.ORANGE);
        String src="graph.jpg";
        String filepath=scx.getRealPath("/");
        System.out.println("server path:"+filepath);
          File f=new File(scx.getRealPath("/")+"/Package.jpg");
        ChartUtilities.saveChartAsJPEG(f, chart,400,400);
          response.setContentType("text/plain");
 
        
         response.setHeader("Content-disposition","attachment; filename=Package.jpg"); // Used to name the download file and its format
 
       //  File my_file = new File("E://outputtext.txt"); // We are downloading .txt file, in the format of doc with name check - check.doc
 
         
         OutputStream out = response.getOutputStream();
         FileInputStream in = new FileInputStream(f);
         byte[] buffer = new byte[4096];
         int length;
         while ((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
         }
         in.close();
         out.flush();
       // response.sendRedirect(scx.getRealPath("/")+"/graph.jpg");
        }
}
