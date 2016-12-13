/**
 * 
 */
package cz.darujdetem.web.model;

import org.apache.wicket.model.IModel;

/**
 * @author Martin Strejc
 *
 */
public class CzechYearUnitModel implements IModel<String>
{

	private static final long serialVersionUID = 1L;
	
	private final IModel<Integer> yearModel;

	public CzechYearUnitModel(IModel<Integer> yearModel)
	{
		this.yearModel = yearModel;
	}


	@Override
	public String getObject()
	{
		return int2yearUnit(yearModel.getObject());
	}
	
	@SuppressWarnings("squid:MethodCyclomaticComplexity")
	public static String int2yearUnit(Integer year) {
		if (year == null || year < 0) {
			return null;
		}
		switch (year)
		{
			case 1 :
				return "rok";
			case 2 :
			case 3 :
			case 4 :
				return "roky";
			default :
				return "let";
		}
		
	}

}
