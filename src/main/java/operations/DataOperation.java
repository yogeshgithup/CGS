/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import com.mycompany.loginmodule.Achievements;
import com.mycompany.loginmodule.Addbranch;
import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Addpackage;
import com.mycompany.loginmodule.Batch_member;
import com.mycompany.loginmodule.Batches;
import com.mycompany.loginmodule.Dietplan;
import com.mycompany.loginmodule.Equipment;
import com.mycompany.loginmodule.Errors;
import com.mycompany.loginmodule.Facility;
import com.mycompany.loginmodule.Gallery;
import com.mycompany.loginmodule.Gyminfo;
import com.mycompany.loginmodule.Gympackage;
import com.mycompany.loginmodule.Login;
import com.mycompany.loginmodule.Logingym;
import com.mycompany.loginmodule.Members;
import com.mycompany.loginmodule.Pack_facility;
import com.mycompany.loginmodule.Trainer;
import com.mycompany.loginmodule.addbranchoperator;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.json.JSONArray;

import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.AddressException;

/**
 *
 * @author Shravan
 */
public class DataOperation {

    ServletContext scx;
    SessionFactory sfobj;
    Session session;
    Transaction tx = null;
    HashSet<Addpackage> setpack = null;
    HashSet<Addgym> setgym = null;
    HashSet<Addbranch> setbranch = null;

    int j = 0;
    String n = null;
    String url;
    Logingym l2 = null;
    String image_url;
     int gymid11;
    public DataOperation(ServletContext scx) {
        this.scx = scx;
    }
    
    public DataOperation(ServletContext scx,int gymid) {
        this.scx = scx;
        this.gymid11=gymid;
    }

    public Addgym verify(Logingym l) {
       Addgym a=null;
        try {
            System.out.println(l.getPassword());
            System.out.println("bcjsbc sjbcds" + scx);
            System.out.println("ll" + scx.getAttribute("sf"));
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("ncncncn" + sfobj);
            session = sfobj.openSession();
            System.out.println("vjsdbvjsd");
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";

            System.out.println("kmjnn");
            Query q = session.createQuery("from Logingym where username=:lname and password=:pass");
            System.out.println("kkkkkk");
            //System.out.println("...."+l.getUsername());
            q.setString("lname", l.getUsername());
            q.setString("pass", l.getPassword());
            List<Logingym> results = q.list();
            System.out.println("oooooo");
           
 
            l2 = (Logingym) results.get(0);
            System.out.println(""+l2.getType());
 
             a=l2.getA();
            System.out.println("" + l2.getUsername());
            System.out.println("passed" + l.getPassword());
            System.out.println("" + l2.getPassword());
            if (l2.getPassword().equals(l.getPassword())) {
                System.out.println("......");
                System.out.println("");
                a.setId(l2.getId());
                System.out.println("id after" + l2.getId());
            } else {
                System.out.println("");
                a.setId(0);
            }
            //System.out.println("mmmmm"+l.getType());

            /* if(b.equals(l.getType())) {
             j=j+1;
             //     System.out.println(",,,,"+j);
             }
            
             if (c.equals(l.getType())) {
             j=j+2;
             }*/
        } catch (Exception e) {
           
           
           // try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            }
        }
        System.out.println("///" + j);
        return a;
    }

    public void addpackage(Addpackage p1) {
        try {
            System.out.println("line 37");
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println(",,," + sfobj);
            session = sfobj.openSession();
            tx = session.beginTransaction();
            session.save(p1);
            tx.commit();
            session.close();
        } catch (Exception e) {
           // try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            }
        }
    }

    public HashSet<Addpackage> getpackage() {
        try {
            System.out.println("before calling");
            setpack = new HashSet<Addpackage>();
            System.out.println("line 55" + scx);
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            System.out.println("get package");
            Addpackage p1 = null;
            Query q = session.createQuery("from Addpackage");
            System.out.println("gp 59");
            List<Addpackage> results = q.list();
            System.out.println("query");
            for (int i = 0; i <= results.size(); i++) {
                p1 = (Addpackage) results.get(i);
                System.out.println("......." + p1.getName());
                Addpackage p2 = new Addpackage(p1.getId(), p1.getName(), p1.getTime(), p1.getAmount(), p1.getNo_of_branches());
                setpack.add(p2);
            }

            tx.commit();
            session.close();
        } catch (Exception e) {
            //try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            }
        }

        return setpack;
    }

