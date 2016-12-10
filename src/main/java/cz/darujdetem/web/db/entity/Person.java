package cz.darujdetem.web.db.entity;

import org.apache.ibatis.type.Alias;

/**
 * @author Martin Strejc
 *
 */
@Alias("Person")
@SuppressWarnings("squid:S2160")
public class Person extends EntityNameId
{

	private static final long serialVersionUID = 1L;
	
	private Gift gift;

	public Person()
	{
		super();
	}

	public Person(Long id, String name)
	{
		super(id, name);
	}

	public Gift getGift()
	{
		return gift;
	}

	public void setGift(Gift gift)
	{
		this.gift = gift;
	}
	
}