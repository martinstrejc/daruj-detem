package cz.darujdetem.web.db.entity;

/**
 * @author Martin Strejc
 *
 */
public class NameId extends Id
{

	private static final long serialVersionUID = 1L;
	
	private String name;

	
	public NameId()
	{
		super();
	}

	public NameId(Long id, String name)
	{
		super(id);
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
