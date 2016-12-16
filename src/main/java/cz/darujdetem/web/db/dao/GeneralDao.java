/**
 * 
 */
package cz.darujdetem.web.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import cz.darujdetem.web.db.entity.Donor;
import cz.darujdetem.web.db.entity.Institute;
import cz.darujdetem.web.db.entity.Person;

/**
 * @author Martin Strejc
 *
 */
public interface GeneralDao
{

	@Select("SELECT * FROM institute ORDER BY name ASC")
	@ResultType(Institute.class)
	List<Institute> selectInstitutes();

	Institute selectInstituteGifts(long instituteId);

	Person selectPersonByGift(long giftId);
	
	long insertDonor(Donor donor);
	
	Donor selectDonor(String hash);
	
	Long updateGiftDonorship(@Param("giftId") long giftId, @Param("donorId") long donorId);

		
	@Select("SELECT count(*) FROM donor")
	Long selectDonorsCount();
	
	List<Donor> selectDonors();
	
}
