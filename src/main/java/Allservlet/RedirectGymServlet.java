/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addgym;
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
public class RedirectGymServlet extends HttpServlet {

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
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             String d=(String)request.getAttribute("gymname");
             
           d=d.replace("%20"," ");
            System.out.println("---ooo"+d);
            System.out.println("------------------");
            DataOperation doo=new DataOperation(scx);
            Addgym gym=doo.getGymInfo(d);
          //  System.out.println("----"+gym.getGymname());           
            HttpSession hs=null;
             System.out.println("+++++++++HELLLLL"+hs.isNew());
            if(gym!=null)
            {
               hs= request.getSession(true);
                System.out.println("");
           hs.setAttribute("gyminfo",gym);
               
        
            }
           
           if(hs!=null)
           {
               if(gym.getUI().equals("demo1"))
               {
            response.sendRedirect(scx.getContextPath()+"/gymui/ui/index.jsp");
               }
               if(gym.getUI().equals("demo2"))
               {
            response.sendRedirect(scx.getContextPath()+"/gymui/ui/index2.jsp");
               }
        }
           else
           {
               System.out.println("outtt");
               response.sendRedirect(scx.getContextPath()+"/gymui/ui/ee.jsp");
           }
                   
           // response.sendRedirect(scx.getContextPath()+"/gymui/ui/index.jsp");

            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
