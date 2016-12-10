package cz.darujdetem.web.page;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import cz.darujdetem.web.db.entity.Gift;
import cz.darujdetem.web.db.entity.Institute;
import cz.darujdetem.web.db.entity.Person;
import cz.darujdetem.web.service.data.DataService;

/**
 * @author Martin Strejc
 *
 */
public class InstitutePage extends WebPage
{

	private static final long serialVersionUID = 1L;

	@SpringBean
	@SuppressWarnings("squid:S1948")
	private DataService dataService;

	public InstitutePage(PageParameters params)
	{
		super(params);

		Institute institute = dataService.getInstituteAndGifts(getInstituteId());
		
		WebMarkupContainer inst = new WebMarkupContainer("institute", new CompoundPropertyModel<>(institute));
		add(inst);
		
		inst.add(new Label("name"));

		inst.add(new PersonListView("persons"));
		
	}

	public static void mount(WebApplication application)
	{
		application.mountPage("domov/${id}/${name}", InstitutePage.class);
	}
	
	public long getInstituteId() {
		return getPageParameters().get("id").toLong();
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
	
	
	@SuppressWarnings("squid:MaximumInheritanceDepth")
	private class PersonListView extends PropertyListView<Person> {

		private static final long serialVersionUID = 1L;

		public PersonListView(String id)
		{
			super(id);
		}
		
		@Override
		protected void populateItem(ListItem<Person> item)
		{
			Gift g = item.getModelObject().getGift();
			if (g == null) {
				item.queue(new WebMarkupContainer("link"));
			} else {
				item.queue(GiftPage.bookmarkablePageLink("link", g));
			}
			
			item.queue(new Label("name"));
			item.queue(new Label("gift.name"));
		}
		
	}

}
