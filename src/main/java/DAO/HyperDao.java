package DAO;

import models.Client;

import java.util.List;

public interface HyperDao {
    public Client getClient(int id);
    public void update(Client client);
    public void save(Client client);
    public void merge(Client client);
    public List<Client> getAllClients();
    public void delClient(Client client);

}
