/**
 * 
 */
package cz.darujdetem.web.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import cz.darujdetem.web.db.entity.Institute;

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
	
}
