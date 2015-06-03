package domain.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

public class EmailService extends ServiceProvider {
    private static final String SMTP_HOST_NAME  = "smtp.strato.com";
    private static final String SMTP_AUTH_USER  = "autototaaldienst@dense-code.nl";
    private static final String SMTP_AUTH_PWD   = "password1";
    private static final int    SMTP_PORT_NR    = 465;
    public void sendMail(String recipient,String title,String message) throws Exception {
        ArrayList<String> recipients = new ArrayList<>();
        recipients.add(recipient);
        sendMail(recipients,title,message);
    }
    public void sendMail(List<String> recipients, String title, String message)throws Exception{
        //set mail properties
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.port", SMTP_PORT_NR);
        props.put("mail.smtp.ssl.enable", true);

        //set user credentials for authentication
        Authenticator auth = new SMTPAuthenticator();

        //create the mail session with the properties and authentication
        Session mailSession = Session.getInstance(props,auth);

        //create the transporter
        Transport transport = mailSession.getTransport();

        //write the email itself, set the sender,send-date and recipients
        MimeMessage msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress("autototaaldienst@dense-code.com", "webmaster"));
        //add all recipients(can be multiple)
        recipients.stream()
                .forEach(address -> {
                    try {msg.addRecipient(Message.RecipientType.TO, new InternetAddress(address));}
                    catch (MessagingException e) {e.printStackTrace();}
                });


        msg.setSubject(title);
        msg.setText(message);
        msg.setSentDate(Calendar.getInstance().getTime());

        //send the message
        transport.connect();
        transport.sendMessage(msg, msg.getRecipients(Message.RecipientType.TO));
        transport.close();
    }
    //the authenticator object
    private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }
}

