package com.hb.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by raju on 25/5/16.
 */
@Configuration
public class DatabaseConfig {
  @Autowired
  Environment environment;

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
    dataSource.setUrl(environment.getProperty("spring.datasource.url"));
    dataSource.setUsername(environment.getProperty("spring.datasource.username"));
    dataSource.setPassword(environment.getProperty("spring.datasource.password"));
    return dataSource;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactoryBean.setDataSource(dataSource());
    sessionFactoryBean.setPackagesToScan(environment.getProperty("entitymanager.packagesToScan"));
    Properties hibernateProperties = new Properties();
    hibernateProperties.put("hibernate.dialect", environment.getProperty("spring.jpa.database-platform"));
    hibernateProperties.put("hibernate.show_sql", environment.getProperty("spring.jpa.show-sql"));
    hibernateProperties.put("hibernate.hbm2ddl.auto", environment.getProperty("spring.jpa.hibernate.ddl-auto"));
    sessionFactoryBean.setHibernateProperties(hibernateProperties);
    return sessionFactoryBean;
  }

  @Bean
  public HibernateTransactionManager transactionManager() {
    HibernateTransactionManager transactionManager =
        new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
  }

}
