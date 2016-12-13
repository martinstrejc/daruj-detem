/**
 * 
 */
package cz.darujdetem.web.service;

/**
 * @author Martin Strejc
 *
 */
public class MailSenderExcetion extends Exception
{

	private static final long serialVersionUID = 1L;

	public MailSenderExcetion()
	{
		// emtpy
	}

	/**
	 * @param message
	 */
	public MailSenderExcetion(String message)
	{
		super(message);
	}

	/**
	 * @param cause
	 */
	public MailSenderExcetion(Throwable cause)
	{
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MailSenderExcetion(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public MailSenderExcetion(String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
