/**
 * 
 */
package cz.darujdetem.web.service.impl;

import java.util.LinkedList;
import java.util.List;

import cz.darujdetem.web.db.entity.Institute;
import cz.darujdetem.web.db.entity.Present;
import cz.darujdetem.web.service.DataService;

/**
 * @author Martin Strejc
 *
 */
public class DataServiceImpl implements DataService
{

	@Override
	public List<Institute> getInstitutes()
	{
		List<Institute> institutes = new LinkedList<>();
		institutes.add(new Institute(1L, "Detsky domov Pysely"));
		institutes.add(new Institute(2L, "Domov Slany"));
		institutes.add(new Institute(3L, "Institut pro deti Rakovnik"));
		return institutes;
	}

	@Override
	public Institute getInstitute(long id)
	{
		return id == 1L ? new Institute(1L, "Detsky domov Pysely") : null;
	}

	@Override
	public List<Present> getPresents(Institute institute)
	{
		if (institute.getId() != 1L) {
			return new LinkedList<>();
		}
		List<Present> presents = new LinkedList<>();
		
		presents.add(new Present(1L, "Pavel Novak"));
		presents.add(new Present(2L, "Jirka Kubes"));
		presents.add(new Present(3L, "Norman Fidel"));
		presents.add(new Present(4L, "Lidl Frankenstein"));
		presents.add(new Present(5L, "Ota Soukar"));
		return presents;
	}

}
