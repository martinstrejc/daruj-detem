/**
 * 
 */
package cz.darujdetem.web.service.impl;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import cz.darujdetem.web.db.entity.Donor;
import cz.darujdetem.web.service.MailSenderExcetion;
import cz.darujdetem.web.service.data.MailService;

/**
 * @author Martin Strejc
 *
 */
public class MailServiceImpl implements MailService
{
	
	private final String lang = "cs";
	
	private final String fromAddress = "daruj-detem@seznam.cz";
	
	private final String password = "...from config";
	
	private final String smtpHost = "smtp.seznam.cz";

	@Override
	public void sentAddressConfirmation(Donor donor)
	{
		
	}



	public String prepareHtmlContent(String title, String body) {
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n");
		sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
		sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"");
		sb.append(lang);
		sb.append("\" lang=\"");
		sb.append(lang);
		sb.append("\" dir=\"ltr\">");
		sb.append("<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
		sb.append("<title>");
		sb.append(title);
		sb.append("</title>\n");
		sb.append("</head>\n");
		sb.append("<body>\n");
		sb.append(body);
		sb.append("</body>\n");
		sb.append("\n</html>");
		return sb.toString();
	}

	public void sendHtml(String address, String subject,
			String body) throws MailSenderExcetion {
		send(address, subject, prepareHtmlContent(subject, body));
	}

	public void send(String address, String subject, String message)
			throws MailSenderExcetion {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", smtpHost);
			props.put("mail.smtp.auth", "false");
			Session session = Session.getDefaultInstance(props);
			session.setDebug(false);
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(fromAddress));
			InternetAddress[] addressTo = new InternetAddress[1];
			addressTo[0] = new InternetAddress(address);
			msg.setRecipients(Message.RecipientType.TO, addressTo);
//			if (blindCopy != null) {
//				InternetAddress[] addressBcc = new InternetAddress[2];
//				addressBcc[0] = new InternetAddress(blindCopy);
//				addressBcc[1] = new InternetAddress(blindCopy2);
//				msg.setRecipients(Message.RecipientType.BCC, addressBcc);
//			}
			msg.setSentDate(new Date());
			msg.setHeader("Content-Transfer-Encoding", "8bit");
			msg.setHeader("Content-Type", "text/html; charset=utf-8");
			msg.setSubject(subject, "utf-8");
			msg.setText(message, "utf-8", "html");
			Transport.send(msg);
		} catch (MessagingException msge) {
			throw new MailSenderExcetion(msge);
		}
	}

}
