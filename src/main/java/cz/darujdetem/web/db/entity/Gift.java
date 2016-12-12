package cz.darujdetem.web.db.entity;

import org.apache.ibatis.type.Alias;

/**
 * @author Martin Strejc
 *
 */
@Alias("Gift")
public class Gift extends EntityNameId
{

	private static final long serialVersionUID = 1L;
	
	private String note;

	public Gift()
	{
		super();
	}

	public Gift(Long id, String name)
	{
		super(id, name);
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}
	

}
