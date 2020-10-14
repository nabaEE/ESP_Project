package esp.genericLibraries;

import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

public class SendEmailClass {

	public void sendEmail() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("", ""));
		email.setSSLOnConnect(true);
		email.setFrom("");
		email.setSubject("Automation Test Mail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("");
		email.send();
	}

	public void sendHtmlEmail() throws Exception {
		// Create the email message
		HtmlEmail email = new HtmlEmail();
		email.setHostName("mail.myserver.com");
		email.addTo("jdoe@somewhere.org", "John Doe");
		email.setFrom("me@apache.org", "Me");
		email.setSubject("Test email with inline image");
		// embed the image and get the content id
		URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
		String cid = email.embed(url, "Apache logo");
		// set the html message
		email.setHtmlMsg("<html>The apache logo - <img src=\"cid:" + cid + "\"></html>");
		// set the alternative message
		email.setTextMsg("Your email client does not support HTML messages");
		// send the email
		email.send();
	}
}
