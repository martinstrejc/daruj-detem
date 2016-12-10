package cz.darujdetem.web.db.entity;

import java.io.Serializable;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;

/**
 * @author Martin Strejc
 *
 */
public class EntityId implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private Long id;

	public EntityId() {
		this(null);
	}

	public EntityId(Long id)
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityId other = (EntityId)obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	protected ToStringHelper toStringHelper() {
		return MoreObjects.toStringHelper(this)
			.add("id", id);
	}
	
	@Override
	public String toString()
	{
		return toStringHelper().toString();
	}

}
