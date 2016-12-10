package cz.darujdetem.web.page;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import cz.darujdetem.web.db.entity.Gift;
import cz.darujdetem.web.db.entity.Person;
import cz.darujdetem.web.service.data.DataService;

/**
 * @author Martin Strejc
 *
 */
public class GiftPage extends WebPage
{

	private static final long serialVersionUID = 1L;

	@SpringBean
	@SuppressWarnings("squid:S1948")
	private DataService dataService;

	public GiftPage(PageParameters params)
	{
		super(params);

		Person person = dataService.getPersonByGift(getGiftId());
		
		WebMarkupContainer pers = new WebMarkupContainer("person", new CompoundPropertyModel<>(person));
		add(pers);
		
		pers.add(new Label("name"));
		
	}

	public static void mount(WebApplication application)
	{
		application.mountPage("domov/${id}/${name}", GiftPage.class);
	}
	
	public long getGiftId() {
		return getPageParameters().get("id").toLong();
	}

	public static PageParameters linkParameters(Gift gift)
	{
		return new PageParameters()
			.add("id", gift.getId())
			.add("name", gift.getName());
	}
	
	public static BookmarkablePageLink<GiftPage> bookmarkablePageLink(String id, Gift gift) {
		return new BookmarkablePageLink<>(id, GiftPage.class, GiftPage.linkParameters(gift));
	}
	
}
