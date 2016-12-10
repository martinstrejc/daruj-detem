package cz.darujdetem.web.page;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringBean;

import cz.darujdetem.web.db.entity.Donor;
import cz.darujdetem.web.service.data.DataService;

/**
 * @author Martin Strejc
 *
 */
public class ThankYouPage extends WebPage
{

	private static final long serialVersionUID = 1L;

	@SpringBean
	@SuppressWarnings("squid:S1948")
	private DataService dataService;

	public ThankYouPage(Donor donor)
	{
		
		WebMarkupContainer don = new WebMarkupContainer("donor", new CompoundPropertyModel<>(donor));
		add(don);
		
		don.add(new Label("name"));
		don.add(new Label("institute.name"));
		
		
	}

	public static void mount(WebApplication application)
	{
		application.mountPage("podekovani-za-darek", ThankYouPage.class);
	}
	
}
