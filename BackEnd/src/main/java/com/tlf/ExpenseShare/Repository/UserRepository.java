package com.tlf.ExpenseShare.Repository;

import com.tlf.ExpenseShare.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByUserId(Long userId);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
