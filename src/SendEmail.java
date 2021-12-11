/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ims;

/**
 *
 * @author swarup
 */
// Java program to send email
 import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.io.*;

public class SendEmail
{
  private static final String SMTP_HOST_NAME = "smtp.gmail.com"; //or simply "localhost"
  private static final String SMTP_AUTH_USER = "nerdofprogramming@gmail.com";
  private static final String SMTP_AUTH_PWD  = "Java@123";
  private static final String emailMsgTxt      = "Yedya";
  private static final String emailSubjectTxt  = "Yash Bhaiina Namaskar";
  private static final String emailFromAddress = "nerdofprogramming@gmail.com";

  // Add List of Email address to who email needs to be sent to
  private static final String[] emailList = {"aheryash1175@gmail.com"};

  public static void main(String args[]) throws Exception
  {
    SendEmail smtpMailSender = new SendEmail();
    smtpMailSender.postMail( emailList, emailSubjectTxt, emailMsgTxt, emailFromAddress);
    System.out.println("Sucessfully Sent mail to All Users");
  }

  public void postMail( String recipients[ ], String subject,
    String message , String from) throws MessagingException, AuthenticationFailedException
  {
    boolean debug = false;

    //Set the host smtp address
    Properties props = new Properties();
    props.put("smtp.gmail.com", SMTP_HOST_NAME);
    props.put("smtp.gmail.com", "true");
    Authenticator auth = new SMTPAuthenticator();
    Session session = Session.getDefaultInstance(props, auth);

    session.setDebug(debug);

    // create a message
    Message msg = new MimeMessage(session);

    // set the from and to address
    InternetAddress addressFrom = new InternetAddress(from);
    msg.setFrom(addressFrom);

    InternetAddress[] addressTo = new InternetAddress[recipients.length];
    for (int i = 0; i < recipients.length; i++)
    {
        addressTo[i] = new InternetAddress(recipients[i]);
    }
    msg.setRecipients(Message.RecipientType.TO, addressTo);

    // Setting the Subject and Content Type
    msg.setSubject(subject);
    msg.setContent(message, "text/plain");
    Transport.send(msg);
 }

private class SMTPAuthenticator extends javax.mail.Authenticator
{
    public PasswordAuthentication getPasswordAuthentication()
    {
        String username = SMTP_AUTH_USER;
        String password = SMTP_AUTH_PWD;
        return new PasswordAuthentication(username, password);
    }
}
}