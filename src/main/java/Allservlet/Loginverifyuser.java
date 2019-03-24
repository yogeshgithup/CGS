/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Allservlet;

import com.mycompany.loginmodule.Addbranch;
import com.mycompany.loginmodule.Addgym;
import com.mycompany.loginmodule.Login;
import com.mycompany.loginmodule.Logingym;
import com.mycompany.loginmodule.Members;
import com.mycompany.loginmodule.Trainer;
import com.mycompany.loginmodule.counter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import operations.DataOperation;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author Shravan
 */
public class Loginverifyuser extends HttpServlet {

    
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
        String  name=request.getParameter("email1");
        String password=request.getParameter("password1");
        System.out.println(name);
        System.out.println(password);
        String ename=decText(name);
        String epass=decText(password);
        String savemsg=null;
        
        DataOperation so=new DataOperation(scx);
        Login l=new Login();
        
      l.setLoginid(ename);
      l.setPassword(epass);
        System.out.println("hhhhhh");
   Login l2=so.verifyusers(l);
   if(l2!=null)
   {
        System.out.println("....."+l2);
        System.out.println("lllllll");
        System.out.println(l2.getType());
        
  Addgym aa=l2.getAdgym();
int gymid=  aa.getId();
        System.out.println("---------"+gymid);
        String b="branchoperator";
        String t="traineer";
        String m="member";
       
      // int gymid=so.getgymid(branchid);
        String branchname="";
        
        int branchid=0;
        if(l2.getType().equals(b))
        {
         branchid=so.getbranchid(ename);
       branchname=so.getbranchname(branchid);
    
        System.out.println("----"+branchname);
        }
       String gymname=so.getgymname(gymid);
        System.out.println("++++"+gymname);
       HttpSession hs=request.getSession(true);
       hs.setAttribute("login",l2);
           hs.setAttribute("gymid",gymid);
           hs.setAttribute("branchid",branchid);
           hs.setAttribute("branchname", branchname);
           hs.setAttribute("gname", gymname);
         hs.setAttribute("sessss", 1);
         System.out.println("_____+++++++105"+hs.isNew());
    if(b.equals(l2.getType()))
    {
         
             Addbranch bb= so.getBranch(String.valueOf(branchid));
             System.out.println("login user-----"+bb.getBranchname());
           hs.setAttribute("branchobj",bb);
         System.out.println( "+++++"+ hs.getAttribute("sessss").toString());
        System.out.println("-----"+branchid);
        System.out.println("++++"+gymid);
          DataOperation doo=new DataOperation(scx);
           counter c=new counter();
            Date d=new Date();   
      c.setUserid(bb.getAbo().getId());
      c.setType("BRANCHOPERATOR");
      c.setDate(d);
      c.setLogintime(d);
      doo.counter(c);
      hs.setAttribute("insert1",c);
         response.sendRedirect(scx.getContextPath()+"/Viewtrainer");
    }
    else if(t.equals(l2.getType()))
    {
        
       Trainer tt=so.getTrainerobj(l2.getLoginid(),l2.getPassword());
       hs.setAttribute("trainer",tt);
        DataOperation doo=new DataOperation(scx);
           counter c=new counter();
            Date d=new Date();   
      c.setUserid(tt.getId());
      c.setType("TRAINER");
      c.setDate(d);
      c.setLogintime(d);
      doo.counter(c);
      hs.setAttribute("insert1",c);
         response.sendRedirect(scx.getContextPath()+"/Viewdiet?op=msg");
    }
       
    else if(m.equals(l2.getType()))
    {
        System.out.println("");
         Members tt=so.getmemberObj(l2.getLoginid());
       hs.setAttribute("member",tt);
        DataOperation doo=new DataOperation(scx);
           counter c=new counter();
            Date d=new Date();   
      c.setUserid(tt.getId());
      c.setType("MEMBERS");
      c.setDate(d);
      c.setLogintime(d);
      doo.counter(c);
      hs.setAttribute("insert1",c);
         response.sendRedirect(scx.getContextPath()+"/gymui/pannel/members1.jsp");
    }
    else
    {
         response.sendRedirect(scx.getContextPath()+"/gymui/pannel/userlogin.jsp");
    }
   }
   else
   {
        response.sendRedirect(scx.getContextPath()+"/gymui/pannel/userlogin.jsp?msg=wrong_password");
             
   }
// response.sendRedirect("index.jsp?msg="+savemsg);
    }
     public static final String decrypt(final String encrypted,final Key key, final IvParameterSpec iv) throws InvalidKeyException,
NoSuchAlgorithmException, NoSuchPaddingException,
IllegalBlockSizeException, BadPaddingException, IOException, InvalidAlgorithmParameterException {

      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(Cipher.DECRYPT_MODE, key,iv);
      byte[] raw = Base64.decodeBase64(encrypted);
      byte[] stringBytes = cipher.doFinal(raw);
      String clearText = new String(stringBytes, "UTF8");
      return clearText;
}

public static byte[] hexStringToByteArray(String s) {

    int len = s.length();
    byte[] data = new byte[len / 2];

    for (int i = 0; i < len; i += 2) {
        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                + Character.digit(s.charAt(i+1), 16));
    }
    return data;
}
public String decText(String ename)
{
    String name="";
    String data[] = ename.split(":");
    String iv = data[0];
    byte[] encryptedByteData = hexStringToByteArray(data[1]);
    String keyString = data[2];

    IvParameterSpec ivv = new IvParameterSpec(Base64.decodeBase64(iv));
    Key k = new SecretKeySpec(Base64.decodeBase64(keyString),"AES");
   try {
        name=decrypt(Base64.encodeBase64String(encryptedByteData),k,ivv);
       
        System.out.println("Decrypted String:"+name);
       byte bb[]=hexStringToByteArray(name);
        name=decrypt(Base64.encodeBase64String(bb),k,ivv);
        System.out.println("---933333333333"+name);
    }
    catch(Exception e)
    {
        System.out.println("----------"+e.getMessage());
    }
   return name;
}


}
