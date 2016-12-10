package cz.darujdetem.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import cz.darujdetem.web.db.entity.Institute;
import cz.darujdetem.web.service.data.DataService;
import cz.darujdetem.web.db.entity.Gift;

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

		add(new PropertyListView<Gift>("present",
			new ListModel<>(dataService.getPresents(institute)))
		{

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Gift> item)
			{
				item.queue(new Label("name"));
			}
		});
	}

	public static void mount(WebApplication application)
	{
		application.mountPage("domov/${id}/${name}", InstitutePage.class);
	}

	public static PageParameters linkParameters(Institute institute)
	{
		return new PageParameters()
			.add("id", institute.getId())
			.add("name", institute.getName());
	}
	
	public static BookmarkablePageLink<InstitutePage> bookmarkablePageLink(String id, Institute institute) {
		return new BookmarkablePageLink<>(id, InstitutePage.class, InstitutePage.linkParameters(institute));
	}

}
