package com.tlf.ExpenseShare.Repository;

import com.tlf.ExpenseShare.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
