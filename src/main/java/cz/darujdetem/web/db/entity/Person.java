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
	
	private Institute institute;
	
	private Boolean male;
	
	private Integer age;

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

	public Institute getInstitute()
	{
		return institute;
	}

	public void setInstitute(Institute institute)
	{
		this.institute = institute;
	}

	public Boolean getMale()
	{
		return male;
	}

	public void setMale(Boolean male)
	{
		this.male = male;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}
	
	

}
