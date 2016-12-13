/**
 * 
 */
package cz.darujdetem.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * @author martin
 *
 */
@Configuration
@Import({MailJeeConfig.class, ApplicationContextConfig.class, DataAccessConfig.class, ServiceConfig.class})
@EnableAspectJAutoProxy
public class DarujDetemConfig {
	

}
