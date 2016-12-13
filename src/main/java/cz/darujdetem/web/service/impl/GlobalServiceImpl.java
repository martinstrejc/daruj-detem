package cz.darujdetem.web.service.impl;

import java.util.Date;
import java.util.UUID;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

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
	public void donorChoosesGift(Donor donor, String url)
	{
		
		// FIXME check terms confirmed
		Date date = new Date();
		
		donor.setTermsConfirmedDate(date);
		donor.setHash(newHash(date));
		
		mailService.sendGiftConfirmation(donor);
	}
	
	public static String newHash(Date date) {
		return Hashing.sha1().hashString(newHashBase(date), Charsets.UTF_8).toString();
	}
	
	public static String newHashBase(Date date) {
		return UUID.randomUUID().toString() + date.toString();
	}
		
}
