package com.tlf.ExpenseShare.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "grouplist")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Group_ID")
    private int groupId;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CreatorID", referencedColumnName = "User_ID")
    private User user;



    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

