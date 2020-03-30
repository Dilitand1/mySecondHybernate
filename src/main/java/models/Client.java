package models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CLIENT")
@SecondaryTables({
        @SecondaryTable(name = "CLIENT_DR")
})
@Component
public final class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(table = "CLIENT_DR",name = "DR")
    public Date dr;

    @Column(name = "name")
    public String name;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval = true)
    List<Accounts> accounts;

    public Client(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    public Client(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAccounts(Accounts accounts) {
        accounts.setClient(this);
        this.accounts.add(accounts);
    }

    public Date getDr() {
        return dr;
    }

    public void setDr(Date dr) {
        this.dr = dr;
    }

    public List<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }
}
