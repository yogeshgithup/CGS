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
import com.mycompany.loginmodule.counter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashSet;
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
        String  ename=request.getParameter("email1");
        String epassword=request.getParameter("password1");
        System.out.println(ename);
        System.out.println(epassword);
        String savemsg=null;
        System.out.println("kbjcsjhkdbvcksd"+scx.getAttribute("sf"));
        DataOperation soo=new DataOperation(scx);
        Logingym l=new Logingym();
   
       String name= decText(ename);
String password=decText(epassword);

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
          System.out.println("85----"+hs.isNew());
           hs.setAttribute("gymid",l2.getId());
           hs.setAttribute("gymname",l2.getGymname());
           hs.setAttribute("gym",l2);
           System.out.println("gymid==="+l2.getId());
         /*  DataOperation pko=new DataOperation(scx);
           HashSet<Addbranch> listCatagory =pko.getbranch(l2.getId());
            hs.setAttribute("setbranch",listCatagory);*/
           DataOperation doo=new DataOperation(scx);
           counter c=new counter();
            Date d=new Date();   
      c.setUserid(l2.getId());
      c.setType("GYMADMIN");
      c.setDate(d);
      c.setLogintime(d);
      doo.counter(c);
      hs.setAttribute("insert",c);
         response.sendRedirect("Viewbranch");
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
        