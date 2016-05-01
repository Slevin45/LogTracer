package pro.smartum.app.dao.configuration.datasource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: Loki
 * Date: 17.04.16
 * Time: 0:11
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class TestDataSource {
    private static final String PROPERTY_NAME_DRIVER = "org.postgresql.Driver";
    private static final String PROPERTY_NAME_URL = "jdbc:postgresql:logTracer";
    private static final String PROPERTY_NAME_USER = "postgres";
    private static final String PROPERTY_NAME_PASSWORD = "fotboll1995";

    @Bean
    public DataSource datasource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(PROPERTY_NAME_DRIVER);
        dataSource.setUrl(PROPERTY_NAME_URL);
        dataSource.setUsername(PROPERTY_NAME_USER);
        dataSource.setPassword(PROPERTY_NAME_PASSWORD);

        return dataSource;
    }
}
