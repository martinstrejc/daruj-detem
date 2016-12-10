package cz.darujdetem.web.db.entity;

import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * @author Martin Strejc
 *
 */
@Alias("Institute")
@SuppressWarnings("squid:S2160")
public class Institute extends EntityNameId
{

	private static final long serialVersionUID = 1L;
	
	private List<Person> persons;

	public Institute()
	{
		super();
	}

	public Institute(Long id, String name)
	{
		super(id, name);
	}

	public List<Person> getPersons()
	{
		return persons;
	}

	public void setPersons(List<Person> persons)
	{
		this.persons = persons;
	}
	
}
