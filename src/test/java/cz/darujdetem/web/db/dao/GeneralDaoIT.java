package cz.darujdetem.web.db.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cz.darujdetem.web.config.DataAccessConfig;
import cz.darujdetem.web.db.entity.Institute;
import cz.darujdetem.web.test_conf.JndiPostgresDataSourceInitilizer;

@ContextConfiguration(classes={DataAccessConfig.class}, initializers = {JndiPostgresDataSourceInitilizer.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GeneralDaoIT extends AbstractJUnit4SpringContextTests 
{
	
	@Autowired
	private GeneralDao generalDao;

	@Test
	public void selectInstitutes()
	{
		List<Institute> institutes = generalDao.selectInstitutes();
		assertEquals("List of Institutes size", 3, institutes.size());
	}

	@Test
	public void selectInstituteGifts()
	{
		generalDao.selectInstituteGifts(1L);
	}

}