    public String addgym(Addgym ag) {
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            Query q = session.createQuery("from Addpackage where name=:packname");
            q.setString("packname", ag.getPackagee());
            Addpackage p1 = null;
            List<Addpackage> results = q.list();
            System.out.println("query");
 for(int i=0;i<results.size();i++)
 {
            p1 = (Addpackage) results.get(0);
            int id = p1.getId();
            Addpackage l1 = null;
            Set<Addgym> ab = null;
            l1 = (Addpackage) session.load(Addpackage.class, id);
            System.out.println(l1.getName());

            ab = new HashSet<Addgym>();
            ab = l1.getAdgym();

            ag.setAdpack(p1);
            ab.add(ag);
            SMSOperation so = new SMSOperation();
            String result = so.sendSMS(ag.getPhoneno(), ag.getPassword());
            System.out.println(result);
 }
            session.save(ag);

            n = "Gym Added";
            tx.commit();
            session.close();

        } catch (Exception e) {

            n = "failed to add gym";
           // try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            }
        }
        return n;
    }

    public String addbranchoperator(addbranchoperator abo, Login l, Addgym gym) throws MessagingException {
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();

            Query q = session.createQuery("from Addbranch where branchname=:branchname");
            System.out.println("bsvsbvsdjvsdnvsdnvsinvsidnvsdvns");
            q.setString("branchname", abo.getBranchname());

            Addbranch b1 = null;
           
            List<Addbranch> results = q.list();
  for(int i=0;i<results.size();i++)
 {
            b1 = (Addbranch) results.get(0);
            int id = b1.getId();
            System.out.println("cxcxcxcx" + id);
            Addbranch b2 = (Addbranch) session.load(Addbranch.class, id);
            System.out.println("jfdlj" + b2.getBranchname());
            b2.setAbo(abo);

            abo.setA(b2);
            Set<Login> ab = new HashSet<Login>();
            ab = gym.getLogin();
            ab.add(l);
            l.setAdgym(gym);
 
//                          session.save(abo);
            session.save(b2);
            session.save(l);
 }          

            n = "branchoperator Added";
            tx.commit();
            session.close();
            SMSOperation so = new SMSOperation();
            String result = so.sendSMS(String.valueOf(abo.getPhoneno()), abo.getPassword());
            System.out.println(result);

        } catch (Exception e) {
          session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
                  String smtp=   scx.getInitParameter("smtp");
             String port=scx.getInitParameter("port");
             String username=scx.getInitParameter("username");
             String password=scx.getInitParameter("password");
             //Dbconnecti0n.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",);
           //  SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error mesaage", , null);
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
//             SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error mesaage","line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString()"+method ="+e.getStackTrace()[2].getMethodName() , null);
      
            session.close();
            try {
               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());
            } catch (AddressException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
         
           
        }
        return n;
    }

    public void addgymowneruser(Login l) {

        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();

            session.save(l);
            tx.commit();
            session.close();

        } catch (Exception e) {
           // try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            }
        }
    }

    public HashSet<Addgym> getgym() {
        try {
            System.out.println("before calling");
            setgym = new HashSet<Addgym>();
            System.out.println("line 55" + scx);
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            System.out.println("get package");
            Addgym p1 = null;
            Query q = session.createQuery("from Addgym");
            System.out.println("gp 59");
            List<Addgym> results = q.list();
            System.out.println("query");
            for (int i = 0; i <= results.size(); i++) {
                p1 = (Addgym) results.get(i);
                //Addgym p2 = new Addgym(p1.getId(), p1.getGymname(), p1.getOwnername(), p1.getStreet(), p1.getArea(), p1.getPostcode(), p1.getPhoneno(), p1.getUsername(), p1.getPassword(), p1.getAdpack().getName());
                setgym.add(p1);
            }

            tx.commit();
            session.close();
        } catch (Exception e) {
           // try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            }
        }

        return setgym;
    }

    public String randompassword() {
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "@";

        String values = Capital_chars + Small_chars
                + numbers + symbols;

        // Using random method 
        Random random = new Random();

        String password = "";

        for (int i = 0; i < 6; i++) {
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            int index = random.nextInt(values.length());
            password += values.charAt(index);
        }
        return password;
    }

    public Login verifyusers(Login l) {
        try {

            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";

            Query q = session.createQuery("from Login where loginid=:lname and password=:pass");
            q.setString("lname", l.getLoginid());
            q.setString("pass", l.getPassword());
            List<Login> results = q.list();
  for(int i=0;i<results.size();i++)
 {
            l = (Login) results.get(i);
            System.out.println(l.getType());
 }
            //System.out.println("mmmmm"+l.getType());
            /* if(b.equals(l.getType())) {
             j=j+1;
             //     System.out.println(",,,,"+j);
             }
            
             if (c.equals(l.getType())) {
             j=j+2;
             }*/
        } catch (Exception e) {
           // try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            }
        }
        System.out.println("///" + j);
        return l;

    }

    public void addbranch(Addbranch br, int gymid) {
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();

            System.out.println(gymid);
            Addgym l1 = null;
            Set<Addbranch> ab = null;
            l1 = (Addgym) session.load(Addgym.class, gymid);
            System.out.println(l1.getGymname());

            ab = new HashSet<Addbranch>();
            ab = l1.getAdbarnch();
            br.setAdgym(l1);
            ab.add(br);
            session.save(br);
            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
             String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());   
            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public HashSet<Addbranch> getbranch(int gymid) {

        try {
            System.out.println("before calling");
            setbranch = new HashSet<Addbranch>();
            System.out.println("line 55" + scx);
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            //System.out.println("get package"); 
            System.out.println("gymid..." + gymid);
            Addbranch p1 = null;
            /*    Addgym l1=null;
             Set<Addbranch> ab=null;
             int gymidi=0;
             l1 = (Addgym) session.load(Addgym.class,gymid);
             ab=l1.getAdbarnch();
             Iterator<Addbranch> it=ab.iterator();
             System.out.println("kkkk");
             while(it.hasNext())
             {
             Addbranch adbr=it.next();
             gymidi=adbr.getId();
             System.out.println("id===="+gymidi);
             }*/
            Query q = session.createQuery("from Addbranch where gymid=:gymidi");
            q.setString("gymidi", String.valueOf(gymid));
            System.out.println("gp 59");
            List<Addbranch> results = q.list();
            System.out.println("query");
            for (int i = 0; i < results.size(); i++) {
                p1 = (Addbranch) results.get(i);
                Addbranch p2 = new Addbranch(p1.getId(), p1.getBranchname(), p1.getStreet(), p1.getArea(), p1.getPostalcode());
                setbranch.add(p2);
            }

            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();
           
          //  Addgym g=   getGymID(gymid11);
           // g.getUsername();
          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {        
                operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return setbranch;
    }

    public HashSet<addbranchoperator> getbranchoperator(int gymid) {
        HashSet<addbranchoperator> setbranchop = null;
        try {
            System.out.println("before calling");
            setbranchop = new HashSet<addbranchoperator>();
            System.out.println("line 555" + scx);
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 577" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 599");
            tx = session.beginTransaction();
            //System.out.println("get package"); 
            System.out.println("gymid..." + gymid);
            Addbranch p1 = null;
            /*    Addgym l1=null;
             Set<Addbranch> ab=null;
             int gymidi=0;
             l1 = (Addgym) session.load(Addgym.class,gymid);
             ab=l1.getAdbarnch();
             Iterator<Addbranch> it=ab.iterator();
             System.out.println("kkkk");
             while(it.hasNext())
             {
             Addbranch adbr=it.next();
             gymidi=adbr.getId();
             System.out.println("id===="+gymidi);
             }*/
            addbranchoperator p2 = null;
            Query q = session.createQuery("from Addbranch where gymid=:gymidi");
            q.setString("gymidi", String.valueOf(gymid));
            System.out.println("gp 59");
            List<Addbranch> results = q.list();
            System.out.println("query");
            System.out.println("hiiii" + results.size());
            for (int i = 0; i < results.size(); i++) {
                System.out.println("hell");
                p1 = (Addbranch) results.get(i);
                int i1 = p1.getId();
                System.out.println("hello" + p1.getBranchname());
                Query q1 = session.createQuery("from addbranchoperator where id=:branchid");
                q1.setString("branchid", String.valueOf(i1));
                List<addbranchoperator> result = q1.list();
                System.out.println("query");
                System.out.println("eeee" + result.size());
                for (int j = 0; j < result.size(); j++) {
                    p2 = (addbranchoperator) result.get(j);
                    System.out.println("name---" + p2.getBranchname());
                    addbranchoperator p3 = new addbranchoperator(p2.getId(), p2.getFirstname(), p2.getMiddlename(), p2.getLastname(), p2.getArea(), p2.getBranchname());
                    setbranchop.add(p3);
                    System.out.println("oooooop");
                }
                System.out.println("hjhj");
            }
            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return setbranchop;
    }

    public void addachievements(Achievements ac, int gymid) {
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();

            session.save(ac);
            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void addgallery(Gallery g) {
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();

            session.save(g);
            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym gg=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,gg.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void addgyminfo(Addgym gym) {
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();

            session.update(gym);
            System.out.println("hello");
            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String forgotpassword(String username) {
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            Logingym l = null;

            Query q = session.createQuery("from Logingym where username=:uname");
            q.setString("uname", username);

            List<Logingym> results = q.list();
  for(int i=0;i<results.size();i++)
 {
            l = (Logingym) results.get(0);
            System.out.println(l.getType());
            Addgym a = l.getA();
            //System.out.println("mmmmm"+l.getType());

            /* if(b.equals(l.getType())) {
             j=j+1;
             //     System.out.println(",,,,"+j);
             }
            
             if (c.equals(l.getType())) {
             j=j+2;
             }*/
            SMSOperation so = new SMSOperation();
            String result = so.sendSMS(a.getPhoneno(), l.getPassword());
            n = result;
            System.out.println(result);
 }
        } catch (Exception e) {
            n = "failed to send message check username";
           // try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            }
        }

        return n;
    }
//    public HashSet<Addbranch> getbranch(int gymid)
//    {
//         try {
//             System.out.println("before calling");
//             setbranch=new HashSet<Addbranch>();
//             System.out.println("line 55"+scx);
//               sfobj = (SessionFactory) scx.getAttribute("sf");
//               System.out.println("line 57"+sfobj);
//                        session = sfobj.openSession();
//                        System.out.println("line 59");
//                        tx = session.beginTransaction();
//                        System.out.println("get branch"); 
//                         Addbranch b1=null;
//                        Query q = session.createQuery("from Addbranch where gymid=:id");
//                        System.out.println("gp 59");
//                        q.setString("gymid",gymid);
//                        List<Addbranch> results = q.list();
//                        System.out.println("query");
//                        for (int i = 0; i <= results.size(); i++) {
//                            b1 = (Addbranch) results.get(i);
//                            System.out.println("......."+b1.getBranchname());
//                            Addbranch b2=new Addbranch(b1.getId(),b1.getArea(),b1.getStreet(),b1.getPostalcode(),b1.getBranchname());
//                            setbranch.add(b2);
//                        }
//                        
//                        tx.commit();
//                    session.close();
//                    } catch (Exception e) {
//                        try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            }
//                    }
//       
//         return setbranch;
//    }

    public ArrayList getURL(ArrayList<Part> image) {
        ArrayList<String> url = new ArrayList<>();
        try {
            Iterator it = image.iterator();
            while (it.hasNext()) {
                Part image1 = (Part) it.next();
                InputStream is = image1.getInputStream();
                System.out.println("geturl------");
                String at = scx.getInitParameter("accesstoken");
                System.out.println("accesstoken---------" + at);
                DropBoxOperation dbo = new DropBoxOperation(at);
                String filename = extractFileName(image1);
                System.out.println("filename--------" + filename);
                image_url = dbo.uploadFile(filename, is);
                url.add(image_url);
            }

        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return url;
    }

    private String extractFileName(Part part) {
        System.out.println("[[[[[[[[");
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
            System.out.println("]]]]]]]]]]]");
        }
        return "";
    }

    public Addgym getGymID(int gymid) {
        Addgym ag = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            System.out.println(";;;;" + gymid);
            System.out.println(gymid);
            ag = (Addgym) session.load(Addgym.class, gymid);
            

        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ag;
    }
    
     public  HashSet<Gyminfo> getGymEdit(int gymid) {
        HashSet<Gyminfo> gyminfo = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            Gyminfo ag=null;
            System.out.println(";;;;;;;;;" + gymid);
            System.out.println(gymid);
            
              Query q = session.createQuery("from Gyminfo where id=:gymidi");
            q.setString("gymidi", String.valueOf(gymid));
            System.out.println("gp 59");
            List<Gyminfo> results = q.list();
            System.out.println("query");
            for (int i = 0; i < results.size(); i++) {
              ag = (Gyminfo) results.get(i);
            System.out.println(ag.getAbout_us_desc());
            gyminfo.add(ag);
                    }
           tx.commit();
           session.close();
            

        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return gyminfo;
    }
    
    
    
    

    public String verifygymname(String gymname) {
        String gym = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            Addgym l = null;

            Query q = session.createQuery("from Addgym where gymname=:uname");
            q.setString("uname", gymname);

            List<Addgym> results = q.list();
 
       if (results.size()==0) {

                System.out.println("helll");
               gym= "already exists";
            }
            else
            {
    for(int i=0;i<results.size();i++)
    {
            l = (Addgym) results.get(0);
            System.out.println("ppp");
    }
            }
 
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return gym;
    }

    public String verifypackagename(String packagename) {
        String pack = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            Addpackage l = null;

            Query q = session.createQuery("from Addpackage where name=:uname");
            q.setString("uname", packagename);

            List<Addpackage> results = q.list();
  
             if (results.size()==0) {

                System.out.println("helll");
                pack = "already exists";
            }
            else
            {
    for(int i=0;i<results.size();i++)
    {
            l = (Addpackage) results.get(0);
            System.out.println("ppp");
    }
            }
 
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pack;
    }

    public String verifyemail(String email) {
        String pack = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            Logingym l = null;
            System.out.println("-------"+email);
            Query q = session.createQuery("from Logingym where Username=:uname");
            q.setString("uname", email);

            List<Logingym> results = q.list();
            if (results.size()==0) {

                System.out.println("helll");
                pack = "enter valid email";
            }
            else
            {
    for(int i=0;i<results.size();i++)
    {
            l = (Logingym) results.get(0);
            System.out.println("ppp");
    }
            }
            

        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            pack = "enter valid email";
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pack;
    }
    
     public String verifyemailuser(String email) {
        String pack = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            Login l = null;

            Query q = session.createQuery("from Login where Loginid=:uname");
            q.setString("uname", email);

            List<Login> results = q.list();
  
           if (results.size()==0) {

                System.out.println("helll");
                pack = "enter valid email";
            }
            else
            {
    for(int i=0;i<results.size();i++)
    {
            l = (Login) results.get(0);
            System.out.println("ppp");
    }
            }
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            pack = "enter valid email";
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pack;
    }
     public String verifyuseremail(String email) {
        String pack = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            Login l = null;

            Query q = session.createQuery("from Login where Loginid=:uname");
            q.setString("uname", email);

            List<Login> results = q.list();
  for(int i=0;i<results.size();i++)
 {
            l = (Login) results.get(0);
            System.out.println("ppp");
            if (l != null) {

                System.out.println("helll");
                pack = "enter another email";
            }
 }
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            pack = "";
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pack;
    }
     

    public String verifybranchname(String branchname, int id) {
        String pack = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            Addbranch l = null;

            Query q = session.createQuery("from Addbranch where gymid=:gymid and branchname=:bname");
            q.setString("gymid", String.valueOf(id));
            q.setString("bname", branchname);

            List<Addbranch> results = q.list();
 
             if (results.size()==0) {

                System.out.println("helll");
                pack = "already exists";
            }
            else
            {
    for(int i=0;i<results.size();i++)
    {
            l = (Addbranch) results.get(0);
            System.out.println("ppp");
    }
            }
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pack;
    }

    public String verifybranch(String branchname) {
        String pack = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            addbranchoperator l = null;

            Query q = session.createQuery("from addbranchoperator where branchname=:bname");

            q.setString("bname", branchname);

            List<addbranchoperator> results = q.list();
 
             if (results.size()==0) {

                System.out.println("helll");
                pack = "already exists";
            }
            else
            {
    for(int i=0;i<results.size();i++)
    {
            l = (addbranchoperator) results.get(0);
            System.out.println("ppp");
    }
            }
 
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pack;
    }

    public void addfacility(int gymid, String[] faci) {
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            Addgym gym = (Addgym) session.load(Addgym.class, gymid);
            Set<Facility> fac = new HashSet<Facility>();
            fac = gym.getFacility();
            System.out.println("pppp" + faci.length);
            for (int i = 0; i < faci.length; i++) {

                Facility f = new Facility();
                System.out.println("jjj-" + faci[i]);
                f.setName(faci[i]);
                f.setAdgym(gym);
                fac.add(f);
            }

            gym.setFacility(fac);
            session.save(gym);
            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public HashSet<Facility> getfacility(int gymid) {
        HashSet<Facility> setfacility = null;
        try {
            System.out.println("before calling");
            setfacility = new HashSet<Facility>();
            System.out.println("line 55" + scx);
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            //System.out.println("get package"); 
            System.out.println("gymid..." + gymid);
            Facility p1 = null;

            Query q = session.createQuery("from Facility where gymid=:gymidi");
            q.setString("gymidi", String.valueOf(gymid));
            System.out.println("gp 59");
            List<Facility> results = q.list();
            System.out.println("query");
            for (int i=0; i < results.size(); i++) {
                p1 = (Facility) results.get(i);
                if(p1!=null)
                {
                Facility p2 = new Facility(p1.getId(), p1.getName());
                setfacility.add(p2);
                }
            }

            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return setfacility;
    }

    public int addgympackage(int gymid, Gympackage gp) {
        int id = 0;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();

            System.out.println(gymid);
            Addgym l1 = null;
            Set<Gympackage> ab = null;
            l1 = (Addgym) session.load(Addgym.class, gymid);
            System.out.println(l1.getGymname());

            ab = new HashSet<Gympackage>();
            ab = l1.getGympack();
            gp.setAdgym(l1);
            ab.add(gp);
            session.save(gp);
            id = gp.getId();
            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }

    public void addpackfacility(int id, String[] faci,String gymid) {
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            Gympackage gym = (Gympackage) session.load(Gympackage.class, id);
            Set<Pack_facility> fac = new HashSet<Pack_facility>();
            System.out.println("oooo-" + gym.getName());
            fac = gym.getPackfac();
            System.out.println("pppp" + faci.length);
            for (int i = 0; i < faci.length; i++) {
Set<Pack_facility> fac1 = new HashSet<Pack_facility>();
                Pack_facility f = new Pack_facility();
                System.out.println("jjj-" + faci[i]);
                System.out.println("-----"+gymid);
                Query q = session.createQuery("from Facility where name=:uname and gymid=:id");
            q.setString("uname", faci[i]);
             q.setString("id",gymid);
            List<Facility> results = q.list();
  for(int j=0;j<results.size();j++)
 {
            Facility l = (Facility) results.get(j);
            f.setFacc(l);
                l.setPack_fac(fac1);
                fac1.add(f);
               // f.setName(faci[i]);
                f.setGympack(gym);
                fac.add(f);
            }
            }
            gym.setPackfac(fac);
          
            session.save(gym);
            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public HashSet<Gympackage> getpackfacility(int gymid) {

        HashSet<Gympackage> setfacility = null;
        try {
            System.out.println("before calling");
            setfacility = new HashSet<Gympackage>();
            // HashSet<Pack_facility> packfac = new HashSet<>();
            System.out.println("line 55" + scx);
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            //System.out.println("get package"); 
            System.out.println("gymid..." + gymid);
            Gympackage p1 = null;

            Query q = session.createQuery("from Gympackage where gymid=:gymidi");
            q.setString("gymidi", String.valueOf(gymid));
            System.out.println("gp 59");
            List<Gympackage> results = q.list();
            System.out.println("query");
            System.out.println("yyyyy" + results.size());
            for (int i = 0; i < results.size(); i++) {
                p1 = (Gympackage) results.get(i);
                if(p1!=null)
                {
                System.out.println("[][][" + p1.getId());
//                   HashSet<Pack_facility> pac=new HashSet<Pack_facility>();
//                 pac = getpacfacility(p1.getId());
                //   System.out.println("---"+pac.toString());

                Gympackage p2 = new Gympackage(p1.getId(), p1.getName(), p1.getAmount(), p1.getTime());
                setfacility.add(p2);
                }
            }

            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return setfacility;
    }

    public String getpacfacility(int gymid) {
        String setfacility = "";
        try {
            System.out.println("before calling");
            // setfacility = new HashSet<Pack_facility>();
            System.out.println("line 55" + scx);
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            Query q1 = session.createQuery("from Pack_facility where packageid=:gymidi");
            q1.setString("gymidi", String.valueOf(gymid));
            List<Pack_facility> results1 = q1.list();
            Pack_facility pf = null;
            for (int j = 0; j <= results1.size(); j++) {
                pf = (Pack_facility) results1.get(j);
                setfacility = setfacility + pf.getGympack().getName() + "  ";
            }

            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
             String nameofCurrMethod = new Throwable() 
                                      .getStackTrace()[2] 
                                      .getMethodName(); 
             System.out.println("---name of method------"+nameofCurrMethod);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("oooo--" + setfacility.toString());
        return setfacility;
    }

    public int getbranchid(String branchop) {
        int id;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            addbranchoperator l = null;

            Query q = session.createQuery("from addbranchoperator where email=:uname");
            q.setString("uname", branchop);

            List<addbranchoperator> results = q.list();
  for(int i=0;i<results.size();i++)
 {
            l = (addbranchoperator) results.get(i);
 }
            id = l.getId();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            id = 0;
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }
 public String getbranchname(int id) {
        String name;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
             Addbranch l = null;

            Query q = session.createQuery("from Addbranch where id=:uname");
            q.setString("uname",String.valueOf(id));

            List<Addbranch> results = q.list();
  for(int i=0;i<results.size();i++)
 {
            l = (Addbranch) results.get(i);
 }           name=l.getBranchname();
 
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            name="";
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return name;
    }
 public String getgymname(int id) {
        String name="";
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
             Addgym l = null;

            Query q = session.createQuery("from Addgym where id=:uname");
            q.setString("uname",String.valueOf(id));

            List<Addgym> results = q.list();
              for(int i=0;i<results.size();i++)
 {
            l = (Addgym) results.get(i);
 }
            name=l.getGymname();
            System.out.println("---"+name);
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            name="";
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return name;
    }
 public Addgym getGymInfo(String id) {
        Addgym l=null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            // Addgym l = null;

            Query q = session.createQuery("from Addgym where gymname=:uname");
            q.setString("uname",id);

            List<Addgym> results = q.list();
  for(int i=0;i<results.size();i++)
 {
            l = (Addgym) results.get(i);
//            adgym.setId(l.getId());
//            adgym.setGymname(l.getGymname());
//            adgym.setOwnername(l.getOwnername());
//            adgym.setArea(l.getArea());
//            adgym.setStreet(l.getStreet());
//            adgym.setPostcode(l.getPostcode());
//            adgym.setUI(l.getUI());
//            adgym.setPhoneno(l.getPhoneno());
//            
//           Set<Addbranch> abranch=l.getAdbarnch();
           
           
 }
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
    public int getgymid(int id) {
        int gymid;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            Addbranch l = null;

            Query q = session.createQuery("from Addbranch where id=:gymid");
            q.setString("gymid", String.valueOf(id));

            List<Addbranch> results = q.list();
  for(int i=0;i<results.size();i++)
 {
            l = (Addbranch) results.get(i);
 }           Addgym g = l.getAdgym();
            gymid = g.getId();
 
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            gymid = 0;
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return gymid;
    }

    public void addtrainer(Trainer t, int branchid, Addgym adgym, Login l,String role) {
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();

            Addbranch l1 = null;
            Set<Trainer> ab = null;
            l1 = (Addbranch) session.load(Addbranch.class, branchid);
            System.out.println(l1.getBranchname());

            ab = new HashSet<Trainer>();
            ab = l1.getAddtrainer();
            t.setAdbranch(l1);
            ab.add(t);
            Set<Login> lo = new HashSet<Login>();
            lo = adgym.getLogin();
            lo.add(l);
            l.setAdgym(adgym);
             Query q = session.createQuery("from Facility where name=:uname and gymid=:id");
            q.setString("uname",role);
             q.setString("id",String.valueOf(adgym.getId()));
            List<Facility> results = q.list();
  for(int i=0;i<results.size();i++)
 {
            Facility ff = (Facility) results.get(i);
        Set<Trainer> tt= ff.getTrainer_faci();
        tt.add(t);
        t.setFacility(ff);
 }
            session.save(t);
            session.save(l);
            SMSOperation so = new SMSOperation();
            String result = so.sendSMS(String.valueOf(t.getPhoneno()), t.getPassword());
            System.out.println(result);
            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public HashSet<Trainer> gettrainer(int branchid) {

        HashSet<Trainer> setfacility = null;
        try {
            System.out.println("before calling");
            setfacility = new HashSet<Trainer>();
            // HashSet<Pack_facility> packfac = new HashSet<>();
            System.out.println("line 55" + scx);
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            //System.out.println("get package"); 
            System.out.println("gymid..." + branchid);
            Trainer p1 = null;

            Query q = session.createQuery("from Trainer where branchid=:gymidi");
            q.setString("gymidi", String.valueOf(branchid));
            System.out.println("gp 59");
            List<Trainer> results = q.list();
            System.out.println("query");
            System.out.println("yyyyy" + results.size());
            for (int i = 0; i <results.size(); i++) {
                p1 = (Trainer) results.get(i);
                if(p1!=null)
                {
                System.out.println("[][][" + p1.getId());
//                   HashSet<Pack_facility> pac=new HashSet<Pack_facility>();
//                 pac = getpacfacility(p1.getId());
                //   System.out.println("---"+pac.toString());
                Trainer t = new Trainer(p1.getFirstname(), p1.getMiddlename(), p1.getMiddlename(), p1.getEmail(), p1.getFacility().getName());
                setfacility.add(t);
                }
            }

            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return setfacility;
    }

    public void addmember(Members m, int branchid, Addgym adgym, Login l, String packagee) {
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();

            Addbranch l1 = null;
            Set<Members> ab = null;
            l1 = (Addbranch) session.load(Addbranch.class, branchid);
            System.out.println(l1.getBranchname());

            ab = new HashSet<Members>();
            ab = l1.getAddmember();
            m.setAdbranch(l1);
            ab.add(m);
            Set<Login> lo = new HashSet<Login>();
            lo = adgym.getLogin();
            lo.add(l);
            l.setAdgym(adgym);
             Query q = session.createQuery("from Gympackage where name=:uname and gymid=:id");
            q.setString("uname",packagee);
             q.setString("id",String.valueOf(adgym.getId()));
            List<Gympackage> results = q.list();
  for(int i=0;i<results.size();i++)
 {
            Gympackage ff = (Gympackage) results.get(i);
          Set<Members> mm= ff.getMembers_pack();
          mm.add(m);
          m.setGympack(ff);
 
            session.save(m);
            session.save(l);
 }
            SMSOperation so = new SMSOperation();
            String result = so.sendSMS(String.valueOf(m.getPhoneno()), m.getPassword());
            System.out.println(result);
            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void addaboutus(Gyminfo g, Addgym ag) {
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            Gyminfo l = null;
            Query q = session.createQuery("from Gyminfo where id=:gymid");
            q.setString("gymid", String.valueOf(ag.getId()));

            List<Gyminfo> results = q.list();
  for(int i=0;i<results.size();i++)
 {
            l = (Gyminfo) results.get(0);
            Addgym k = l.getA();
            l.setAbout_us_desc(g.getAbout_us_desc());
            l.setAbout_us_title(g.getAbout_us_title());
            k.setGyinfo(l);
            session.save(k);
 }
            tx.commit();
            session.close();

        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym gg=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,gg.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public HashSet<Members> getmembers(int branchid) {

        HashSet<Members> setfacility = null;
        try {
            System.out.println("before calling");
            setfacility = new HashSet<Members>();
            // HashSet<Pack_facility> packfac = new HashSet<>();
            System.out.println("line 55" + scx);
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            //System.out.println("get package"); 
            System.out.println("gymid..." + branchid);
            Members m1 = null;

            Query q = session.createQuery("from Members where branchid=:gymidi");
            q.setString("gymidi", String.valueOf(branchid));
            System.out.println("gp 59");
            List<Members> results = q.list();
            System.out.println("query");
            System.out.println("yyyyy" + results.size());
            for (int i = 0; i <results.size(); i++) {
                m1 = (Members) results.get(i);
                System.out.println("[][][" + m1.getId());
//                   HashSet<Pack_facility> pac=new HashSet<Pack_facility>();
//                 pac = getpacfacility(p1.getId());
                //   System.out.println("---"+pac.toString());
                Members m = new Members(m1.getId(), m1.getFirstname(), m1.getMiddlename(), m1.getLastname(), m1.getPhoneno(),m1.getGympack().getName(), m1.getDate());//,m1.getArea(),m1.getStreet(),m1.getPostalcode(),m1.getEmail(),m1.getPackagee(),m1.getPassword(),m1.getHeight(),m1.getWeight(),m1.getHealth(),m1.getDob());
                //Trainer t=new Trainer(p1.getFirstname(),p1.getMiddlename(),p1.getMiddlename(),p1.getEmail(),p1.getRole());
                setfacility.add(m);
            }

            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return setfacility;
    }

    public void addequipment(int gymid, String title[], String descr[], ArrayList<String> image) {
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            Addgym gym = null;
            Set<Equipment> ab = null;
            gym = (Addgym) session.load(Addgym.class, gymid);
            ab = gym.getEqui();
            for (int i = 0; i < title.length; i++) {
                Equipment e = new Equipment();
                e.setTitle(title[i]);
                System.out.println("---" + descr[i]);
                e.setDescr(descr[i]);
                e.setUrl(image.get(i));
                System.out.println("....." + e.getDescr());
                e.setAdgym(gym);
                ab.add(e);
            }
            gym.setEqui(ab);
            session.save(gym);
            tx.commit();
            session.close();

        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public HashSet<Members> invalidmember(int branchid) {
        HashSet<Members> setfacility = null;
        try {
            System.out.println("before calling");
            setfacility = new HashSet<Members>();
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            //System.out.println("get package"); 

            Members p1 = null;
            Query q = session.createQuery("from Members where branchid=:gymidi");
            q.setString("gymidi", String.valueOf(branchid));
            System.out.println("gp 59");
            List<Members> results = q.list();
            System.out.println("query");
            System.out.println("yyyyy" + results.size());
            for (int i = 0; i <= results.size(); i++) {
                p1 = (Members) results.get(i);
                String package1 = p1.getPackagee();
                System.out.println("----" + p1.getPackagee());
                Gympackage gp = null;
                Query q1 = session.createQuery("from Gympackage where name=:packagename");
                q1.setString("packagename", package1);
                System.out.println("gp 59");
                List<Gympackage> results1 = q1.list();
                for (int j = 0; j < results1.size(); j++) {
                    gp = (Gympackage) results1.get(j);
                    int time = Integer.parseInt(gp.getTime());

                    String date = p1.getDate();
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

                    LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);    //String to LocalDate
                    //Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(date);
                    //         LocalDate localDate = LocalDate.parse(date);
                    System.out.println("++" + localDate);
                    System.out.println("ppp" + time);
                    LocalDate localDatenow = LocalDate.now();
                    System.out.println("ooo" + localDate.plusMonths(time).minusDays(10));
                    if (localDate.plusMonths(time).isEqual(localDatenow) || (localDatenow.isAfter(localDate.plusMonths(time).minusDays(10)) && localDatenow.isBefore(localDate.plusMonths(time)))) {

                        Members m = new Members(p1.getId(), p1.getFirstname(), p1.getMiddlename(), p1.getLastname(), p1.getPhoneno(), p1.getGympack().getName(), localDate.plusMonths(time).toString());//,m1.getArea(),m1.getStreet(),m1.getPostalcode(),m1.getEmail(),m1.getPackagee(),m1.getPassword(),m1.getHeight(),m1.getWeight(),m1.getHealth(),m1.getDob());
                        //Trainer t=new Trainer(p1.getFirstname(),p1.getMiddlename(),p1.getMiddlename(),p1.getEmail(),p1.getRole());
                        setfacility.add(m);
//                 final long days = ChronoUnit.DAYS.between(localDatenow,localDate.plusMonths(time));
//                 String message1="your pack going to expired on-"+localDate.plusMonths(time)+"--days remainig="+days;
//                 SMSOperation so = new SMSOperation();
//                 System.out.println("---"+message1);
//            String result = so.sendSMS(String.valueOf(p1.getPhoneno()),message1);
//            System.out.println(result);
                    }
                }
            }

            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return setfacility;
    }

    public void sendmessage(String id) {
        try {
            System.out.println("before calling");
            //  setfacility = new HashSet<Members>();
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            //System.out.println("get package"); 

            Members p1 = null;
            Query q = session.createQuery("from Members where id=:gymidi");
            q.setString("gymidi", id);
            System.out.println("gp 59");
            List<Members> results = q.list();
            System.out.println("query");
            System.out.println("yyyyy" + results.size());
            for (int i = 0; i < results.size(); i++) {
                p1 = (Members) results.get(i);
                String package1 = p1.getPackagee();
                System.out.println("----" + p1.getPackagee());
                Gympackage gp = null;
                Query q1 = session.createQuery("from Gympackage where name=:packagename");
                q1.setString("packagename", package1);
                System.out.println("gp 59");
                List<Gympackage> results1 = q1.list();
                for (int j = 0; j < results1.size(); j++) {
                    gp = (Gympackage) results1.get(j);
                    int time = Integer.parseInt(gp.getTime());

                    String date = p1.getDate();
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

                    LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);    //String to LocalDate
                    //Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(date);
                    //         LocalDate localDate = LocalDate.parse(date);
                    System.out.println("++" + localDate);
                    System.out.println("ppp" + time);
                    LocalDate localDatenow = LocalDate.now();
                    System.out.println("ooo" + localDate.plusMonths(time).minusDays(10));
                    if (localDate.plusMonths(time).isEqual(localDatenow) || (localDatenow.isAfter(localDate.plusMonths(time).minusDays(10)) && localDatenow.isBefore(localDate.plusMonths(time)))) {

                   //  Members m = new Members(p1.getId(), p1.getFirstname(), p1.getMiddlename(), p1.getLastname(), p1.getPhoneno(),p1.getPackagee(),localDate.plusMonths(time).toString());//,m1.getArea(),m1.getStreet(),m1.getPostalcode(),m1.getEmail(),m1.getPackagee(),m1.getPassword(),m1.getHeight(),m1.getWeight(),m1.getHealth(),m1.getDob());
                        //Trainer t=new Trainer(p1.getFirstname(),p1.getMiddlename(),p1.getMiddlename(),p1.getEmail(),p1.getRole());
                        //     setfacility.add(m);
                        final long days = ChronoUnit.DAYS.between(localDatenow, localDate.plusMonths(time));
                        String message1 = "your pack going to expired on-" + localDate.plusMonths(time) + "--days remainig=" + days;
                        SMSOperation so = new SMSOperation();
                        System.out.println("---" + message1);
                        String result = so.sendSMS(String.valueOf(p1.getPhoneno()), message1);
                        System.out.println(result);
                    }
                }
            }

            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     public void sendmessage_all(String id) {
        try {
            System.out.println("before calling");
            //  setfacility = new HashSet<Members>();
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            //System.out.println("get package"); 

            Members p1 = null;
            Query q = session.createQuery("from Members where branchid=:gymidi");
            q.setString("gymidi", id);
            System.out.println("gp 59");
            List<Members> results = q.list();
            System.out.println("query");
            System.out.println("yyyyy" + results.size());
            for (int i = 0; i <= results.size(); i++) {
                p1 = (Members) results.get(i);
                String package1 = p1.getPackagee();
                System.out.println("----" + p1.getPackagee());
                Gympackage gp = null;
                Query q1 = session.createQuery("from Gympackage where name=:packagename");
                q1.setString("packagename", package1);
                System.out.println("gp 59");
                List<Gympackage> results1 = q1.list();
                for (int j = 0; j < results1.size(); j++) {
                    gp = (Gympackage) results1.get(j);
                    int time = Integer.parseInt(gp.getTime());

                    String date = p1.getDate();
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

                    LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);    //String to LocalDate
                    //Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(date);
                    //         LocalDate localDate = LocalDate.parse(date);
                    System.out.println("++" + localDate);
                    System.out.println("ppp" + time);
                    LocalDate localDatenow = LocalDate.now();
                    System.out.println("ooo" + localDate.plusMonths(time).minusDays(10));
                    if (localDate.plusMonths(time).isEqual(localDatenow) || (localDatenow.isAfter(localDate.plusMonths(time).minusDays(10)) && localDatenow.isBefore(localDate.plusMonths(time)))) {

                   //  Members m = new Members(p1.getId(), p1.getFirstname(), p1.getMiddlename(), p1.getLastname(), p1.getPhoneno(),p1.getPackagee(),localDate.plusMonths(time).toString());//,m1.getArea(),m1.getStreet(),m1.getPostalcode(),m1.getEmail(),m1.getPackagee(),m1.getPassword(),m1.getHeight(),m1.getWeight(),m1.getHealth(),m1.getDob());
                        //Trainer t=new Trainer(p1.getFirstname(),p1.getMiddlename(),p1.getMiddlename(),p1.getEmail(),p1.getRole());
                        //     setfacility.add(m);
                        final long days = ChronoUnit.DAYS.between(localDatenow, localDate.plusMonths(time));
                        String message1 = "your pack going to expired on-" + localDate.plusMonths(time) + "--days remainig=" + days;
                        SMSOperation so = new SMSOperation();
                        System.out.println("---" + message1);
                        String result = so.sendSMS(String.valueOf(p1.getPhoneno()), message1);
                        System.out.println(result);
                    }
                }
            }

            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
     public int addBatch(Batches b,int branchid,String role,String gymid)
     {
        int id = 0;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();

            System.out.println(branchid);
            Addbranch l1 = null;
            Set<Batches> ab = null;
            l1 = (Addbranch) session.load(Addbranch.class, branchid);
            System.out.println(l1.getBranchname());

            ab = new HashSet<Batches>();
            ab = l1.getBatches();
            b.setAdbranch(l1);
            ab.add(b);
            System.out.println("----"+role);
             Query q = session.createQuery("from Facility where id=:gymid and gymid=:id");
            q.setString("gymid",role);
 q.setString("id",gymid);
            List<Facility> results = q.list();
          for(int i=0;i<results.size();i++)
 {   
           Facility l = (Facility) results.get(i);
       Set<Batches> f=l.getFaci_batches();
       f.add(b);
       b.setFacility_batches(l);
            session.save(b);
 }
            id = b.getId();
            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }
     
      public Members getmemberid(String id) {
       // int gymid;
        Members l = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            

            Query q = session.createQuery("from Members where id=:gymid");
            q.setString("gymid", id);

            List<Members> results = q.list();
  for(int i=0;i<results.size();i++)
 {
            l = (Members) results.get(i);
 }
            
           
        } catch (Exception e) {
           // gymid = 0;
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
       public void addBatch_member(int id, String[] member) {
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            Batches b = (Batches) session.load(Batches.class,id);
         
            Set<Batch_member> fac = new HashSet<Batch_member>();
            System.out.println("oooo-" + b.getBatch_name());
            fac = b.getBatche_member();
            System.out.println("pppp" + member.length);
            for (int i = 0; i < member.length; i++) {
                Set<Batch_member> fa = new HashSet<Batch_member>();
                Batch_member f = new Batch_member();
                System.out.println("jjj-" + member[i]);
                
               Query q = session.createQuery("from Members where firstname=:gymid");
            q.setString("gymid",member[i]);

            List<Members> results = q.list();
    for(int j=0;j<results.size();j++)
 {         
           Members l = (Members) results.get(j);
             f.setBatch_mem(b);
        //   f.setName(l.get);
             f.setMemb(l); 
              l.setBatches(fa);
              fa.add(f);
                fac.add(f);
 }
            }

            b.setBatche_member(fac);
            session.save(b);
            
            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        public Addbranch getBranch(String id) {
       // int gymid;
        Addbranch l = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            

            Query q = session.createQuery("from Addbranch where id=:gymid");
            q.setString("gymid", id);

            List<Addbranch> results = q.list();
  for(int i=0;i<results.size();i++)
 {
            l = (Addbranch) results.get(i);
 }

        } catch (Exception e) {
           // gymid = 0;
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
         public Trainer getTrainerid(String id) {
       int tid=0;
        Trainer l = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            

            Query q = session.createQuery("from Trainer where email=:gymid");
            q.setString("gymid", id);

            List<Trainer> results = q.list();
  for(int i=0;i<results.size();i++)
 {
            l = (Trainer) results.get(i);
 }
            
          // tid= l.getId();
           
        } catch (Exception e) {
           // gymid = 0;
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
               Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        return l;
    }
         
         public JSONArray getMembersname(String id)
         {
              
              JSONArray  ja=new JSONArray();
        Batch_member l = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            

            Query q = session.createQuery("from Batch_member where batch_id=:gymid");
            q.setString("gymid", id);

            List<Batch_member> results = q.list();
for(int i=0;i<results.size();i++)
{
            l = (Batch_member) results.get(i);
           ja.put( l.getMemb().getFirstname());
}
          // tid= l.getId();
           
        } catch (Exception e) {
           // gymid = 0;
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                      Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
                  }
        }
       return ja;
       }
         public JSONArray getMembersFacility(String id)
         {
              
              JSONArray  ja=new JSONArray();
        Facility l = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            

            Query q = session.createQuery("from Facility where id=:gymid");
            q.setString("gymid", id);

            List<Facility> results = q.list();
  for(int i=0;i<results.size();i++)
 {
            l = (Facility) results.get(i);
            
          Set<Pack_facility> pf= l.getPack_fac();
         Iterator it= pf.iterator();
         while(it.hasNext())
         {
           Pack_facility pff=(Pack_facility)  it.next();
         Set<Members> mm=  pff.getGympack().getMembers_pack();
       Iterator itt=  mm.iterator();
       while(itt.hasNext())
       {
           Members m=(Members)itt.next();
           //String name=m.getFirstname()+" "+m.getMiddlename()+" "+m.getLastname();
           ja.put(m.getFirstname());
       }
         }
 }
          // tid= l.getId();
           
        } catch (Exception e) {
           // gymid = 0;
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                      Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
                  }
        }
       return ja;
       }
         public void Adddietplan(Dietplan dp,String batchid ,String member_name,String branchid) {
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            Batches b = (Batches) session.load(Batches.class,Integer.parseInt(batchid));
            System.out.println("1754");
            Set<Dietplan> db = new HashSet<Dietplan>();
            Dietplan  db1 = new Dietplan();
               Query q = session.createQuery("from Members where firstname=:gymid and branchid=:bid");
            q.setString("gymid",member_name);
 q.setString("bid",branchid);
            List<Members> results = q.list();
    for(int i=0;i<results.size();i++)
 {         
           Members l = (Members) results.get(i);
            System.out.println("===="+l.getFirstname());
           //db= b.getDiet();
            //System.out.println("oooo-" + b.getBatch_name());
           db= b.getDiet();
            db.add(dp);
               dp.setBatchhh(b);
        l.setDp(dp);
        dp.setA(l);
        db.add(dp);
       // dp.setFact(b);
            System.out.println("----"+dp.getDescription());
           session.save(dp);
 }
            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
         public Members getmemberObj(String id) {
       // int gymid;
        Members l = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            

            Query q = session.createQuery("from Members where email=:gymid");
            q.setString("gymid", id);

            List<Members> results = q.list();
for(int i=0;i<results.size();i++)
 {
            l = (Members) results.get(i);
 } 
            
           
        } catch (Exception e) {
           // gymid = 0;
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
          public String Countbranch(Addgym gym) {
       // int gymid;
        String msg="";
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
          int no=gym.getAdpack().getNo_of_branches();
int row=0;
           String SQL_QUERY = "SELECT COUNT(*) FROM Addbranch where gymid=:id";
            System.out.println(SQL_QUERY);
  Query q = session.createQuery(SQL_QUERY);
    q.setParameter("id",String.valueOf(gym.getId()));
  for(Iterator it=q.iterate();it.hasNext();)
  {
   Long h = (Long) it.next();
  row= h.intValue();
   System.out.print("Count: " + row);
   
  }
         if(row<no) {
            msg="yes"; 
         }  
         else
         {
             msg="no";
         }
   tx.commit();
   session.close();
           
        } catch (Exception e) {
           // gymid = 0;
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return msg;
    }
          public void Deletegym(int gymid) {
        try {
            System.out.println("before calling");
            setgym = new HashSet<Addgym>();
            System.out.println("line 55" + scx);
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            System.out.println("get package");
          
             Addgym l1 = null;
           
            l1 = (Addgym) session.load(Addgym.class, gymid);
            System.out.println("---"+l1.getGymname());
           session.delete(l1);
            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
    }
            public void Deletepack(int gymid) {
        try {
            System.out.println("before calling");
            setgym = new HashSet<Addgym>();
            System.out.println("line 55" + scx);
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            System.out.println("get package");
          
             Addpackage l1 = null;
           
            l1 = (Addpackage) session.load(Addpackage.class, gymid);
            System.out.println("---"+l1.getName());
           session.delete(l1);
            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
    }
             public void UpdatePackage(Addpackage p1) {
        try {
            System.out.println("before calling");
            setgym = new HashSet<Addgym>();
            System.out.println("line 55" + scx);
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            System.out.println("get package");
          
             Addpackage l1 = null;
           
            l1 = (Addpackage) session.load(Addpackage.class,p1.getId());
            l1.setName(p1.getName());
            l1.setNo_of_branches(p1.getNo_of_branches());
            l1.setAmount(p1.getAmount());
            l1.setTime(p1.getTime());
            System.out.println("===="+l1.getName());
           session.update(l1);
            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
    }
             
              public Gyminfo  getMain(int id) {
       // int gymid;
        Gyminfo l = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            

            Query q = session.createQuery("from Gyminfo where id=:gymid");
            q.setString("gymid", String.valueOf(id));

            List<Gyminfo> results = q.list();
 for(int i=0;i<results.size();i++)
 {
            l = (Gyminfo) results.get(i);
 }          
            
           
        } catch (Exception e) {
           // gymid = 0;
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
               public Dietplan  getdiet(int id) {
       // int gymid;
        Dietplan l = null;
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            

            Query q = session.createQuery("from Dietplan where id=:gymid");
            q.setString("gymid", String.valueOf(id));

            List<Dietplan> results = q.list();
for(int i=0;i<results.size();i++)
 {
            l = (Dietplan) results.get(i);
 } 
            
           
        } catch (Exception e) {
           // gymid = 0;
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
                public int getmemberid1(String id) {
       // int gymid;
        int id1=0;
        
        try {
            sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
        Members l=null;    

            Query q = session.createQuery("from Members where firstname=:gymid");
            q.setString("gymid", id);

            List<Members> results = q.list();
   for(int i=0;i<results.size();i++)
 {
            l = (Members) results.get(i);
 }   
            id1=l.getId();
           
        } catch (Exception e) {
           // gymid = 0;
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id1;
    }
public HashSet<Addgym> invalidGym() {
        HashSet<Addgym> setgym = null;
        try {
            System.out.println("before calling");
            setgym = new HashSet<Addgym>();
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            //System.out.println("get package"); 

            Addgym p1 = null;
            Query q = session.createQuery("from Addgym");
            
            System.out.println("gp 59");
            List<Addgym> results = q.list();
            System.out.println("query");
            System.out.println("yyyyy" + results.size());
            for (int i = 0; i < results.size(); i++) {
                p1 = (Addgym) results.get(i);
              Addpackage pp=  p1.getAdpack();
           // String month= pp.getTime();
              
                    int time = Integer.parseInt(pp.getTime());

                    String date = p1.getDate();
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

                    LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);    //String to LocalDate
                    //Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(date);
                    //         LocalDate localDate = LocalDate.parse(date);
                    System.out.println("++" + localDate);
                    System.out.println("ppp" + time);
                    LocalDate localDatenow = LocalDate.now();
                    System.out.println("ooo" + localDate.plusMonths(time).minusDays(10));
                    if (localDate.plusMonths(time).isEqual(localDatenow) || (localDatenow.isAfter(localDate.plusMonths(time).minusDays(10)) && localDatenow.isBefore(localDate.plusMonths(time)))) {

                        setgym.add(p1);
//                 
                    }
                }
            

            tx.commit();
            session.close();
        }
         catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return setgym;
    }
 public void sendmessagegym(String id) {
        try {
          System.out.println("before calling");
            setgym = new HashSet<Addgym>();
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            //System.out.println("get package"); 

            Addgym p1 = null;
            Query q = session.createQuery("from Addgym where id=:gymid");
           q.setString("gymid", id);
            System.out.println("gp 59");
            List<Addgym> results = q.list();
            System.out.println("query");
            System.out.println("yyyyy" + results.size());
            for (int i = 0; i < results.size(); i++) {
                p1 = (Addgym) results.get(i);
              Addpackage pp=  p1.getAdpack();
           // String month= pp.getTime();
              
                    int time = Integer.parseInt(pp.getTime());

                    String date = p1.getDate();
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

                    LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);    //String to LocalDate
                    //Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(date);
                    //         LocalDate localDate = LocalDate.parse(date);
                    System.out.println("++" + localDate);
                    System.out.println("ppp" + time);
                    LocalDate localDatenow = LocalDate.now();
                    System.out.println("ooo" + localDate.plusMonths(time).minusDays(10));
                    if (localDate.plusMonths(time).isEqual(localDatenow) || (localDatenow.isAfter(localDate.plusMonths(time).minusDays(10)) && localDatenow.isBefore(localDate.plusMonths(time)))) {

                   //  Members m = new Members(p1.getId(), p1.getFirstname(), p1.getMiddlename(), p1.getLastname(), p1.getPhoneno(),p1.getPackagee(),localDate.plusMonths(time).toString());//,m1.getArea(),m1.getStreet(),m1.getPostalcode(),m1.getEmail(),m1.getPackagee(),m1.getPassword(),m1.getHeight(),m1.getWeight(),m1.getHealth(),m1.getDob());
                        //Trainer t=new Trainer(p1.getFirstname(),p1.getMiddlename(),p1.getMiddlename(),p1.getEmail(),p1.getRole());
                        //     setfacility.add(m);
                        final long days = ChronoUnit.DAYS.between(localDatenow, localDate.plusMonths(time));
                        String message1 = "your pack going to expired on-" + localDate.plusMonths(time) + "--days remainig=" + days;
                        SMSOperation so = new SMSOperation();
                        System.out.println("---" + message1);
                        String result = so.sendSMS(String.valueOf(p1.getPhoneno()), message1);
                        System.out.println(result);
                    }
                }
           

            tx.commit();
            session.close();
        }
         catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     public void sendmessage_allgym() {
        try {
          System.out.println("before calling");
            setgym = new HashSet<Addgym>();
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("line 57" + sfobj);
            session = sfobj.openSession();
            System.out.println("line 59");
            tx = session.beginTransaction();
            //System.out.println("get package"); 

            Addgym p1 = null;
            Query q = session.createQuery("from Addgym ");
          // q.setString("gymid", id);
            System.out.println("gp 59");
            List<Addgym> results = q.list();
            System.out.println("query");
            System.out.println("yyyyy" + results.size());
            for (int i = 0; i < results.size(); i++) {
                p1 = (Addgym) results.get(i);
              Addpackage pp=  p1.getAdpack();
           // String month= pp.getTime();
              
                    int time = Integer.parseInt(pp.getTime());

                    String date = p1.getDate();
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

                    LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);    //String to LocalDate
                    //Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(date);
                    //         LocalDate localDate = LocalDate.parse(date);
                    System.out.println("++" + localDate);
                    System.out.println("ppp" + time);
                    LocalDate localDatenow = LocalDate.now();
                    System.out.println("ooo" + localDate.plusMonths(time).minusDays(10));
                    if (localDate.plusMonths(time).isEqual(localDatenow) || (localDatenow.isAfter(localDate.plusMonths(time).minusDays(10)) && localDatenow.isBefore(localDate.plusMonths(time)))) {
                   //  Members m = new Members(p1.getId(), p1.getFirstname(), p1.getMiddlename(), p1.getLastname(), p1.getPhoneno(),p1.getPackagee(),localDate.plusMonths(time).toString());//,m1.getArea(),m1.getStreet(),m1.getPostalcode(),m1.getEmail(),m1.getPackagee(),m1.getPassword(),m1.getHeight(),m1.getWeight(),m1.getHealth(),m1.getDob());
                        //Trainer t=new Trainer(p1.getFirstname(),p1.getMiddlename(),p1.getMiddlename(),p1.getEmail(),p1.getRole());
                        //     setfacility.add(m);
                        final long days = ChronoUnit.DAYS.between(localDatenow, localDate.plusMonths(time));
                        String message1 = "your pack going to expired on-" + localDate.plusMonths(time) + "--days remainig=" + days;
                        SMSOperation so = new SMSOperation();
                        System.out.println("---" + message1);
                        String result = so.sendSMS(String.valueOf(p1.getPhoneno()), message1);
                        System.out.println(result);
                    }
                }
            

            tx.commit();
            session.close();
        } catch (Exception e) {
             session = sfobj.openSession();
            tx = session.beginTransaction();

          System.out.println("line no= "+e.getStackTrace()[2].getLineNumber());
              String smtp=   scx.getInitParameter("smtp");             String port=scx.getInitParameter("port");             String username=scx.getInitParameter("username");             String password=scx.getInitParameter("password");
           Addgym g=   getGymID(gymid11);
            // System.out.println(ea.getStackTrace().toString());
            System.out.println("class name= "+e.getStackTrace()[2].getFileName());
            Errors ee=new Errors();
            ee.setGymid(gymid11);
            ee.setError_name("line no= "+e.getStackTrace()[2].getLineNumber()+"type= "+e.toString());
            ee.setMethod_name(e.getStackTrace()[2].getMethodName());
            session.save(ee);
             tx.commit();
            session.close();
            try {               operations.Emailutility.SendEmailwithAttach(smtp, port, username, password,g.getUsername(),"error message",ee.getError_name()+""+e.getStackTrace()[2].getLineNumber());            } catch (AddressException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (IOException ex) {                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);            } catch (MessagingException ex) {
                Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}


