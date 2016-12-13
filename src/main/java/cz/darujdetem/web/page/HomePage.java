package cz.darujdetem.web.page;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringBean;

import cz.darujdetem.web.db.entity.Institute;
import cz.darujdetem.web.service.data.DataService;

/**
 * @author Martin Strejc
 *
 */
@SuppressWarnings("squid:MaximumInheritanceDepth")
public class HomePage extends AbstractDesignPage
{

	private static final long serialVersionUID = 1L;
	
	@SpringBean
	@SuppressWarnings("squid:S1948")
	private DataService dataService;
	
	public HomePage()
	{
		super();
		
		add(new PropertyListView<Institute>("institute", new ListModel<>(dataService.getInstitutes())) // NOSONAR
		{

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Institute> item)
			{
				Institute i = item.getModelObject();
				item.queue(InstitutePage.bookmarkablePageLink("link", i));
				item.queue(new Label("name"));
				item.queue(new Label("address"));
				item.queue(new Label("city"));
				item.queue(new Label("zip"));
				item.queue(new WebMarkupContainer("img").add(new AttributeModifier("src", IMG_ROOT + "o5.png")));
			}
			
		});
	}
	
	public static void mount(WebApplication application)
	{
		application.mountPage("/detske-domovy", HomePage.class);
	}


}
