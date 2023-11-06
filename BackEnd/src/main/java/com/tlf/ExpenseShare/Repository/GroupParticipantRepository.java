package com.tlf.ExpenseShare.Repository;

import com.tlf.ExpenseShare.Model.GroupParticipants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupParticipantRepository extends JpaRepository<GroupParticipants,Integer> {
}
