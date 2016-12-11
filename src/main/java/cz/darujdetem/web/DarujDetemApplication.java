package cz.darujdetem.web;

import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import cz.darujdetem.web.page.DesignPage;
import cz.darujdetem.web.page.GiftPage;
import cz.darujdetem.web.page.HomePage;
import cz.darujdetem.web.page.InstitutePage;
import cz.darujdetem.web.page.ThankYouPage;
import cz.darujdetem.web.security.DarujDetemSession;

/**
 * @author Martin Strejc
 *
 */
public class DarujDetemApplication extends AuthenticatedWebApplication implements ApplicationContextAware
{
	private ApplicationContext context;
	
	@Override
	protected void init()
	{
		super.init();
		
		getComponentInstantiationListeners().add(new SpringComponentInjector(this, context));
		
		mountPage("home", HomePage.class);
		InstitutePage.mount(this);
		GiftPage.mount(this);
		ThankYouPage.mount(this);
		
		DesignPage.mount(this);
		
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException
	{
		this.context = context;

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
