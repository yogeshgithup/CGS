/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





package Allservlet;


import com.mycompany.loginmodule.Addbranch;
import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Addpackage;
import com.mycompany.loginmodule.Login;
import com.mycompany.loginmodule.Logingym;
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



public class Loginverify extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
        
        boolean check;

        System.out.println("------servlet---51");
        String  name=request.getParameter("email");
        String password=request.getParameter("password");
        System.out.println(name);
        System.out.println(password);
        String savemsg=null;
        System.out.println("kbjcsjhkdbvcksd"+scx.getAttribute("sf"));
        DataOperation soo=new DataOperation(scx);
        Logingym l=new Logingym();
        
      l.setUsername(name);
      l.setPassword(password);
        System.out.println("hhhhhh");
        System.out.println("yynunu");
   Addgym l2=soo.verify(l);
        System.out.println("....."+l2);
        System.out.println("lllllll");
   
   if(l2.getId()==0)
    {
        System.out.println("-----");
        response.sendRedirect("adminlogin1.jsp?msg=wrong_password");
    }
   else if(l2.getId()!=0)
    {
          HttpSession hs=request.getSession(true);
           hs.setAttribute("gymid",l2.getId());
           hs.setAttribute("gymname",l2.getGymname());
           hs.setAttribute("gym",l2);
           System.out.println("gymid==="+l2.getId());
         /*  DataOperation pko=new DataOperation(scx);
           HashSet<Addbranch> listCatagory =pko.getbranch(l2.getId());
            hs.setAttribute("setbranch",listCatagory);*/
         response.sendRedirect("Viewbranch");
    }
       
       // response.sendRedirect("index.jsp?msg="+savemsg);
    }
}
        