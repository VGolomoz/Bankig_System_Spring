package project.model;

import javax.persistence.*;

@Entity
public class OperationHistory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "operationHistory")
    private UserAccount userDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserAccount getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserAccount userDetails) {
        this.userDetails = userDetails;
    }

    public OperationHistory() {
    }
}
