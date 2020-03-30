package models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Component
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "account")
    private String account;

    @ManyToOne()
    @JoinColumn(name = "id_client")
    private Client client;

    public Accounts() {
    }

    public Accounts(String account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
