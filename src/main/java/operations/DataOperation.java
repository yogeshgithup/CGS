/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operations;

import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Addpackage;
import com.mycompany.loginmodule.Login;
import com.mycompany.loginmodule.Logingym;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
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
    
     public int verify(Logingym l) {

        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            
            
            Query q = session.createQuery("from Logingym where username=:lname and password=:pass");
            q.setString("lname", l.getUsername());
            q.setString("pass", l.getPassword());
            List<Logingym> results = q.list();

            l =(Logingym)results.get(0);
            if(l!=null)
            {
                j=j+1;
            }
            else
                j=j+2;
            //System.out.println("mmmmm"+l.getType());
          
           /* if(b.equals(l.getType())) {
                j=j+1;
           //     System.out.println(",,,,"+j);
            }
            
             if (c.equals(l.getType())) {
                j=j+2;
            }*/

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
    
    public String randompassword()
    {
          String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
         String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
        String numbers = "0123456789"; 
                String symbols = "@"; 
  
  
        String values = Capital_chars + Small_chars + 
                        numbers + symbols; 
  
        // Using random method 
        Random random = new Random(); 
  
        String password =""; 
  
        for (int i = 0; i < 6; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            int index = random.nextInt(values.length());
        password+= values.charAt(index);
        } 
        return password; 
    }
    /*
    public Addgym getgym(String name)
    {
      try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            System.out.println("-----999");
            tx = session.beginTransaction();
           
                     Addgym l=new Addgym();
            
            Query q=session.createQuery("from Addgym where gymname:=name");
          q.setString("name",name);
            List<Addgym> results = q.list();
          System.out.println("--------");
            l = (Addgym) results.get(0);
      j=l.getId();
      }
      catch(Exception e)
      {
          System.out.println(e.getMessage());
      }
           Addgym l1=null;
           l1 = (Addgym) session.load(Addgym.class, j);
           System.out.println("[[[[[[[[");
          // Set<Branch> br1=l1.getSetbr();
           //br1.add(setbr);
           return l1;
    }
    
    public void addbranch(Set<Branch> br, Addgym l1)
    {
           try {
             sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            
            l1.setSetbr(br);
            session.save(l1);
            tx.commit();
            session.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }*/
}
