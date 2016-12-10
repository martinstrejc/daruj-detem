package cz.darujdetem.web.db.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cz.darujdetem.web.config.DataAccessConfig;
import cz.darujdetem.web.db.entity.Institute;
import cz.darujdetem.web.db.entity.Person;
import cz.darujdetem.web.test_conf.JndiPostgresDataSourceInitilizer;

@ContextConfiguration(classes={DataAccessConfig.class}, initializers = {JndiPostgresDataSourceInitilizer.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GeneralDaoIT extends AbstractJUnit4SpringContextTests 
{
	
	private static final Logger log = LoggerFactory.getLogger(GeneralDaoIT.class);
	
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
		Institute inst = generalDao.selectInstituteGifts(1L);
		log.debug("inst: {}", inst);
		assertEquals((Object)1L, inst.getId());
		List<Person> p = inst.getPersons();
		assertEquals("List of Persons at the Institute size", 5, p.size());
		log.debug("person 1: {}", inst.getPersons().get(0));
		assertEquals((Object)2L, p.get(0).getId());
	}
	
	@Test
	public void selectPersonByGift() {
		Person person = generalDao.selectPersonByGift(1L);
		log.debug("person: {}", person);
		assertEquals((Object)1L, person.getId());
	}

}
