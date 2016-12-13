/**
 * 
 */
package cz.darujdetem.web.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.darujdetem.web.db.entity.Donor;
import cz.darujdetem.web.db.entity.Gift;
import cz.darujdetem.web.db.entity.Person;
import cz.darujdetem.web.service.MailSenderExcetion;
import cz.darujdetem.web.service.data.MailService;

/**
 * @author Martin Strejc
 *
 */
public class MailServiceImpl implements MailService
{
	
	public static final String LANG = "cs";
	
	private static final Logger log = LoggerFactory.getLogger(MailServiceImpl.class);
	
	private final MailConfigBean config;
	
	public MailServiceImpl(MailConfigBean config)
	{
		this.config = config;
	}

	@Override
	public void sendGiftConfirmation(Donor donor, String activationLink)
	{
		Person person = donor.getPerson();
		Gift gift = person.getGift();
		
		try
		{
			StringBuilder sb = new StringBuilder();
			sb.append("<h1>Dobrý den,<br/></h1>");
			sb.append("<p>Děkujeme Vám za Váš zájem o děti z dětských domovů!<br/></p>");
			sb.append("<p>Pro potvrzení Vašeho zájmu o dárek č. ");
			sb.append(gift.getId());
			sb.append(", ");
			sb.append(gift.getName());
			sb.append(" pro ");
			sb.append(person.getName());
			sb.append(" z ");
			sb.append(person.getInstitute().getName());
			sb.append(" klikněte na následující odkaz: ");
			sb.append("<a href=\"");
			sb.append(activationLink);
			sb.append("\">");
			sb.append(activationLink);
			sb.append("</a>.<br/></p>");
			sb.append("<p>Pokud nelze odkaz otevřít z emailu, zkopírujte jej do schránky a otevřete ve webovém prohlížeči.<br/></p>");
			sb.append("<p>S pozdravem Jiří Vojáček</p>");
			sendHtml(donor.getEmail(), "Zadost o potvrzeni darku c. " + gift.getId() + " (daruj-detem.cz)", sb.toString());
		}
		catch (MailSenderExcetion e)
		{
			log.error("Cannot send a mail to " + donor.getEmail() , e);
		}
	}

	public String prepareHtmlContent(String title, String body) {
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n");
		sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
		sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"");
		sb.append(LANG);
		sb.append("\" lang=\"");
		sb.append(LANG);
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
			log.debug("Sending message to {}", address);
			Properties props = new Properties();

			props.put("mail.transport.protocol", "smtps");

		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.socketFactory.port", config.getSmtpPort());
		    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		    props.put("mail.smtp.timeout", "10000");

		    props.put("mail.smtp.ssl.checkserveridentity", "false");
		    props.put("mail.smtp.ssl.trust", "*");
		    props.put("mail.smtp.connectiontimeout", "10000");

		    props.put("mail.smtp.debug", "true");
		    props.put("mail.smtp.socketFactory.fallback", "false");
			
			props.put("mail.smtp.host", config.getSmtpHost());
		    props.put("mail.smtp.port", config.getSmtpPort());
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.user", config.getSmtpUser());
			Authenticator auth = new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(config.getSmtpUser(), config.getSmtpPassword());
				}
			};
			Session session = Session.getDefaultInstance(props, auth);
			session.setDebug(true);
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(config.getFrom()));
			
			List<InternetAddress> addressTo = new LinkedList<>();
			addressTo.add(new InternetAddress(address));
			msg.setRecipients(Message.RecipientType.TO, addressTo.toArray(new InternetAddress[addressTo.size()]));
			
			List<InternetAddress> blindTo = new LinkedList<>();
			blindTo.add(new InternetAddress(config.getFrom()));
			msg.setRecipients(Message.RecipientType.BCC, blindTo.toArray(new InternetAddress[blindTo.size()]));
			
			msg.setSentDate(new Date());
			msg.setHeader("Content-Transfer-Encoding", "8bit");
			msg.setHeader("Content-Type", "text/html; charset=utf-8");
			msg.setSubject(subject, "utf-8");
			msg.setText(message, "utf-8", "html");
			Transport.send(msg);
			log.debug("Message sent to {}", address);
		} catch (MessagingException e) {
			throw new MailSenderExcetion("Error sending message to " + address, e);
		}
	}

}
