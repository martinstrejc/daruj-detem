package cz.darujdetem.web.page;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

import cz.darujdetem.web.db.entity.Donor;
import cz.darujdetem.web.db.entity.Gift;
import cz.darujdetem.web.db.entity.Person;
import cz.darujdetem.web.model.CzechYearUnitModel;
import cz.darujdetem.web.service.data.DataService;

/**
 * @author Martin Strejc
 *
 */
@SuppressWarnings("squid:MaximumInheritanceDepth")
public class GiftPage extends AbstractDesignPage
{

	private static final long serialVersionUID = 1L;

	private static final IValidator<Boolean> TERMS_VALIDATOR = new TermsValidator();

	@SpringBean
	@SuppressWarnings("squid:S1948")
	private DataService dataService;

	public GiftPage(PageParameters params)
	{
		super(params);

		Person person = dataService.getPersonByGift(getGiftId());
		
		WebMarkupContainer pers = new WebMarkupContainer("person", new CompoundPropertyModel<>(person));
		add(pers);
		
		pers.queue(new Label("name"));
		pers.queue(new Label("institute.name"));
		pers.queue(new Label("gift.name"));
		pers.queue(new Label("age"));
		pers.queue(new Label("ageUnit", new CzechYearUnitModel(Model.of(person.getAge()))));
		
		
		Donor donor = new Donor();
		donor.setPerson(person);
		
		pers.queue(new DonorForm("donor", donor));
		
	}

	public static void mount(WebApplication application)
	{
		application.mountPage("chci-darovat-darek/${id}/${name}", GiftPage.class);
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
		return new BookmarkablePageLink<>(id, GiftPage.class, linkParameters(gift));
	}
	
	private class DonorForm extends Form<Donor> {

		
		private static final long serialVersionUID = 1L;

		public DonorForm(String id, Donor donor)
		{
			super(id, new CompoundPropertyModel<>(donor));
			
			add(new FeedbackPanel("feedbackPanel"));
			
			add(new EmailTextField("email").setRequired(true));
			add(new TextField<String>("name").setRequired(false));
			add(new TextField<String>("phone").setRequired(false));
			add(new CheckBox("termsConfirmed").add(TERMS_VALIDATOR).setRequired(true));
			add(new Button("submit"));
		}
		
		@Override
		protected void onSubmit()
		{
			Donor donor = getModelObject();
			setResponsePage(new GiftMailSentPage(donor));
		}
		
	}
	
	private static class TermsValidator implements IValidator<Boolean> {

		private static final long serialVersionUID = 1L;

		@Override
		public void validate(IValidatable<Boolean> validatable)
		{
			if (!validatable.getValue()) {
				validatable.error(new ValidationError("Souhlas s všeobecnými podmínkami je nutný k pokračování."));
			}
			
		}
		
	}
	
}
