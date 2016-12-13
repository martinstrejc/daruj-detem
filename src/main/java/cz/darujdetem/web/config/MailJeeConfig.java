package cz.darujdetem.web.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cz.darujdetem.web.service.impl.MailConfigBean;

/**
 * @author Martin Strejc
 *
 */
@Configuration
public class MailJeeConfig {

	@Resource(mappedName = "mail.from")
	private String from;
	
	@Resource(mappedName = "mail.smtp.host")
	private String smtpHost;
	
	@Resource(mappedName = "mail.smtp.user")
	private String smtpUser;
	
	@Resource(mappedName = "mail.smtp.password")
	private String smtpPassword;

	@Resource(mappedName = "mail.smtp.port")
	private Integer smtpPort;

	@Bean
	public MailConfigBean mailConfigBean() {
		return new MailConfigBean(from, smtpHost, smtpUser, smtpPassword, smtpPort);
	}
	

}
