package cz.darujdetem.web.db.entity;

import org.apache.ibatis.type.Alias;

/**
 * @author Martin Strejc
 *
 */
@Alias("Gift")
public class Gift extends NameId
{

	private static final long serialVersionUID = 1L;

	public Gift()
	{
		super();
	}

	public Gift(Long id, String name)
	{
		super(id, name);
	}


}
