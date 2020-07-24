/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseUtil;

import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.classloading.spi.ClassLoadingException;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.exception.SQLGrammarException;
import org.hibernate.metamodel.ValidationException;

public class MyHibernateConnection implements ServletContextListener {

    private SessionFactory sfobj;

    @Override
    public void contextInitialized(ServletContextEvent sceobj) {
        System.out.println("------ci---22");
        
        ServletContext  ctx = sceobj.getServletContext();
        String msg="";
                
        try{
        sfobj = new Configuration().configure("com/pack/mypack/mavenhibernate/hibernate.cfg.xml").buildSessionFactory();
            System.out.println("---------");
       
        System.out.println("----jjjjj"+ctx);
            System.out.println("cccccc"+sfobj);
        ctx.setAttribute("sf", sfobj);
       
        }
//        catch(HibernateException e)
//        {
//            System.out.println("==="+e.toString());
//        }
        catch(JDBCConnectionException e)
        {
            System.out.println("----username");
            System.out.println("------"+e.getMessage());
            System.out.println("+++++"+e.getLocalizedMessage());
            System.out.println("____"+e.toString());
          msg=msg+"JDBC wrong password in hibernate.cfg.xml file";
        }
        catch(SQLGrammarException eq)
        {
            System.out.println("----"+eq.toString());
            msg=msg+"wrong username or url in hibernate.cfg.xml file ";
        }
        catch(ClassLoadingException g)
        {
            System.out.println("---"+g.toString());
            msg=msg+"wrong class in hibernate.cfg.xml file";
        }
       
        ctx.setAttribute("msg",msg);
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
