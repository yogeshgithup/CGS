/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author BHAVESH
 */
public class Emailutility {
    
    public static void SendEmailwithAttach(String host, String port,
            final String username, final String password, String toAddress,
            String subject, String message)throws AddressException, javax.mail.MessagingException, IOException
    {
    
        Properties p=new Properties();
        p.put("mail.smtp.host",host);
        p.put("mail.smtp.port", port);
        p.put("mail.smtp.auth","true");
        p.put("mail.smtp.starttls.enable","true");
        p.put("mail.smtp.socketFactory.port" , "465");
        p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        p.put("mail.user", username);
        p.put("mail.password",password);
    
         Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
         
         Session session=Session.getInstance(p, auth);
         
         Message msg=new MimeMessage(session);
         
         msg.setFrom(new InternetAddress(username));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        
         MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
//        if (attachedFiles != null && attachedFiles.size() > 0) {
//            for (File aFile : attachedFiles) {
//                MimeBodyPart attachPart = new MimeBodyPart();
// 
//                try {
//                    attachPart.attachFile(aFile);
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
// 
//                multipart.addBodyPart(attachPart);
//            }
//        }
 
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
 
        // sends the e-mail
        Transport.send(msg);
    
    
    }
    
   
            
    
}
