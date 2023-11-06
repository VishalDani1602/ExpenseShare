package com.tlf.ExpenseShare.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Transaction_ID")
    private int transactionId;

    @Column(name = "Amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "User_From", referencedColumnName = "User_ID")
    private User userFrom;

    @ManyToOne
    @JoinColumn(name = "User_To", referencedColumnName = "User_ID")
    private User userTo;

    @ManyToOne
    @JoinColumn(name = "Expense_EID", referencedColumnName = "Expense_ID")
    private Expense expense;

    @ManyToOne
    @JoinColumn(name = "Group_GId", referencedColumnName = "Group_ID")
    private Group group;

    public int getTransactionId() {
        return transactionId;
    }

    public int getAmount() {
        return amount;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public Expense getExpense() {
        return expense;
    }

    public Group getGroup() {
        return group;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
