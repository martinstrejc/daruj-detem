package cz.darujdetem.web;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.pages.SignInPage;
import org.apache.wicket.authroles.authentication.pages.SignOutPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import cz.darujdetem.web.page.DesignPage;
import cz.darujdetem.web.page.GiftConfirmationPage;
import cz.darujdetem.web.page.GiftMailSentPage;
import cz.darujdetem.web.page.GiftPage;
import cz.darujdetem.web.page.HomePage;
import cz.darujdetem.web.page.InstitutePage;
import cz.darujdetem.web.page.admin.AdminPage;
import cz.darujdetem.web.page.error.NotFoundPage;
import cz.darujdetem.web.security.DarujDetemSession;

/**
 * @author Martin Strejc
 *
 */
public class DarujDetemApplication extends AuthenticatedWebApplication implements ApplicationContextAware
{
	
	@Resource(mappedName = "wicket.configuration")
	private String wicketConfiguration;
	
	private ApplicationContext context;
	
	@PostConstruct
	public void postConstruct() {
		setConfigurationType("DEVELOPMENT".equalsIgnoreCase(wicketConfiguration) ? RuntimeConfigurationType.DEVELOPMENT : RuntimeConfigurationType.DEPLOYMENT);
	}
	
	@Override
	protected void init()
	{
		
		super.init();

		getComponentInstantiationListeners().add(new SpringComponentInjector(this, context));
		
		HomePage.mount(this);
		InstitutePage.mount(this);
		GiftPage.mount(this);
		GiftMailSentPage.mount(this);
		GiftConfirmationPage.mount(this);
		
		mountPage("secure/login", SignInPage.class);
		mountPage("secure/logout", SignOutPage.class);
		AdminPage.mount(this);
		
		NotFoundPage.mount(this);
		getApplicationSettings().setPageExpiredErrorPage(NotFoundPage.class);
		
		DesignPage.mount(this);
		
	}

	@Override
	public void setApplicationContext(ApplicationContext context) 
	{
		this.context = context;

	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass()
	{
		return SignInPage.class;
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
