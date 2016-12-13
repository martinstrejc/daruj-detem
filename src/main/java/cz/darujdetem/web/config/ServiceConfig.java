package cz.darujdetem.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cz.darujdetem.web.db.dao.GeneralDao;
import cz.darujdetem.web.service.GlobalService;
import cz.darujdetem.web.service.impl.GlobalServiceImpl;

/**
 * @author Martin Strejc
 *
 */
@Configuration
public class ServiceConfig {

	@Bean
	@Autowired
	public GlobalService globalService(GeneralDao generalDao) {
		return new GlobalServiceImpl(generalDao);
	}
	

}
