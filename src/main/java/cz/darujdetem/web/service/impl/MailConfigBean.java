/**
 * 
 */
package cz.darujdetem.web.service.impl;

/**
 * @author Martin Strejc
 *
 */
public class MailConfigBean
{

	private final String from;

	private final String smtpHost;

	private final String smtpUser;
	
	private final String smtpPassword;

	public MailConfigBean(String from, String smtpHost, String smtpUser, String smtpPassword)
	{
		super();
		this.from = from;
		this.smtpHost = smtpHost;
		this.smtpUser = smtpUser;
		this.smtpPassword = smtpPassword;
	}

	public String getFrom()
	{
		return from;
	}

	public String getSmtpHost()
	{
		return smtpHost;
	}

	public String getSmtpUser()
	{
		return smtpUser;
	}

	public String getSmtpPassword()
	{
		return smtpPassword;
	}
	
}
