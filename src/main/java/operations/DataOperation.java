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
import com.mycompany.loginmodule.Gallery;
import com.mycompany.loginmodule.Gyminfo;
import com.mycompany.loginmodule.Login;
import com.mycompany.loginmodule.Logingym;
import com.mycompany.loginmodule.addbranchoperator;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
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
      HashSet<Addbranch> setbranch=null;
     
     int j=0;
     String n=null;
     String url;
     Logingym l2=null;
     String image_url;
   
    public DataOperation(ServletContext scx) {
        this.scx=scx;
    }
    
     public Logingym verify(Logingym l) {

        try {
            System.out.println(l.getPassword());
            System.out.println("bcjsbc sjbcds"+scx);
            System.out.println("ll"+scx.getAttribute("sf"));
            sfobj = (SessionFactory) scx.getAttribute("sf");
            System.out.println("ncncncn"+sfobj);
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
            l2 =(Logingym)results.get(0);
            System.out.println(""+l2.getUsername());
            System.out.println("passed"+l.getPassword());
            System.out.println(""+l2.getPassword());
            if(l2.getPassword().equals(l.getPassword()))
            {
                System.out.println("......");
                System.out.println("");
                l.setId(l2.getId());
                System.out.println("id after"+l2.getId());
            }
            else
            {
                System.out.println("");
                l.setId(0);
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
            System.out.println(e.getMessage());
        }
        System.out.println("///" + j);
        return l;
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
  
    
    public String addgym(Addgym ag)
    {
        try {
             sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
             Query q = session.createQuery("from Addpackage where name=:packname");
                       q.setString("packname",ag.getPackagee());
                       Addpackage p1=null;
                        List<Addpackage> results = q.list();
                        System.out.println("query");
                       
                            p1 = (Addpackage) results.get(0);
                           int id= p1.getId();
                               Addpackage l1=null;
        Set<Addgym> ab=null;
          l1 = (Addpackage) session.load(Addpackage.class,id);
                            System.out.println(l1.getName());
                           
                          ab  = new HashSet<Addgym>();
                            ab = l1.getAdgym();
                            
                           ag.setAdpack(p1);
                            ab.add(ag);
                             SMSOperation so=new SMSOperation();
     String result=so.sendSMS(ag.getPhoneno(),ag.getPassword());
        System.out.println(result); 
                            session.save(ag);
                       
                        
            
           n="Gym Added";
            tx.commit();
            session.close();
            
        } catch (Exception e) {
           
            n="failed to add gym";
            System.out.println(e.getMessage());
        }
        return n;
    }
    
    
      public String addbranchoperator(addbranchoperator abo)
    {
        try {
             sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            Query q = session.createQuery("from Addbranch where branchname=:branchname");
            System.out.println("bsvsbvsdjvsdnvsdnvsinvsidnvsdvns");
                       q.setString("branchname",abo.getBranchname());
                     
                       Addbranch b1=null;
                        List<Addbranch> results = q.list();
                     
                            b1 = (Addbranch)results.get(0);
                           int id=b1.getId(); 
                           System.out.println("cxcxcxcx"+id);
                       Addbranch b2=(Addbranch)session.load(Addbranch.class,id);
                          System.out.println("jfdlj"+b2.getBranchname());
                          b2.setAbo(abo);
                          abo.setA(b2);
//                          session.save(abo);
                          session.save(b2);
                          
                        
            
           n="branchoperator Added";
            tx.commit();
            session.close();
            
        } catch (Exception e) {
           
            n="failed to add branch";
           System.out.println(e.getMessage());
        }
        return n;
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
    
    public Login verifyusers(Login l)
    {
        try
        {
            
       sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            
            
            Query q = session.createQuery("from Login where loginid=:lname and password=:pass");
            q.setString("lname", l.getLoginid());
            q.setString("pass", l.getPassword());
            List<Login> results = q.list();

            l =(Login)results.get(0);
            System.out.println(l.getType());
            
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
        return l;  
        
    }
    
    
    public void addbranch(Addbranch br,int gymid)
    {
       try
        {
       sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            
            System.out.println(gymid);
            Addgym l1=null;
        Set<Addbranch> ab=null;
          l1 = (Addgym) session.load(Addgym.class,gymid);
                            System.out.println(l1.getGymname());
                           
                          ab  = new HashSet<Addbranch>();
                            ab = l1.getAdbarnch();
                            br.setAdgym(l1);
                            ab.add(br);
                            session.save(br);
        tx.commit();
        session.close();
        }
       catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
    }
    
    public HashSet<Addbranch> getbranch(int gymid)
    {
       
         try {
             System.out.println("before calling");
             setbranch=new HashSet<Addbranch>();
             System.out.println("line 55"+scx);
               sfobj = (SessionFactory) scx.getAttribute("sf");
               System.out.println("line 57"+sfobj);
                        session = sfobj.openSession();
                        System.out.println("line 59");
                        tx = session.beginTransaction();
                        //System.out.println("get package"); 
                        System.out.println("gymid..."+gymid);
                        Addbranch p1=null;
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
                        q.setString("gymidi",String.valueOf(gymid));
                        System.out.println("gp 59");
                        List<Addbranch> results = q.list();
                        System.out.println("query");
                        for (int i = 0; i <= results.size(); i++) {
                            p1 = (Addbranch) results.get(i);
                            Addbranch p2=new Addbranch(p1.getId(),p1.getBranchname(),p1.getStreet(),p1.getArea(),p1.getPostalcode());
                            setbranch.add(p2);
                        }
                        
                        tx.commit();
                    session.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
       
         return setbranch;
    }
    
      public HashSet<addbranchoperator> getbranchoperator(int gymid)
    {
         HashSet<addbranchoperator> setbranchop=null;
         try {
             System.out.println("before calling");
             setbranchop=new HashSet<addbranchoperator>();
             System.out.println("line 555"+scx);
               sfobj = (SessionFactory) scx.getAttribute("sf");
               System.out.println("line 577"+sfobj);
                        session = sfobj.openSession();
                        System.out.println("line 599");
                        tx = session.beginTransaction();
                        //System.out.println("get package"); 
                        System.out.println("gymid..."+gymid);
                        Addbranch p1=null;
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
                        addbranchoperator p2=null;
                        Query q = session.createQuery("from Addbranch where gymid=:gymidi");
                        q.setString("gymidi",String.valueOf(gymid));
                        System.out.println("gp 59");
                        List<Addbranch> results = q.list();
                        System.out.println("query");
                        System.out.println("hiiii"+results.size());
                        for (int i = 0; i < results.size(); i++) {
                            System.out.println("hell");
                            p1 = (Addbranch) results.get(i);
                            int i1=p1.getId();
                            System.out.println("hello"+p1.getBranchname());
                            Query q1 = session.createQuery("from addbranchoperator where id=:branchid");
                                 q1.setString("branchid",String.valueOf(i1));
                        List<addbranchoperator> result = q1.list();
                        System.out.println("query");
                            System.out.println("eeee"+result.size());
                        for (int j = 0; j < result.size(); j++) {
                            p2 = (addbranchoperator) result.get(j);
                            System.out.println("name---"+p2.getBranchname());
                            addbranchoperator p3=new addbranchoperator (p2.getId(),p2.getFirstname(),p2.getMiddlename(),p2.getLastname(),p2.getArea(),p2.getBranchname());
                            setbranchop.add(p3);
                            System.out.println("oooooop");
                        }
                            System.out.println("hjhj");
                        }
                        tx.commit();
                    session.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
       
         return setbranchop;
    }
    
    
    
    public void addachievements(Achievements ac,int gymid)
    {
         try
        {
       sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
         
                            session.save(ac);
        tx.commit();
        session.close();
        }
       catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
        
    }
    
    public void addgallery(Gallery g)
    {
         try
        {
       sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
           
                            session.save(g);
        tx.commit();
        session.close();
        }
       catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
        
    }
    
    public void addgyminfo(Addgym gym)
    {
      try
        {
       sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
          
           session.update(gym);
            System.out.println("hello");
        tx.commit();
        session.close();
        }
       catch(Exception e)
       {
           System.out.println(e.getMessage());
       }   
    }
   
    public String forgotpassword(String username)
    {
           try
        {
       sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            Logingym l=null;
            
            Query q = session.createQuery("from Logingym where username=:uname");
            q.setString("uname",username);
            
            List<Logingym> results = q.list();

            l =(Logingym)results.get(0);
            System.out.println(l.getType());
            Addgym a=l.getA();
            //System.out.println("mmmmm"+l.getType());
          
           /* if(b.equals(l.getType())) {
                j=j+1;
           //     System.out.println(",,,,"+j);
            }
            
             if (c.equals(l.getType())) {
                j=j+2;
            }*/
            SMSOperation so=new SMSOperation();
     String result=so.sendSMS(a.getPhoneno(),l.getPassword());
     n=result;
        System.out.println(result);
            

        } catch (Exception e) {
            n="failed to send message check username";
            System.out.println(e.getMessage());
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
//                        System.out.println(e.getMessage());
//                    }
//       
//         return setbranch;
//    }

   public ArrayList getURL( ArrayList<Part> image)
   {
       ArrayList<String> url=new ArrayList<>();
         try{
     Iterator it=image.iterator();
        while(it.hasNext())
        {
            Part image1=(Part)it.next();
             InputStream is=image1.getInputStream();
            System.out.println("geturl------");
        String at=scx.getInitParameter("accesstoken");
            System.out.println("accesstoken---------"+at);
        DropBoxOperation dbo=new DropBoxOperation(at);
          String filename=extractFileName(image1);
            System.out.println("filename--------"+filename);
        image_url=dbo.uploadFile(filename, is); 
            url.add(image_url);
        }
        
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
         return url;
   }
    private String extractFileName(Part part) {
        System.out.println("[[[[[[[[");
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
            System.out.println("]]]]]]]]]]]");
        }
        return "";
    }
   
    public Addgym getGymID(int gymid)
    {
        Addgym ag=null;
        try
        {
         sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            System.out.println(";;;;"+gymid);
            System.out.println(gymid);
           ag=(Addgym)session.load(Addgym.class,gymid);
           tx.commit();
         session.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return ag;
    }
    
    public String verifygymname(String gymname)
    {
        String gym=null;
         try
        {
       sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            Addgym l=null;
            
            Query q = session.createQuery("from Addgym where gymname=:uname");
            q.setString("uname",gymname);
            
            List<Addgym> results = q.list();

            l =(Addgym)results.get(0);
            if(l!=null)
            {
                gym="already exists";
            }
        }
         catch(Exception e){
             System.out.println(e.getMessage());
         }
         return gym;
    }
    
     public String verifypackagename(String packagename)
    {
        String pack =null;
         try
        {
       sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            Addpackage l=null;
            
            Query q = session.createQuery("from Addpackage where name=:uname");
            q.setString("uname",packagename);
            
            List<Addpackage> results = q.list();

            l =(Addpackage)results.get(0);
            if(l!=null)
            {
                pack="already exists";
            }
        }
         catch(Exception e){
             System.out.println(e.getMessage());
         }
         return pack;
    }
     
      public String verifyemail(String email)
    {
        String pack =null;
         try
        {
       sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            Logingym l=null;
            
            Query q = session.createQuery("from Logingym where Username=:uname");
            q.setString("uname",email);
            
            List<Logingym> results = q.list();

            l =(Logingym)results.get(0);
            System.out.println("ppp");
            if(l==null)
            {
               
                System.out.println("helll");
                pack="enter valid email";
            }
        }
         catch(Exception e){
             pack="enter valid email";
             System.out.println(e.getMessage());
         }
         return pack;
    }
      
       public String verifybranchname(String branchname,int id)
    {
        String pack =null;
         try
        {
       sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            Addbranch l=null;
            
            Query q = session.createQuery("from Addbranch where gymid=:gymid and branchname=:bname");
            q.setString("gymid",String.valueOf(id));
            q.setString("bname",branchname);
            
            List<Addbranch> results = q.list();

            l =(Addbranch)results.get(0);
            if(l!=null)
            {
                pack="already exists";
            }
        }
         catch(Exception e){
             System.out.println(e.getMessage());
         }
         return pack;
    }
         public String verifybranch(String branchname)
    {
        String pack =null;
         try
        {
       sfobj = (SessionFactory) scx.getAttribute("sf");
            session = sfobj.openSession();
            tx = session.beginTransaction();
            //String b = "branchoperator";
            //String c = "traineer";
            addbranchoperator l=null;
            
            Query q = session.createQuery("from addbranchoperator where branchname=:bname");
          
            q.setString("bname",branchname);
            
            List<addbranchoperator> results = q.list();

            l =(addbranchoperator)results.get(0);
            if(l!=null)
            {
                pack="already exists";
            }
        }
         catch(Exception e){
             System.out.println(e.getMessage());
         }
         return pack;
    }
}
