package com.tlf.ExpenseShare.Repository;

import com.tlf.ExpenseShare.Model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group,Integer> {
//    List<Group> findByCreatorId(int id);
}
