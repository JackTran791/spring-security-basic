package com.luv2code.cmr.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @author Jack Tran
 */
@Configuration
@PropertySource("classpath:persistence-mysql.properties")
public class DatabaseConfig {

    @Autowired
    private Environment env;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public DataSource securityDatasource() {

        // Create connection pool
        ComboPooledDataSource securityDatasource = new ComboPooledDataSource();

        // Set the JDBC driver class
//        try {
//            securityDatasource.setDriverClass(env.getProperty("jdbc.driver"));
//        } catch (PropertyVetoException ex) {
//            throw new RuntimeException(ex);
//        }

        // Log the connection pool
        logger.info(">>> jdbc.url: " + env.getProperty("jdbc.url"));
        logger.info(">>> jdbc.user: " + env.getProperty("jdbc.user"));

        // Set database connection props
        securityDatasource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDatasource.setUser(env.getProperty("jdbc.user"));
        securityDatasource.setPassword(env.getProperty("jdbc.password"));

        // Set connection pool props
        securityDatasource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDatasource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDatasource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDatasource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return securityDatasource;
    }

    // Need a help method
    // Read environment property and convert to int
    private int getIntProperty(String propName) {
        String propVal = env.getProperty(propName);
        return Integer.parseInt(Objects.requireNonNull(propVal));
    }
}
