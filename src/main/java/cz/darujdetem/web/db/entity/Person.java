package cz.darujdetem.web.db.entity;

import org.apache.ibatis.type.Alias;

/**
 * @author Martin Strejc
 *
 */
@Alias("Person")
public class Person extends NameId
{

	private static final long serialVersionUID = 1L;

	public Person()
	{
		super();
	}

	public Person(Long id, String name)
	{
		super(id, name);
	}


}
