package cz.darujdetem.web.page;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.util.ListModel;

import cz.darujdetem.web.db.entity.Institute;

/**
 * @author Martin Strejc
 *
 */
public class HomePage extends WebPage
{

	private static final long serialVersionUID = 1L;
	
	public HomePage()
	{
		super();
		List<Institute> insts = new LinkedList<>();
		
		insts.add(new Institute(1L, "Detsky domov Pysely"));
		insts.add(new Institute(2L, "Domov Slany"));
		insts.add(new Institute(3L, "Institut pro deti Rakovnik"));
		
		add(new PropertyListView<Institute>("institute", new ListModel<>(insts))
		{

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Institute> item)
			{
				item.queue(new BookmarkablePageLink<>("link", InstitutePage.class));
				item.queue(new Label("name"));				
			}
		});
	}

}
