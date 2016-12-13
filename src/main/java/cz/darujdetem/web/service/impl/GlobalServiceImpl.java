/**
 * 
 */
package cz.darujdetem.web.service.impl;

import cz.darujdetem.web.db.dao.GeneralDao;
import cz.darujdetem.web.service.GlobalService;

/**
 * @author Martin Strejc
 *
 */
public class GlobalServiceImpl implements GlobalService
{

	private final GeneralDao generalDao;

	public GlobalServiceImpl(GeneralDao generalDao)
	{
		this.generalDao = generalDao;
	}
	
	
	
}
