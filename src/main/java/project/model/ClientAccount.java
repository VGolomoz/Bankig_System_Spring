package project.model;

import project.util.Currency;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class ClientAccount {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Double balance;

    @Column
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(nullable = false)
    private Date validity;

    @OneToOne(mappedBy = "clientAccount")
    private Client client;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn (name="clientDetails_id")
    private ClientDetails clientDetails;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn (name="deposit_id")
    private Deposit deposit;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn (name="credit_id")
    private Credit credit;

    @OneToMany(mappedBy = "clientAccount")
    private List<Operation> operations = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientDetails getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void addOperations(Operation operation) {
        operations.add(operation);
        operation.setClientAccount(this);
    }

    public ClientAccount() {
    }
}
