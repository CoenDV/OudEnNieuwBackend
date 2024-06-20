package com.CoenDV.OudNieuw.Repositories;

import com.CoenDV.OudNieuw.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
