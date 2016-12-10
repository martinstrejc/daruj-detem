/**
 * 
 */
package cz.darujdetem.web.service.data.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.darujdetem.web.db.entity.Institute;
import cz.darujdetem.web.service.data.DataService;
import cz.darujdetem.web.db.dao.GeneralDao;
import cz.darujdetem.web.db.entity.Gift;

/**
 * @author Martin Strejc
 *
 */
@Service
public class DataServiceImpl implements DataService
{
	
	@Autowired
	private GeneralDao generalDao;

	@Override
	public List<Institute> getInstitutes()
	{
		return generalDao.selectInstitutes();
	}
	
	@Override
	public Institute getInstituteAndGifts(long instituteId) {
		return generalDao.selectInstituteGifts(instituteId);
	}

	@Deprecated
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
