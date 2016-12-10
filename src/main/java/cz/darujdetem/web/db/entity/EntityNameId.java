package cz.darujdetem.web.db.entity;

import com.google.common.base.MoreObjects.ToStringHelper;

/**
 * @author Martin Strejc
 *
 */
@SuppressWarnings("squid:S2160")
public class EntityNameId extends EntityId
{

	private static final long serialVersionUID = 1L;
	
	private String name;

	
	public EntityNameId()
	{
		super();
	}

	public EntityNameId(Long id, String name)
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
	
	@Override
	protected ToStringHelper toStringHelper()
	{
		return super.toStringHelper()
			.add("name", name);
	}

}
