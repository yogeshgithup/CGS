/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Allservlet;

import com.mycompany.loginmodule.Batch_member;
import com.mycompany.loginmodule.Batches;
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

/**
 *
 * @author Chiman Patel
 */
public class Addbatches extends HttpServlet {

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
           String batchname=request.getParameter("batchname");
           String batchtimefrom=request.getParameter("batchtimefrom");
           String batchtimeto=request.getParameter("batchtimeto");
           String membername[]=request.getParameterValues("membername");
           String facility=request.getParameter("facility");
           System.out.println("BAtchname"+batchname);
           System.out.println("BAtchtimefrom"+batchtimefrom);
           System.out.println("BAtchtimeto"+batchtimeto);
           System.out.println("BAtchname"+facility);
           
           Batches b=new Batches();
          b.setBatch_name(batchname);
         // b.setRole(facility);
          b.setTime_from(batchtimefrom);
          b.setTime_to(batchtimeto);
          
          HttpSession hs=request.getSession(true);
        int branchid= Integer.parseInt(hs.getAttribute("branchid").toString());
          String gymid = hs.getAttribute("gymid").toString();
        DataOperation doo=new DataOperation(scx);
       int id=doo.addBatch(b, branchid,facility,gymid);
          
          doo.addBatch_member(id, membername);
          response.sendRedirect(scx.getContextPath()+"/ViewBatches");
    }

  

}
