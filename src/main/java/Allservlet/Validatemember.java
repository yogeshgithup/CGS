/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Members;
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
public class Validatemember extends HttpServlet {

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
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     doPost(request,response);
 }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try
        {
        PrintWriter out = response.getWriter();
        
        HttpSession hs=request.getSession(true);
        int branchid= Integer.parseInt(hs.getAttribute("branchid").toString());
        int gymid=Integer.parseInt(hs.getAttribute("gymid").toString());
        DataOperation doo=new DataOperation(scx);
        if(request.getParameter("msg").equals("one"))
        {
         if (request.getParameter("id") != null) {
         
             String id = request.getParameter("id");
             doo.sendmessage(id);
             out.println("message send");
         }
        }
        else if(request.getParameter("msg").equals("all"))
        {
            String branchidi=request.getParameter("id");
            System.out.println("---"+branchidi);
            doo.sendmessage_all(branchidi);
            out.println("message sent to all");
        }
        else if(request.getParameter("msg").equals("view"))
        {
        
       HashSet<Members> listCatagory=doo.invalidmember(branchid);
        hs.setAttribute("setvalidmember",listCatagory);
          if(hs!=null)
          {
              response.sendRedirect(scx.getContextPath()+"/gymui/pannel/view_X_members1.jsp");
          }
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
}
