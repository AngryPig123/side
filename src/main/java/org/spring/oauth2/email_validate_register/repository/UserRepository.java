package org.spring.oauth2.email_validate_register.repository;

import org.spring.oauth2.email_validate_register.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserEmail(String userEmail);
}
