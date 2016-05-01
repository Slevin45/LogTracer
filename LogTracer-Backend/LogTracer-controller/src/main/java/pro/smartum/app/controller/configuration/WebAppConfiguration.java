package pro.smartum.app.controller.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import pro.smartum.app.business.configuration.ServiceConfiguration;
import pro.smartum.app.controller.security.AuthInterceptor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
@Import({ServiceConfiguration.class})
@EnableWebMvc
@ComponentScan(basePackages = {"pro.smartum.app.controller"})
@EnableTransactionManagement
public class WebAppConfiguration extends WebMvcConfigurerAdapter {
    private static final String PROPERTY_NAME_RESOURCE_HANDLER = "/WEB-INF/pages/**";
    private static final String PROPERTY_NAME_RESOURCE_LOCATION = "/pages/";
    private static final String PROPERTY_NAME_PREFIX = "/WEB-INF/pages/";
    private static final String PROPERTY_NAME_SUFFIX = ".jsp";
    private static final String PROPERTY_NAME_WELCOME_FILE = "index";

    @Autowired
    private AuthInterceptor authInterceptor;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/").setCachePeriod(0);
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {

        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**");
    }

}