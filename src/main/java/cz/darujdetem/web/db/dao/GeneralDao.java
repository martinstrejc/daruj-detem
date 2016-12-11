/**
 * 
 */
package cz.darujdetem.web.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import cz.darujdetem.web.db.entity.Institute;
import cz.darujdetem.web.db.entity.Person;

/**
 * @author Martin Strejc
 *
 */
public interface GeneralDao
{

	@Select("SELECT * FROM institute WHERE id > 999 ORDER BY name ASC")
	@ResultType(Institute.class)
	List<Institute> selectInstitutes();

	Institute selectInstituteGifts(long instituteId);

	Person selectPersonByGift(long giftId);
	
}
