package util;

import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailService {

	private static String emailSender;

	public static void setEmailSender(String emailSender) {
		EmailService.emailSender = emailSender;
	}

	public static String getEmailSender() {
		return emailSender;
	}

	private Properties props = System.getProperties();

	public Properties getProps() {
		return setProps(this.props);

	}

	private Properties setProps(Properties props) {
		String host = "localhost";
		String smtp = "mail.smtp.host";
		String ip = "192.168.1.82";
		setEmailSender("no_rply@sushant.com");
		props.put(smtp, ip);
		return props;

	}

	public boolean dispathEmail(String subject, String body, String recepients, String file, String filename) {
		boolean status = false;
		try {
			Session session = Session.getInstance(getProps(), null);
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(InternetAddress.parse(getEmailSender(), false)[0]);
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepients, false));
			msg.setSubject(subject);

			Multipart multipart = new MimeMultipart();
			BodyPart message = new MimeBodyPart();
			message.setText(body);
			multipart.addBodyPart(message);

			DataSource source = new FileDataSource(file);

			message.setDataHandler(new DataHandler(source));
			message.setFileName(filename);
			multipart.addBodyPart(message);

			msg.setContent(multipart);
			msg.setSentDate(new Date());

			Transport.send(msg);

			status = true;
		} catch (Exception e) {
			System.out.println(e);

		}

		return status;
	}

	public static void main(String[] args) {

		EmailService es = new EmailService();

		es.dispathEmail("Hi", "testing ", "sushant.shambharkar@gmail.com", " ", " ");

	}

}
