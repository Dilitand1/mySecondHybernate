package ServiceDAO;

import DAO.HyperDao;
import DAO.HyperDaoImpl;
import models.Client;

import java.util.List;

public class ServiceDAO {

    HyperDao hyperDao;

    public ServiceDAO() {
        this.hyperDao = new HyperDaoImpl();
    }

    public Client getClient(int id) {
        return hyperDao.getClient(id);
    }


    public void update(Client client) {
        hyperDao.update(client);
    }


    public void save(Client client) {
        hyperDao.save(client);
    }


    public void merge(Client client) {
        hyperDao.merge(client);
    }


    public List<Client> getAllClients() {
        return hyperDao.getAllClients();
    }

    public void delClient(Client client)
    {
        hyperDao.delClient(client);
    }
}
