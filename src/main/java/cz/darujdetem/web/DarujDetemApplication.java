package cz.darujdetem.web;

import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import cz.darujdetem.web.page.HomePage;
import cz.darujdetem.web.security.DarujDetemSession;

/**
 * @author Martin Strejc
 *
 */
public class DarujDetemApplication extends AuthenticatedWebApplication implements ApplicationContextAware
{

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass()
	{
		return DarujDetemSession.class;
	}

	@Override
	public Class<? extends Page> getHomePage()
	{
		return HomePage.class;
	}

}
