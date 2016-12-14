/**
 * 
 */
package cz.darujdetem.web.service.impl;

import java.io.Serializable;

/**
 * @author Martin Strejc
 *
 */
public class MailConfigBean implements Serializable
{

	private static final long serialVersionUID = 1L;

	private final String from;

	private final String smtpHost;

	private final String smtpUser;
	
	private final String smtpPassword;
	
	private final Integer smtpPort;

	public MailConfigBean(String from, String smtpHost, String smtpUser, String smtpPassword, Integer smtpPort)
	{
		super();
		this.from = from;
		this.smtpHost = smtpHost;
		this.smtpUser = smtpUser;
		this.smtpPassword = smtpPassword;
		this.smtpPort = smtpPort;
	}

	public String getFrom()
	{
		return from;
	}

	public String getSmtpHost()
	{
		return smtpHost;
	}

	public Integer getSmtpPort()
	{
		return smtpPort;
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
