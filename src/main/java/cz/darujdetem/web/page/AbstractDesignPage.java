package cz.darujdetem.web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author Martin Strejc
 *
 */
public abstract class AbstractDesignPage extends WebPage
{

	private static final long serialVersionUID = 1L;
	

	public AbstractDesignPage()
	{
		super();
	}


	public AbstractDesignPage(IModel<?> model)
	{
		super(model);
	}


	public AbstractDesignPage(PageParameters parameters)
	{
		super(parameters);
	}


}
