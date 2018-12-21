/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Gyminfo;
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
 * @author Shravan
 */
public class Addaboutus extends HttpServlet {

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
       
        String title=request.getParameter("title");
        String desc=request.getParameter("desc");
        
        Gyminfo g=new Gyminfo();
        g.setAbout_us_title(title);
        g.setAbout_us_desc(desc);
        
        DataOperation doo=new DataOperation(scx);
          HttpSession hs = request.getSession(true);
        int gymid = Integer.parseInt(hs.getAttribute("gymid").toString());
        Addgym gym = doo.getGymID(gymid);
        doo.addaboutus(g, gym);
        
         response.sendRedirect(scx.getContextPath()+"/gymui/pannel/aboutusediting.jsp");
  }
}
