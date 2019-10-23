package se.maetsskogfeldt.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "accounts")
public class Account { //implements Serializable {
    // private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "AccountId")

    private Long id;


    @Column(name = "AccountBalance")
    private Double balance;

    public Account() {

    }

    public Account(Builder builder) {
        this.id = Objects.requireNonNull(builder.id);
        this.balance = Objects.requireNonNull(builder.balance);
    }

    public Long getId() {
        return id;
    }

    public Double getBalance() {
        return balance;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }

    public static class Builder {
        private Long id;
        private Double balance;

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withBalance(Double balance) {
            this.balance = balance;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
