/**
 * 
 */
package cz.darujdetem.web.service;

import java.util.List;

import cz.darujdetem.web.db.entity.Institute;
import cz.darujdetem.web.db.entity.Present;

/**
 * @author Martin Strejc
 *
 */
public interface DataService
{
	
	List<Institute> getInstitutes();

	Institute getInstitute(long id);
	
	List<Present> getPresents(Institute institute);

}
