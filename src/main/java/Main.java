import ServiceDAO.ServiceDAO;
import config.ConfigClass;
import models.Accounts;
import models.Client;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
        SessionFactory sessionFactory = context.getBean("sessionFactory", SessionFactory.class);
    }

    public static void test3() {
        ServiceDAO serviceDAO = new ServiceDAO();
        Client client = serviceDAO.getClient(6);
        System.out.println(client.getName());
        System.out.println(client.getDr());
        System.out.println(client.getAccounts());
    }

    public static void test() {
        ServiceDAO serviceDAO = new ServiceDAO();
        Client client = new Client("dimas2");
        Accounts accounts = new Accounts("12345");
        client.addAccounts(accounts);
        serviceDAO.save(client);
    }

    public static void test2() {
        ServiceDAO serviceDAO = new ServiceDAO();
        List<Client> list = serviceDAO.getAllClients();
        System.out.println(list);
    }
}
