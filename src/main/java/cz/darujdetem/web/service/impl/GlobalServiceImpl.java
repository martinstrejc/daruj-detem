/**
 * 
 */
package cz.darujdetem.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.darujdetem.web.db.dao.GeneralDao;
import cz.darujdetem.web.service.GlobalService;

/**
 * @author Martin Strejc
 *
 */
@Service
public class GlobalServiceImpl implements GlobalService
{

	private final GeneralDao generalDao;

	@Autowired
	public GlobalServiceImpl(GeneralDao generalDao)
	{
		this.generalDao = generalDao;
	}
	
	
	
}
