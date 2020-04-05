package DAO;

        import ServiceDAO.ServiceDAO;
        import factory.HibernateFactory;
        import models.Client;
        import org.hibernate.Session;
        import org.hibernate.Transaction;
        import org.springframework.stereotype.Component;

        import java.util.List;

@Component
public class HyperDaoImpl implements HyperDao {
    @Override
    public Client getClient(int id) {
        //return HibernateFactory.getSessionFactory().openSession().get(Client.class,id);
        Session session = HibernateFactory.getSessionFactory().openSession();
        Client client = session.get(Client.class,id);
        session.close();
        return client;
    }

    @Override
    public void update(Client client) {
        Session session = HibernateFactory.getSessionFactory().openSession();
        session.update(client);
        session.close();
    }

    @Override
    public void save(Client client) {
        Session session = HibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }

    @Override
    public void merge(Client client) {
        Session session = HibernateFactory.getSessionFactory().openSession();
        session.merge(client);
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> list = (List<Client>)HibernateFactory.getSessionFactory().openSession().createQuery("Select cl from Client as cl where cl.id > 1").list();
        return list;
    }

    @Override
    public void delClient(Client client) {
        Session session = HibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(client);
        transaction.commit();
        session.close();
    }

}
