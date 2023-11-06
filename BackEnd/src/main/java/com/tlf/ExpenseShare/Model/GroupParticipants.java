package com.tlf.ExpenseShare.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Group_participant")
public class GroupParticipants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Groupparticipant_ID")
    private int groupparticipantId;

    @ManyToOne
    @JoinColumn(name = "User_UId", referencedColumnName = "User_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Group_GId", referencedColumnName = "Group_ID")
    private Group group;

    public int getGroupparticipantId() {
        return groupparticipantId;
    }

    public void setGroupparticipantId(int groupparticipantId) {
        this.groupparticipantId = groupparticipantId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
