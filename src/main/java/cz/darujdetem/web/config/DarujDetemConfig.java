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
@Import({ApplicationContextConfig.class})
// @Import({ApplicationContextConfig.class, DataAccessConfig.class})
@EnableAspectJAutoProxy
public class DarujDetemConfig {

}
