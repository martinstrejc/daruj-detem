package cz.darujdetem.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import cz.darujdetem.web.db.entity.Institute;
import cz.darujdetem.web.db.entity.Present;
import cz.darujdetem.web.service.DataService;

/**
 * @author Martin Strejc
 *
 */
public class InstitutePage extends WebPage
{

	private static final long serialVersionUID = 1L;

	@SpringBean
	private DataService dataService;

	public InstitutePage(PageParameters params)
	{
		super();

		Institute institute = dataService.getInstitute(params.get("id").toLong());
		
		add(new PropertyListView<Present>("present", new ListModel<>(dataService.getPresents(institute)))
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
