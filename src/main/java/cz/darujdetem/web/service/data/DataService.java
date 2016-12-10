/**
 * 
 */
package cz.darujdetem.web.service.data;

import java.util.List;

import cz.darujdetem.web.db.entity.Institute;
import cz.darujdetem.web.db.entity.Person;

/**
 * @author Martin Strejc
 *
 */
public interface DataService
{
	
	List<Institute> getInstitutes();

	Institute getInstituteAndGifts(long instituteId);

	Person getPersonByGift(long giftId);
	
}
