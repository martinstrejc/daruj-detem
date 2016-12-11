package cz.darujdetem.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * @author Martin Strejc
 *
 */
public class DesignPage extends WebPage
{

	private static final long serialVersionUID = 1L;
	
	public DesignPage()
	{
		super();
		
	}

	public static void mount(WebApplication application)
	{
		application.mountPage("design", DesignPage.class);
	}

}
