package project.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class OpReplenishment extends Operation {

    @Column
    private Date date;

    @Column
    private Double amount;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public OpReplenishment() {
    }
}
