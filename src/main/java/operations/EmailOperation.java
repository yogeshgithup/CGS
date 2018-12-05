/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Ali's Laptop
 */
public class EmailOperation {
    
     public static void main(String[] args) {
         System.out.println(".....");
        sendEmail("ronakpatel.rp316@gmail.com","7874692568","patelshravan013@gmail.com","password","dasd");
                
    }
    
     public static String sendEmail(final String username,final String password, String to ,String subject, String data)
    {
        String msg=null;
             final String email=username;
             final String  pass=password; 
                Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.zoho.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(email,pass);
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(data);
                        
			Transport.send(message);

			msg=" ëmail sent successfully";
                        System.out.println("email send");

		} catch (Exception e) {
                    System.out.println("ERROR SEND EMAIL"+e.getMessage());
			msg="not sent";
		}
                return msg;
    }
    
   
}
