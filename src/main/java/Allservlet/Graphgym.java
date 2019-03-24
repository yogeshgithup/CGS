/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addbranch;
import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Addpackage;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class Graphgym extends HttpServlet {

   
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
        HttpSession session=request.getSession(true);  
      Addgym ad= (Addgym) session.getAttribute("gym");
        System.out.println("-------"+ad.getGymname());
        DefaultCategoryDataset ds=new DefaultCategoryDataset();
      
      Iterator it= ad.getAdbarnch().iterator();
      if(it!=null)
      {
          while(it.hasNext())
          {
         Addbranch bb=(Addbranch) it.next();
        bb.getAddmember().size();
          ds.setValue(bb.getAddmember().size(),"No. of Members",bb.getBranchname());
          }
      }
               
         
        
       
        JFreeChart chart=ChartFactory.createBarChart("Comparison Chart","Branch","No. of Members", ds, PlotOrientation.VERTICAL,false, true,false);
        chart.setBackgroundPaint(Color.GREEN);
        chart.getTitle().setPaint(Color.ORANGE);
        String src="graph.jpg";
        String filepath=scx.getRealPath("/");
        System.out.println("server path:"+filepath);
          File f=new File(scx.getRealPath("/")+"/Members.jpg");
        ChartUtilities.saveChartAsJPEG(f, chart,400,400);
          response.setContentType("text/plain");
 
        
         response.setHeader("Content-disposition","attachment; filename=Members.jpg"); // Used to name the download file and its format
 
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
