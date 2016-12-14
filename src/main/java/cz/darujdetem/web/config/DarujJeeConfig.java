package cz.darujdetem.web.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cz.darujdetem.web.DarujConfigBean;

/**
 * @author Martin Strejc
 *
 */
@Configuration
public class DarujJeeConfig {

	@Resource(mappedName = "admin.user")
	private String adminUser;
	
	@Resource(mappedName = "admin.password")
	private String adminPassword;
	
	@Bean
	public DarujConfigBean darujConfigBean() {
		return new DarujConfigBean(adminUser, adminPassword);
	}

}
