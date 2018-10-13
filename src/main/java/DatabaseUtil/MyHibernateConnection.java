/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.hibernate.HibernateException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyHibernateConnection implements ServletContextListener {

    private SessionFactory sfobj;

    @Override
    public void contextInitialized(ServletContextEvent sceobj) {
        System.out.println("------ci---22");
        
        ServletContext ctx;
        try{
        sfobj = new Configuration().configure("com/mypack/mavenhibernate/hibernate.cfg.xml").buildSessionFactory();

        ctx = sceobj.getServletContext();
        System.out.println("----"+ctx);
        ctx.setAttribute("sf", sfobj);
       
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void contextDestroyed(ServletContextEvent sceobj) {
        ServletContext ctx;

        try {
            
            ctx = sceobj.getServletContext();

            sfobj = (SessionFactory) ctx.getAttribute("sf");
               
            sfobj.close();

        } catch (HibernateException hb) {
            System.out.println(hb.getMessage());
        }
    }

}
