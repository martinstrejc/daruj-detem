/**
 * 
 */
package cz.darujdetem.web.service.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.darujdetem.web.db.dao.GeneralDao;
import cz.darujdetem.web.db.entity.Institute;
import cz.darujdetem.web.db.entity.Person;
import cz.darujdetem.web.service.data.DataService;

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

	@Override
	public Person getPersonByGift(long giftId)
	{
		return generalDao.selectPersonByGift(giftId);
	}

}
