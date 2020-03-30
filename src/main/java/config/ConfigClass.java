package config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class ConfigClass {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/test3");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public SessionFactory sessionFactory(DataSource dataSource) {

        final LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("models");
        final Properties property = new Properties();
        property.setProperty("hibernate.dialect",
                "org.hibernate.dialect.H2Dialect");
        property.setProperty("hibernate.show_sql", "true");
        property.setProperty("hibernate.hbm2ddl", "validate");
        factoryBean.setHibernateProperties(property);
        return factoryBean.getObject();
    }

    @Bean
    public HibernateTransactionManager transactionManager
            (DataSource dataSource, SessionFactory sessionFactory) {
        final HibernateTransactionManager tr =
                new HibernateTransactionManager();
        tr.setDataSource(dataSource);
        tr.setSessionFactory(sessionFactory);
        return tr;
    }


}
