package cz.darujdetem.web.page;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringBean;

import cz.darujdetem.web.db.entity.Donor;
import cz.darujdetem.web.model.CzechYearUnitModel;
import cz.darujdetem.web.service.GlobalService;

/**
 * @author Martin Strejc
 *
 */
@SuppressWarnings("squid:MaximumInheritanceDepth")
public class GiftMailSentPage extends AbstractDesignPage
{

	private static final long serialVersionUID = 1L;

	@SpringBean
	@SuppressWarnings("squid:S1948")
	private GlobalService globalService;

	public GiftMailSentPage(Donor donor)
	{
		super();
		
		globalService.donorChoosesGift(donor, GiftConfirmationPage.absoluteAddress());

		WebMarkupContainer pers = new WebMarkupContainer("person", new CompoundPropertyModel<>(donor.getPerson()));
		add(pers);
		
		pers.queue(new Label("name"));
		pers.queue(new Label("institute.name"));
		pers.queue(new Label("gift.name"));
		pers.queue(new Label("age"));
		pers.queue(new Label("ageUnit", new CzechYearUnitModel(Model.of(donor.getPerson().getAge()))));
		
	}

	public static void mount(WebApplication application)
	{
		application.mountPage("odeslani-info-mailu-o-darku", GiftMailSentPage.class);
	}
	
}
