package factory;

import models.Accounts;
import models.Client;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateFactory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
                        .configure("hibernate.cfg.xml").build();
                // Create a metadata sources using the specified service registry.
                Metadata metadata = new MetadataSources(serviceRegistry)
                        .addAnnotatedClass(Client.class)
                        .addAnnotatedClass(Accounts.class)
                        .getMetadataBuilder().build();
                return metadata.getSessionFactoryBuilder().build();

                //Или так
                /*Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Accounts.class);
                configuration.addAnnotatedClass(Client.class);
                StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

                 */
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
