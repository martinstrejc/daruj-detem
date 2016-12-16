package cz.darujdetem.web.page.error;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringBean;

import cz.darujdetem.web.page.AbstractDesignPage;
import cz.darujdetem.web.service.data.DataService;

/**
 * @author Martin Strejc
 *
 */
@SuppressWarnings("squid:MaximumInheritanceDepth")
public class LinkExpiredPage extends AbstractDesignPage
{

	private static final long serialVersionUID = 1L;
	
	@SpringBean
	@SuppressWarnings("squid:S1948")
	private DataService dataService;
	
	public LinkExpiredPage()
	{
		super();
		
		add(new BookmarkablePageLink<>("backHp", getApplication().getHomePage()));
	}
	
	public static void mount(WebApplication application)
	{
		application.mountPage("/odkaz-vyprsel", LinkExpiredPage.class);
	}


}
