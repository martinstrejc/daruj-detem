/**
 * 
 */
package cz.darujdetem.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cz.darujdetem.web.DarujDetemApplication;

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
		
}
