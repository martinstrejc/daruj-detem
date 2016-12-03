/**
 * 
 */
package cz.darujdetem.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cz.darujdetem.web.DarujDetemApplication;
import cz.darujdetem.web.service.DataService;
import cz.darujdetem.web.service.impl.DataServiceImpl;

/**
 * @author martin
 *
 */
@Configuration
public class ApplicationContextConfig {

	@Bean
	public DarujDetemApplication application() {
		return new DarujDetemApplication();
	}
	
	@Bean
	public DataService dataService() {
		return new DataServiceImpl();
	}
		
}
