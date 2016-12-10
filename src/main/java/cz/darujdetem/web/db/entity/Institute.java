package cz.darujdetem.web.db.entity;

import org.apache.ibatis.type.Alias;

/**
 * @author Martin Strejc
 *
 */
@Alias("Institute")
public class Institute extends NameId
{

	private static final long serialVersionUID = 1L;

	public Institute()
	{
		super();
	}

	public Institute(Long id, String name)
	{
		super(id, name);
	}
	
	
}
