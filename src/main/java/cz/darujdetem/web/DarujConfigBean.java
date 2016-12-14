/**
 * 
 */
package cz.darujdetem.web;

/**
 * @author Martin Strejc
 *
 */
public class DarujConfigBean  
{

	private final String adminUser;
	
	private final String adminPassword;
	
	/**
	 * Because of Wicket proxies 
	 */
	public DarujConfigBean() {
		this(null, null);
	}

	public DarujConfigBean(String adminUser, String adminPassword)
	{
		this.adminUser = adminUser;
		this.adminPassword = adminPassword;
	}

	public String getAdminUser()
	{
		return adminUser;
	}

	public String getAdminPassword()
	{
		return adminPassword;
	}
	
}
