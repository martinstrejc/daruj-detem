/**
 * 
 */
package cz.darujdetem.web.service.data;

import java.util.List;

import cz.darujdetem.web.db.entity.Institute;

/**
 * @author Martin Strejc
 *
 */
public interface DataService
{
	
	List<Institute> getInstitutes();

	Institute getInstituteAndGifts(long instituteId);
	
}
