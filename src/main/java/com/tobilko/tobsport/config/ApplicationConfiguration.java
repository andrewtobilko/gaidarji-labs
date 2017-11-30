package com.tobilko.tobsport.config;

import com.tobilko.tobsport.entity.Employee;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Created by Andrew Tobilko on 11/30/17.
 */
@Configuration
public class ApplicationConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration configuration) {
        configuration.exposeIdsFor(Employee.class);
    }

}