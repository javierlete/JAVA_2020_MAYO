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
@ConfigurationProperties("spring.datasource-write")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryWrite",
        transactionManagerRef = "transactionManagerWrite",
        basePackages = {"com.ipartek.formacion.spring.ejemplomultipledatasources.repositorios.exportacion"}
)
public class DataSourceConfigWrite extends HikariConfig {

    public final static String PERSISTENCE_UNIT_NAME = "write";

    @Bean
    public HikariDataSource dataSourceWrite() {
        return new HikariDataSource(this);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryWrite(
            final HikariDataSource dataSourceWrite) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSourceWrite);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(EjemplomultipledatasourcesApplication.MODEL_PACKAGE);
            setJpaProperties(new Properties() {
        		private static final long serialVersionUID = -7687270585872239808L;

        		{
        			put("hibernate.dialect", "org.hibernate.dialect.MySQL57InnoDBDialect");
        			put("hibernate.hbm2ddl.auto", "create");
        			put("hibernate.ddl-auto", "create");
        			put("show-sql", "true");
        		}
        	});
        }};
    }

    @Bean
    public PlatformTransactionManager transactionManagerWrite(EntityManagerFactory entityManagerFactoryWrite) {
        return new JpaTransactionManager(entityManagerFactoryWrite);
    }
}