package com.example.JlptFocusApp.Repository.User;

import com.example.JlptFocusApp.Entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AuthenticateRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
