package pro.smartum.app.business.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pro.smartum.app.dao.configuration.RepositoryConfig;

/**
 * Created by eldar.s on 21.04.2016.
 */
@Configuration
@ComponentScan(basePackages = { "pro.smartum.app.business" })
@Import({ RepositoryConfig.class })
public class ServiceConfiguration {
}
