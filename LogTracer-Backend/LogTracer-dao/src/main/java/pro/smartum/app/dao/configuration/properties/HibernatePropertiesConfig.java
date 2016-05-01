package pro.smartum.app.dao.configuration.properties;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class HibernatePropertiesConfig implements HibernateProperties {

    @Override
    public Map<String, String> propertiesMap() {
        Map<String, String> propertiesMap = new HashMap<>();
        propertiesMap.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        propertiesMap.put("hibernate.connection.charSet", "UTF-8");
        propertiesMap.put("hibernate.show_sql", "true");
        return propertiesMap;
    }

}
