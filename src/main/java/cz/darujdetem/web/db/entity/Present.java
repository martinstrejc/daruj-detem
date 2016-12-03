/**
 * 
 */
package cz.darujdetem.web.db.entity;

import java.io.Serializable;

/**
 * @author Martin Strejc
 *
 */
public class Present implements Serializable
{

	private static final long serialVersionUID = 1L;

	private String name;
	
	public Present()
	{
	}

	public Present(String name)
	{
		super();
		this.name = name;
	}


	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	

}
