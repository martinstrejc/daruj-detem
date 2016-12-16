/**
 * 
 */
package cz.darujdetem.web.page;

/**
 * @author Martin Strejc
 *
 */
public class MissingGiftException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public MissingGiftException()
	{
		// default constructor
	}

	/**
	 * @param message
	 */
	public MissingGiftException(String message)
	{
		super(message);
	}

	/**
	 * @param cause
	 */
	public MissingGiftException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MissingGiftException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public MissingGiftException(String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
