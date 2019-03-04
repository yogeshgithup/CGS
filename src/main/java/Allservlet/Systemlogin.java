
package Allservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Systemlogin extends HttpServlet {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String msg=request.getParameter("msg");
        System.out.println("====="+msg);
        if(msg.equals("check")){
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            if(email.equals("systemadmin")&& password.equals("admin123"))
            {
                 response.sendRedirect(scx.getContextPath()+"/gymui/pannel/systemadmin1.jsp");
            }
            else
            {
                 response.sendRedirect(scx.getContextPath()+"/gymui/loginpage/Systemadminlogin.jsp?msg=wrongpassword");
            }
            
        }
    }


}
