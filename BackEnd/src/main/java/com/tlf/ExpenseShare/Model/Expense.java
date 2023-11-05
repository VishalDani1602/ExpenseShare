package com.tlf.ExpenseShare.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Expense_ID")
    private int expenseId;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "User_UId", referencedColumnName = "User_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Group_GId", referencedColumnName = "Group_ID")
    private Group group;

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public Group getGroup() {
        return group;
    }

    public Integer getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}
