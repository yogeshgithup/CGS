/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Allservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
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
        String batchname=request.getParameter("op1");
        String membersname=request.getParameter("op2");
        String memberstartdate=request.getParameter("memberstartdate");
        String memberenddate=request.getParameter("memberenddate");
        String description=request.getParameter("description");
        System.out.println("batchNAme:-"+batchname);
        System.out.println("Members Start Date:-"+memberstartdate);
        System.out.println("Members end Date:-"+memberenddate);
        System.out.println("Description:-"+description);
    }


}
