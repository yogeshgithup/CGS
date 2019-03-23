/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Allservlet;

import com.mycompany.loginmodule.hitcounter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import operations.DataOperation;
import org.springframework.format.datetime.DateFormatter;

/**
 *
 * @author Chiman Patel
 */
public class Hitcounter extends HttpServlet {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSessionEvent hse;
                                     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jspname=request.getParameter("jspname");
         String userid=request.getParameter("userid");
         String type=request.getParameter("type");
         System.out.println("JSPNAME"+jspname);
         System.out.println("Type"+type);
         System.out.println("ID"+userid);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
try{
Date today = new Date();

Date d = formatter.parse(formatter.format(today));
       // System.out.println("DATE:-"+d.toString());
        hitcounter hc=new hitcounter();
        hc.setUserid(Integer.parseInt(userid));
        hc.setJsppagename(jspname);
        hc.setUsertype(type);
        hc.setDate(d);
        DataOperation doo=new DataOperation(scx);
        doo.hitcounter(hc);
    }
catch(Exception e){
    
}}
}
