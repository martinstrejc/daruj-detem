package cz.darujdetem.web.security;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

/**
 * @author Martin Strejc
 *
 */
public class DarujDetemSession extends AuthenticatedWebSession
{

	private static final long serialVersionUID = 1L;

	public DarujDetemSession(Request request)
	{
		super(request);
	}

	@Override
	protected boolean authenticate(String username, String password)
	{
		// FIXME admin/admin
		return "admin".equals(username) && "admin.1234".equals(password);
	}

	@Override
	public Roles getRoles()
	{
		return isSignedIn() ? new Roles(Roles.ADMIN) : null;
	}

}
