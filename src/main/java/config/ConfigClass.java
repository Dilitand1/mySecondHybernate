package config;

import DAO.HyperDaoImpl;
import ServiceDAO.ServiceDAO;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScans({
        @ComponentScan("DAO"),
        @ComponentScan("ServiceDAO")
})
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
    public SessionFactory sessionFactory() {
        // Create the ServiceRegistry from hibernate.cfg.xml
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
                .configure("hibernate.cfg.xml").build();
        // Create a metadata sources using the specified service registry.
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
    }

    @Bean
    public ServiceDAO serviceDAO(){
        return new ServiceDAO();
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
