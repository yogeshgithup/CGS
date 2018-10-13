/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 *
 * @author Chandni
 */
public class SMSOperation {
     Connection c;
    public SMSOperation()
        {
       c=null; 
        }
    public SMSOperation(Connection c)
      {
        this.c=c;
      }
    public String getMobileNumber(int pid)
    {
        PreparedStatement ps=null;
        String no="";
        String sql="select contact_no from person where p_id="+pid;
        try{
            ps=c.prepareStatement(sql);
            
            
           ResultSet rs = ps.executeQuery();
           while(rs.next())
            {
              
               no= rs.getString("contact_no");
        
           }
            ps.close();
            rs.close();
    
        }
        catch(Exception e)
        {
           System.out.println(e.getMessage()); 
        }
          return no;     
    }
    public String getMobileNumberOTP(String email)
    {
        PreparedStatement ps=null;
        String no="";
        String sql="select contact_no from person where email=?";
        try{
            ps=c.prepareStatement(sql);
            ps.setString(1, email);
            
           ResultSet rs = ps.executeQuery();
          
           while(rs.next())
            {
              
               no= rs.getString("contact_no");
        
           }
            ps.close();
            rs.close();
    
        }
        catch(Exception e)
        {
           System.out.println(e.getMessage()); 
        }
          return no;     
    }
    
    
    
    
    
    
    
    public static  String sendSMS(String mob,String msg)
    {
           String msgg="";
          HttpClient client=null;
                    PostMethod post=null;
                    String sURL;
                   client = new HttpClient(new MultiThreadedHttpConnectionManager());
                   /* Set your proxy settings */
                   /*client.getHostConfiguration().setProxy("Your Proxy", ProxyPort); */
                   client.getHttpConnectionManager().getParams().setConnectionTimeout(30000);

                   sURL = "http://smslane.com/vendorsms/pushsms.aspx";
                    post = new PostMethod(sURL);
                    //give all in string
                    post.addParameter("user", "mykarsoltechnologies");
                    post.addParameter("password", "bankofbaroda");
                    post.addParameter("msisdn", mob);
                    post.addParameter("msg", msg);
                    post.addParameter("sid","WebSMS");
                    post.addParameter("fl", "0");

                    /* PUSH the URL */
                    try {
                    int statusCode = client.executeMethod(post);
                    System.out.println(post.getStatusLine().toString());
                    if (statusCode != HttpStatus.SC_OK) {
                        msgg= post.getStatusLine().toString();
                    System.err.println("Method failed: " + post.getStatusLine());
                    }
                    msgg=post.getResponseBodyAsString();
                    }
                    catch (Exception e) {
                    e.printStackTrace();
                    }
                    finally {
                    post.releaseConnection();
                    }
                    return msgg;
    }
    
}
