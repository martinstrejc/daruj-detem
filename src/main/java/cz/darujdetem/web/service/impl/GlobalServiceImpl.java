/**
 * 
 */
package cz.darujdetem.web.service.impl;

import java.util.Date;

import cz.darujdetem.web.db.dao.GeneralDao;
import cz.darujdetem.web.db.entity.Donor;
import cz.darujdetem.web.service.GlobalService;
import cz.darujdetem.web.service.data.MailService;

/**
 * @author Martin Strejc
 *
 */
public class GlobalServiceImpl implements GlobalService
{

	private final GeneralDao generalDao;
	
	private final MailService mailService;

	public GlobalServiceImpl(GeneralDao generalDao, MailService mailService)
	{
		this.generalDao = generalDao;
		this.mailService = mailService;
	}

	@Override
	public void donorChoosesGift(Donor donor)
	{
		// FIXME check terms confirmed
		donor.setTermsConfirmedDate(new Date());
		
		mailService.sendGiftConfirmation(donor);
	}
	
	
	
}
