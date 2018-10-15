/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operations;

import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Addpackage;
import com.mycompany.loginmodule.Login;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Shravan
 */
public class DataOperation {
    ServletContext scx;
    SessionFactory sfobj;
    Session session;
    Transaction tx = null;
     HashSet<Addpackage> setpack=null;
     HashSet<Addgym> setgym=null;
     int j=0;
    public DataOperation(ServletContext scx) {
        this.scx=scx;
    }
    
     public int verify(Login l) {

        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            String b = "branchoperator";
            String c = "traineer";
            
            
            Query q = session.createQuery("from Login where loginid=:lname and password=:pass");
            q.setString("lname", l.getLoginid());
            q.setString("pass", l.getPassword());
            List<Login> results = q.list();

            l = (Login) results.get(0);
            //System.out.println("mmmmm"+l.getType());
          
            if(b.equals(l.getType())) {
                j=j+1;
           //     System.out.println(",,,,"+j);
            }
            
             if (c.equals(l.getType())) {
                j=j+2;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("///" + j);
        return j;
    }

    
    public void addpackage(Addpackage p1)
    {
        try{
            System.out.println("line 37");
         sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println(",,,"+sfobj);
            session = sfobj.openSession();
            tx = session.beginTransaction();
            session.save(p1);
            tx.commit();
            session.close();
    }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public HashSet<Addpackage> getpackage()
    {
         try {
             System.out.println("before calling");
             setpack=new HashSet<Addpackage>();
             System.out.println("line 55"+scx);
               sfobj = (SessionFactory) scx.getAttribute("sf");
               System.out.println("line 57"+sfobj);
                        session = sfobj.openSession();
                        System.out.println("line 59");
                        tx = session.beginTransaction();
                        System.out.println("get package"); 
                         Addpackage p1=null;
                        Query q = session.createQuery("from Addpackage");
                        System.out.println("gp 59");
                        List<Addpackage> results = q.list();
                        System.out.println("query");
                        for (int i = 0; i <= results.size(); i++) {
                            p1 = (Addpackage) results.get(i);
                            System.out.println("......."+p1.getName());
                            Addpackage p2=new Addpackage(p1.getId(),p1.getName(),p1.getTime(),p1.getAmount(),p1.getNo_of_branches());
                            setpack.add(p2);
                        }
                        
                        tx.commit();
                    session.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
       
         return setpack;
    }
    
    public void addgym(Addgym ag)
    {
        try {
             sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            
            session.save(ag);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void addgymowneruser(Login l)
    {
        
         try {
             sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            
            session.save(l);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public HashSet<Addgym> getgym()
    {
         try {
             System.out.println("before calling");
             setgym=new HashSet<Addgym>();
             System.out.println("line 55"+scx);
               sfobj = (SessionFactory) scx.getAttribute("sf");
               System.out.println("line 57"+sfobj);
                        session = sfobj.openSession();
                        System.out.println("line 59");
                        tx = session.beginTransaction();
                        System.out.println("get package"); 
                         Addgym p1=null;
                        Query q = session.createQuery("from Addgym");
                        System.out.println("gp 59");
                        List<Addgym> results = q.list();
                        System.out.println("query");
                        for (int i = 0; i <= results.size(); i++) {
                            p1 = (Addgym) results.get(i);
                            Addgym p2=new Addgym(p1.getId(),p1.getGymname(),p1.getOwnername(),p1.getStreet(),p1.getArea(),p1.getPostcode(),p1.getPhoneno(),p1.getUsername(),p1.getPassword(),p1.getPackagee());
                            setgym.add(p2);
                        }
                        
                        tx.commit();
                    session.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
       
         return setgym;
    }
}
