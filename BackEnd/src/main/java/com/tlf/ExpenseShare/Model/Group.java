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

    @Column(name = "CreatorID")
    private Long creatorId;



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

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }
}

