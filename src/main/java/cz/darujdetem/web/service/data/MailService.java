/**
 * 
 */
package cz.darujdetem.web.service.data;

import cz.darujdetem.web.db.entity.Donor;

/**
 * @author Martin Strejc
 *
 */
public interface MailService
{

	void sendGiftConfirmation(Donor donor, String activationLink);

	void sendGiftDetails(Donor donor);

}
