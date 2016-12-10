package cz.darujdetem.web.db.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.google.common.base.MoreObjects.ToStringHelper;

/**
 * @author Martin Strejc
 *
 */
@Alias("Donor")
@SuppressWarnings("squid:S2160")
public class Donor extends EntityNameId
{

	private static final long serialVersionUID = 1L;
	
	private String email;
	
	private String phone;
	
	private Boolean termsConfirmed;
	
	private Date termsConfirmedDate;
	
	private Person person;
	
	public Donor()
	{
		super();
	}

	public Donor(Long id, String name)
	{
		super(id, name);
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public Boolean getTermsConfirmed()
	{
		return termsConfirmed;
	}

	public void setTermsConfirmed(Boolean termsConfirmed)
	{
		this.termsConfirmed = termsConfirmed;
	}

	public Date getTermsConfirmedDate()
	{
		return termsConfirmedDate;
	}

	public void setTermsConfirmedDate(Date termsConfirmedDate)
	{
		this.termsConfirmedDate = termsConfirmedDate;
	}

	public Person getPerson()
	{
		return person;
	}

	public void setPerson(Person person)
	{
		this.person = person;
	}

	@Override
	protected ToStringHelper toStringHelper()
	{
		return super.toStringHelper()
			.add("email", email)
			.add("phone", phone)
			.add("termsConfirmed", termsConfirmed)
			.add("termsConfirmedDate", termsConfirmedDate);
	}
	
}
