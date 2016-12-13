package cz.darujdetem.web.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.DataGridView;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.util.StringUtils;

import cz.darujdetem.web.db.entity.Gift;
import cz.darujdetem.web.db.entity.Institute;
import cz.darujdetem.web.db.entity.Person;
import cz.darujdetem.web.model.CzechYearUnitModel;
import cz.darujdetem.web.service.data.DataService;

/**
 * @author Martin Strejc
 *
 */
@SuppressWarnings("squid:MaximumInheritanceDepth")
public class InstitutePage extends AbstractDesignPage
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
		inst.add(new Label("address"));
		inst.add(new Label("city"));
		inst.add(new Label("zip"));
		inst.add(new Label("web"));
		
		List<ICellPopulator<TwoPersons>> populators = new LinkedList<>();
		populators.add(new TwoPersonPopulator((tp) -> tp.getLeft()));
		populators.add(new TwoPersonPopulator((tp) -> tp.getRight()));
		inst.add(new DataGridView<>("personGrid", populators, new TwoPersonDataProvider(institute.getPersons())));
		
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
		return new BookmarkablePageLink<>(id, InstitutePage.class, linkParameters(institute));
	}
	
	
	private class GiftPanel extends Panel {

		private static final long serialVersionUID = 1L;

		public GiftPanel(String id, IModel<Person> model)
		{
			super(id, model);
			Person p = model.getObject();
			Gift g = p.getGift();
			WebMarkupContainer link;
			if (g == null) {
				link = new WebMarkupContainer("link");
			} else {
				link = GiftPage.bookmarkablePageLink("link", g);
			}
			add(link);
			add(new Label("name"));
			add(new Label("gift.note"));
			add(new Label("gift.name"));
			
			WebMarkupContainer male = new WebMarkupContainer("male");
			male.add(new AttributeAppender("class", offerIcon(p.getMale())).setSeparator(" "));
			add(male);
			male.add(new Label("age"));
			male.add(new Label("ageUnit", new CzechYearUnitModel(Model.of(p.getAge()))));
			
			
			// FIXME building the path
			String relativePath  = "/img/" + (StringUtils.isEmpty(g.getImg()) ? "" : g.getImg() );
			
			
			link.add(new WebMarkupContainer("img").add(new AttributeModifier("src", RequestCycle.get().getRequest().getContextPath() + relativePath)));
			
			
		}
		
	}
	
	private class TwoPersons implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		private Person left;
		private Person right;
		
		public Person getLeft()
		{
			return left;
		}
		
		public void setLeft(Person left)
		{
			this.left = left;
		}
		
		public Person getRight()
		{
			return right;
		}
		
		public void setRight(Person right)
		{
			this.right = right;
		}
		
	}
	
	private class TwoPersonPopulator implements ICellPopulator<TwoPersons> {

		private static final long serialVersionUID = 1L;
		
		private final Function<TwoPersons, Person> personResolver;
		
		public TwoPersonPopulator(Function<TwoPersons, Person> personResolver)
		{
			this.personResolver = personResolver;
		}

		@Override
		public void detach()
		{
			// do nothing
		}

		@Override
		public void populateItem(Item<ICellPopulator<TwoPersons>> cellItem, String componentId,
			IModel<TwoPersons> rowModel)
		{
			Person p = personResolver.apply(rowModel.getObject());
			cellItem.add(p == null ? new WebMarkupContainer(componentId) :
				new GiftPanel(componentId, new CompoundPropertyModel<>(p)));
		}
		
	}
	
	private class TwoPersonDataProvider implements IDataProvider<TwoPersons> {
		
		private static final long serialVersionUID = 1L;
		
		private List<TwoPersons> list;
		
		public TwoPersonDataProvider(List<Person> persons)
		{
			list = new ArrayList<>(1 + persons.size() / 2);
			TwoPersons tp = null;
			for (Person p : persons) {
				if (tp == null) {
					tp = new TwoPersons();
					list.add(tp);
					tp.setLeft(p);
				} else {
					tp.setRight(p);
					tp = null;
				}
			}
		}

		@Override
		public Iterator<? extends TwoPersons> iterator(long first, long count)
		{
			return list.iterator();
		}

		@Override
		public long size()
		{
			return list.size();
		}

		@Override
		public IModel<TwoPersons> model(TwoPersons object)
		{
			return Model.of(object);
		}
		
	}

}
