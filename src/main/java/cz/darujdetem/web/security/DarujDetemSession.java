package cz.darujdetem.web.security;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;

import cz.darujdetem.web.DarujConfigBean;

/**
 * @author Martin Strejc
 *
 */
public class DarujDetemSession extends AuthenticatedWebSession
{

	private static final long serialVersionUID = 1L;
	
	private final Roles roles = new Roles(Roles.ADMIN);
		
	@SpringBean
	@SuppressWarnings("squid:S1948")
	private DarujConfigBean darujConfigBean;

	public DarujDetemSession(Request request)
	{
		super(request);
		Injector.get().inject(this);
	}

	@Override
	protected boolean authenticate(String username, String password)
	{
		return darujConfigBean.getAdminUser().equals(username) && darujConfigBean.getAdminPassword().equals(password);
	}

	@Override
	public Roles getRoles()
	{
		return isSignedIn() ? roles : null;
	}

}
