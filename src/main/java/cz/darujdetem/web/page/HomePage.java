package cz.darujdetem.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import cz.darujdetem.web.db.entity.Institute;
import cz.darujdetem.web.service.DataService;

/**
 * @author Martin Strejc
 *
 */
public class HomePage extends WebPage
{

	private static final long serialVersionUID = 1L;
	
	@SpringBean
	private DataService dataService;
	
	public HomePage()
	{
		super();
		
		add(new PropertyListView<Institute>("institute", new ListModel<>(dataService.getInstitutes()))
		{

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Institute> item)
			{
				item.queue(InstitutePage.bookmarkablePageLink("link", item.getModelObject()));
				item.queue(new Label("name"));				
			}
			
		});
	}

}
