package entities.bills_payment_system;

import javax.persistence.*;

@Entity
@Inheritance
public abstract class BillingDetail {
    private int number;
    private User user;

    protected BillingDetail() {
    }

    @Id
    @GeneratedValue
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
