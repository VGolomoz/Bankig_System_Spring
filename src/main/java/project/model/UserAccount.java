package project.model;

import project.util.Currency;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private Double balance;

    @Column
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(nullable = false)
    private Date validity;

    @OneToOne(mappedBy = "userAccount")
    private Client client;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn (name="userDetails_id")
    private UserDetails userDetails;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn (name="deposit_id")
    private Deposit deposit;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn (name="credit_id")
    private Credit credit;

    @OneToMany(mappedBy = "userAccount")
    private List<Operation> operations;

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

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
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
    }

    public UserAccount() {
    }
}
