package cz.darujdetem.web.page;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.util.ListModel;

import cz.darujdetem.web.db.entity.Present;

/**
 * @author Martin Strejc
 *
 */
public class InstitutePage extends WebPage
{

	private static final long serialVersionUID = 1L;
	
	public InstitutePage()
	{
		super();
		List<Present> insts = new LinkedList<>();
		
		insts.add(new Present("Pavel Novak"));
		insts.add(new Present("Jirka Kubes"));
		insts.add(new Present("Norman Fidel"));
		insts.add(new Present("Lidl Frankenstein"));
		insts.add(new Present("Ota Soukar"));
		
		add(new PropertyListView<Present>("present", new ListModel<>(insts))
		{

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Present> item)
			{
				item.queue(new Label("name"));
			}
		});
	}

}
