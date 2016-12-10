/**
 * 
 */
package cz.darujdetem.web.service.impl;

import java.util.LinkedList;
import java.util.List;

import cz.darujdetem.web.db.entity.Institute;
import cz.darujdetem.web.db.entity.Gift;
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
	public List<Gift> getPresents(Institute institute)
	{
		if (institute.getId() != 1L) {
			return new LinkedList<>();
		}
		List<Gift> presents = new LinkedList<>();
		
		presents.add(new Gift(1L, "Pavel Novak"));
		presents.add(new Gift(2L, "Jirka Kubes"));
		presents.add(new Gift(3L, "Norman Fidel"));
		presents.add(new Gift(4L, "Lidl Frankenstein"));
		presents.add(new Gift(5L, "Ota Soukar"));
		return presents;
	}

}
