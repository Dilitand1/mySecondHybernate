package ServiceDAO;

import DAO.HyperDao;
import DAO.HyperDaoImpl;
import models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceDAO {

    @Autowired
    HyperDao hyperDao;

    public ServiceDAO() {

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

    public void setHyperDao(HyperDao hyperDao) {
        this.hyperDao = hyperDao;
    }
}
