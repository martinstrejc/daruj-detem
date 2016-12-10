package cz.darujdetem.web.db.entity;

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
	
	@Override
	protected ToStringHelper toStringHelper()
	{
		return super.toStringHelper()
			.add("email", email)
			.add("phone", phone);
	}
	
}
