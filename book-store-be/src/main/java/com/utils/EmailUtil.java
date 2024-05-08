package com.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.model.Customer;


public class EmailUtil {
	// email: vanquanghl1@gmail.com
	// password: ckbhjiqwqctyndsw
	private static final String FROM = "vanquanghl1@gmail.com";
	private static final String PASSWORD = "ckbhjiqwqctyndsw";

	public static boolean sendEmail(String to, String title, String content) {
		// properties : declare properties
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		// create authenticator
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, PASSWORD);
			}
		};

		// session
		Session session = Session.getInstance(props, auth);

		// create message
		MimeMessage msg = new MimeMessage(session);
		

		try {
			// content type
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");

			// sender
			msg.setFrom(new InternetAddress(FROM));

			// receiver
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

			// title email
			msg.setSubject(title);

			// specify the date to send
			msg.setSentDate(new Date());

			// email for feedback
			// msg.setReplyTo(InternetAddress.parse(from, false))

			// content
			msg.setContent(content, "text/HTML; charset=UTF-8");

			// send email
			Transport.send(msg);
			return true;
		} catch (Exception e) {
			System.out.println("Gặp lỗi trong quá trình gửi email");
			e.printStackTrace();
			return false;
		}
	}

	public static String getContent(Customer customer) {
		String content = "<p>BookStore xin chào bạn <strong>" + customer.getUsername() + "</strong>.</p>\r\n"
				+ "<p>Vui lòng xác thực email của bạn bằng cách nhập mã này vào web của chúng tôi <strong>"
				+ customer.getVerificationCode() + ".</strong>"
				+ "<p>Đây là email tự động vui lòng không phản hồi email này.</p>\r\n"
				+ "<p>Trân trọng cảm ơn.</p>";
		return content;
	}
}