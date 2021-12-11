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

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;
import javax.activation.*;

public class MailSend
{

public static void main(String [] args)
{
	// email ID of Recipient.
	String recipient = "aheryash2004@gmail.com";

	// email ID of Sender.
	String sender = "nerdofprogramming@gmail.com";

	// using host as localhost
	String host = "127.0.1.1";

	// Getting system properties
	Properties properties = System.getProperties();

	// Setting up mail server
	properties.setProperty("mail.smtp.host", host);

	// creating session object to get properties
	Session session = Session.getDefaultInstance(properties);

	try
	{
		// MimeMessage object.
		MimeMessage message = new MimeMessage(session);

		// Set From Field: adding senders email to from field.
		message.setFrom(new InternetAddress(sender));

		// Set To Field: adding recipient's email to from field.
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

		// Set Subject: subject of the email
		message.setSubject("This is Subject");

		// set body of the email.
		message.setText("This is a test mail");

		// Send email.
		Transport.send(message);
		System.out.println("Mail successfully sent");
	}
	catch (MessagingException mex)
	{
		mex.printStackTrace();
	}
}
}

