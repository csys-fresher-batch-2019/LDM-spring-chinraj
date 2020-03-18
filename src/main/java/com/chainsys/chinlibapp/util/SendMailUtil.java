package com.chainsys.chinlibapp.util;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMailUtil {

	public static void send(final String from, final String password, String to, String sub, String a)
			throws Exception {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.ssl.checkserveridentity", true);
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("Greetings, From ChinLib");

			BodyPart messageBodyPart2 = new MimeBodyPart();
			messageBodyPart2.setText("\nDear,hii \n \t\t ");
			BodyPart messageBodyPart3 = new MimeBodyPart();
			messageBodyPart3.setText(a);
			BodyPart messageBodyPart4 = new MimeBodyPart();
			messageBodyPart4.setText("\n\t\tThank you");
			BodyPart messageBodyPart5 = new MimeBodyPart();
			messageBodyPart5.setText("\n\t Team ChinLib...");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);
			multipart.addBodyPart(messageBodyPart3);
			multipart.addBodyPart(messageBodyPart4);
			multipart.addBodyPart(messageBodyPart5);

			message.setContent(multipart);
			Transport.send(message);
			System.out.println("message sent successfully");
		}

		catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
