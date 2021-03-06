package com.ipartek.formacion.spring.ejemplomultipledatasources.configuraciones;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ipartek.formacion.spring.ejemplomultipledatasources.EjemplomultipledatasourcesApplication;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ConfigurationProperties("spring.datasource-read")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryRead",
        transactionManagerRef = "transactionManagerRead",
        basePackages = {"com.ipartek.formacion.spring.ejemplomultipledatasources.repositorios.importacion"}
)
public class DataSourceConfigRead extends HikariConfig {

    public final static String PERSISTENCE_UNIT_NAME = "read";

    @Bean
    public HikariDataSource dataSourceRead() {
        return new HikariDataSource(this);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryRead(
            final HikariDataSource dataSourceRead) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSourceRead);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(EjemplomultipledatasourcesApplication.MODEL_PACKAGE);
            setJpaProperties(new Properties() {
        		private static final long serialVersionUID = -7687270585872239808L;

        		{
        			put("hibernate.dialect", "org.hibernate.dialect.MySQL57InnoDBDialect");
        			put("hibernate.hbm2ddl.auto", "none");
        			put("hibernate.ddl-auto", "none");
        			put("show-sql", "true");
        		}
        	});
        }};
    }

    @Bean
    public PlatformTransactionManager transactionManagerRead(EntityManagerFactory entityManagerFactoryRead) {
        return new JpaTransactionManager(entityManagerFactoryRead);
    }
}