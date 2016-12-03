package cz.darujdetem.web.db.entity;

import java.io.Serializable;

/**
 * @author Martin Strejc
 *
 */
public class Id implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private Long id;

	public Id() {
		this(null);
	}

	public Id(Long id)
	{
		super();
		this.id = id;
	}
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}

}
