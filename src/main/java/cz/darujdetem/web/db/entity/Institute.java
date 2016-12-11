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
	
	private String address;
	
	private String city;
	
	private String zip;
	
	private String contactPerson;
	
	private String phone;
	
	private String email;
	
	private String web;
		
	private String designNum;
	
	private List<Person> persons;

	public Institute()
	{
		super();
	}

	public Institute(Long id, String name)
	{
		super(id, name);
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getZip()
	{
		return zip;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
	}

	public String getContactPerson()
	{
		return contactPerson;
	}

	public void setContactPerson(String contactPerson)
	{
		this.contactPerson = contactPerson;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getWeb()
	{
		return web;
	}

	public void setWeb(String web)
	{
		this.web = web;
	}

	public String getDesignNum()
	{
		return designNum;
	}

	public void setDesignNum(String designNum)
	{
		this.designNum = designNum;
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
