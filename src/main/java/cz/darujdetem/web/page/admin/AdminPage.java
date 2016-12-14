/**
 * 
 */
package cz.darujdetem.web.page.admin;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringBean;

import cz.darujdetem.web.db.dao.GeneralDao;
import cz.darujdetem.web.db.entity.Donor;

/**
 * @author Martin Strejc
 *
 */
@AuthorizeInstantiation(Roles.ADMIN)
public class AdminPage extends WebPage
{

	private static final long serialVersionUID = 1L;
	
	@SpringBean
	@SuppressWarnings("squid:S1948")
	private GeneralDao generalDao;

	public AdminPage()
	{
		super();
		
		List<IColumn<Donor, Donor>> cols = new LinkedList<>();
		cols.add(new PropertyColumn<>(Model.of("Datum"), "termsConfirmedDate"));
		cols.add(new PropertyColumn<>(Model.of("ID blokace"), "id"));
		cols.add(new PropertyColumn<>(Model.of("Email"), "email"));
		cols.add(new PropertyColumn<>(Model.of("Jmeno darce"), "name"));
		cols.add(new PropertyColumn<>(Model.of("Telefon darce"), "phone"));
		cols.add(new PropertyColumn<>(Model.of("Cislo darku"), "person.gift.id"));
		cols.add(new PropertyColumn<>(Model.of("Nazev darku"), "person.gift.name"));
		cols.add(new PropertyColumn<>(Model.of("Poznamka k darku"), "person.gift.note"));
		
		DefaultDataTable<Donor, Donor> table = new DefaultDataTable<>("donors", cols, new DataProvider(), Integer.MAX_VALUE);
		add(table);
	}

	private class DataProvider extends SortableDataProvider<Donor, Donor>
	{

		private static final long serialVersionUID = 1L;

		@Override
		public Iterator<? extends Donor> iterator(long first, long count)
		{
			return generalDao.selectDonors().iterator();
		}

		@Override
		public long size()
		{
			return generalDao.selectDonorsCount();
		}

		@Override
		public IModel<Donor> model(Donor object)
		{
			return Model.of(object);
		}
		
	}
	
	public static void mount(WebApplication application) {
		application.mountPage("admin", AdminPage.class);
	}
}
