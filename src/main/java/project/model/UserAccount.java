package project.model;

import project.util.Currency;
import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private Long balance;

    @Column
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(nullable = false)
    private Date validity;

    @OneToOne(mappedBy = "userAccount")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn (name="userDetails_id")
    private UserDetails userDetails;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn (name="deposit_id")
    private Deposit deposit;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn (name="credit_id")
    private Credit credit;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn (name="operationHistory_id")
    private OperationHistory operationHistory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public OperationHistory getOperationHistory() {
        return operationHistory;
    }

    public void setOperationHistory(OperationHistory operationHistory) {
        this.operationHistory = operationHistory;
    }

    public UserAccount() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(user, that.user) &&
                Objects.equals(balance, that.balance) &&
                currency == that.currency &&
                Objects.equals(validity, that.validity) &&
                Objects.equals(userDetails, that.userDetails) &&
                Objects.equals(deposit, that.deposit) &&
                Objects.equals(credit, that.credit) &&
                Objects.equals(operationHistory, that.operationHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, balance, currency, validity, userDetails, deposit, credit, operationHistory);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", user=" + user +
                ", balance=" + balance +
                ", currency=" + currency +
                ", validity=" + validity +
                ", userDetails=" + userDetails +
                ", deposit=" + deposit +
                ", credit=" + credit +
                ", operationHistory=" + operationHistory +
                '}';
    }
}
