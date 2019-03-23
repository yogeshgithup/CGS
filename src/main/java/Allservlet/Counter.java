/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Allservlet;

import com.mycompany.loginmodule.counter;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Chiman Patel
 */
public class Counter implements HttpSessionListener{
    
public static int totalactive=0;
 //ServletContext scx;
   counter c=new counter();
    @Override
    public void sessionCreated(HttpSessionEvent se) {
      // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        totalactive++;
        System.out.println("-----------------------ACTIVE"+totalactive);
     

      
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         
        totalactive--;
        System.out.println("After logout ACTIVE"+totalactive);
        
        
    }

    
}
