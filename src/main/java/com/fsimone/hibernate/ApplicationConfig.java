package com.fsimone.hibernate;

import java.util.Properties;

import javax.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.fsimone.hibernate"
})
public class ApplicationConfig {
    private static final Logger LOG = LogManager.getLogger(ApplicationConfig.class);

    @Autowired
    private Environment env;

	private ApplicationContext context;


    public ApplicationConfig() {
    	LOG.info("Application config constructor!");
    	//LOG.info("env: {}", env.toString()); // Environment is null because is in the constructor
    }

    @PostConstruct
    public void log() {
    	LOG.info("Application config post constructor!");
    	LOG.info("env: {}", env.getProperty("welcome.message"));              // Environment is not null
    }


    @Bean
	public ApplicationContext setApplicationContext(ApplicationContext context) {
		this.context = context;
		return this.context;
	}

    @Bean
    public LocalSessionFactoryBean sessionFactory()
    {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan(new String[] {"com.fsimone.hibernate.entity"});
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        hibernateProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        hibernateProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        sessionFactory.setHibernateProperties(hibernateProperties);
        //this.sessionFactory = (SessionFactory) sessionFactory;
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

}
