/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Facility;
import com.mycompany.loginmodule.Gallery;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
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
public class Addfacility extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
   
      String faci[]=request.getParameterValues("faci");
        System.out.println("ppp"+faci);
          DataOperation doo = new DataOperation(scx);
       
         HttpSession hs = request.getSession(true);
        int gymid = Integer.parseInt(hs.getAttribute("gymid").toString());
//        Addgym gym=doo.getGymID(gymid);
//         Set<Facility> fac = new HashSet<Facility>();
//        fac=gym.getFacility();
//         System.out.println("pppp"+faci.length);
//       for(int i=0;i<faci.length;i++)
//       {
//          
//           Facility f=new Facility();
//           System.out.println("jjj-"+faci[i]);
//                   f.setName(faci[i]);
//                   f.setAdgym(gym);
//                   fac.add(f);
//       }
//      
//     
//     
//      gym.setFacility(fac);
//        
       doo.addfacility(gymid,faci);
        response.sendRedirect(scx.getContextPath()+"/Viewfacilities?msg=facility");
   }
}